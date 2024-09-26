package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;


/*
 * REST(Representational State Transfer) : API를 설계하는 아키텍처
 * 
 * RESTful  : REST 원칙을 준수하는 방식
 * API(Application Programming Interface) : 서로 다른 애플리케이션들이 서로 데이터를 주고 받을 수 있게 하는 도구
 * */
@RestController
@RequestMapping("/api/*") // http://localhost"8080/api/
public class BoardController {
	

	@Autowired
	private BoardService service;
	
	// 파일 업로드 메서드
	public String FileUpload(MultipartFile file) throws IllegalStateException, IOException {
		if(file == null||file.getOriginalFilename() == "") {
			System.out.println("NULL 리턴");
			return null;
		}
		UUID uuid = UUID.randomUUID(); // 랜덤 파일명 부여
		String fileName = uuid.toString()+"_" + file.getOriginalFilename();
		File copyFile = new File("\\\\192.168.10.51\\damoim\\seongchul\\" + fileName);
		file.transferTo(copyFile);
		System.out.println("파일1개 추가!");
		return fileName;
	}
	
	// 파일 삭제 메서드
	public void FileDelete(String file) throws IllegalStateException, IOException {
		if(file == null) {
			System.out.println("삭제할 파일이 없습니다");
		}
		else {
			System.out.println("삭제될 URL : "  + file);
		File f = new File("\\\\192.168.10.51\\damoim\\seongchul\\" + file);
		f.delete();
		
		}
	}
	
	// CRUD Create - Post, Read - Get, Update - Put , Delete - Delete
	
	// Create - Post
	@PostMapping("/board")
	public ResponseEntity write(Board board) throws IllegalStateException, IOException {
		String fileName =  FileUpload(board.getFile()); // 파일 보내기
		board.setUrl(fileName);
		service.writeBoard(board);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Read - Get : 전체 목록 보기
	@GetMapping("/board")// 게시글 전체 출력
	public ResponseEntity list(Paging vo) { 

		ArrayList<Board> list =  (ArrayList<Board>) service.allBoard(vo);
		for(Board bo : list) {
			LocalDateTime date = bo.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			bo.setFormatDate(formatDate);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(BoardDTO.builder().board(list).paging(new Paging(vo.getPage(), service.total())).build() );
	}
	// Read - Get : 1개 가져오기
	@GetMapping("/board/{no}") // 게시글 상세페이지
	public ResponseEntity board(@PathVariable("no")Integer no) {
		Board one = service.selectBoard(no);
		LocalDateTime date = one.getDate();
		Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		one.setFormatDate(formatDate);	
		if(one == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(one);
	}
	

	// Update - put
	@PutMapping("/board") // 수정
	public ResponseEntity reWrite(Board board) throws IllegalStateException, IOException {
		if(board.getFile().getOriginalFilename() != "") {
			FileDelete(service.selectBoard(board.getNo()).getUrl()); // 기존 파일 삭제
			String fileName =  FileUpload(board.getFile()); // 파일 보내기
			board.setUrl(fileName);	
		}else {
			board.setUrl(service.selectBoard(board.getNo()).getUrl());
		}
		service.reWrite(board);
		return ResponseEntity.status(HttpStatus.OK).build();	
	}
	
	@DeleteMapping("/board/{no}") // 게시글 삭제
	public ResponseEntity remove(@PathVariable("no")Integer no) throws IllegalStateException, IOException {
		FileDelete(service.selectBoard(no).getUrl());
		service.remove(no);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
//	@PutMapping("/board/{no}") // 상세페이지에서 게시글 수정
//	public ResponseEntity reWrite(@PathVariable("no")Integer no ,Model model) {
//		Board board =  service.selectBoard(no);
//		model.addAttribute("reBo",board);
//		return "reWrite";
//	}
	
	

}
