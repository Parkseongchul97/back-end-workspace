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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;



@Controller
public class BoardController {
	

	@Autowired
	private BoardService service;
	
	@PostMapping("/write") // 게시글 작성
	public String write(Board board) throws IllegalStateException, IOException {
		String fileName =  FileUpload(board.getFile()); // 파일 보내기
		board.setUrl(fileName);
		service.writeBoard(board);
		return "redirect:/" + board.getNo();	
	}
	
	@GetMapping("/{no}") // 게시글 상세페이지
	public String board(@PathVariable("no")Integer no ,Model model) {
		Board board =  service.selectBoard(no);
		LocalDateTime date = board.getDate();
		Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		board.setFormatDate(formatDate);
		model.addAttribute("bo",board);
		return "board";
	}
	
	@GetMapping("/{no}/reWrite") // 상세페이지에서 게시글 수정
	public String reWrite(@PathVariable("no")Integer no ,Model model) {
		Board board =  service.selectBoard(no);
		model.addAttribute("reBo",board);
		return "reWrite";
	}
	
	@PostMapping("/reWrite") // 수정
	public String reWrite(Board board) throws IllegalStateException, IOException {
		if(board.getFile().getOriginalFilename() != "") {
			FileDelete(service.selectBoard(board.getNo()).getUrl()); // 기존 파일 삭제
			String fileName =  FileUpload(board.getFile()); // 파일 보내기
			board.setUrl(fileName);	
		}else {
			board.setUrl(service.selectBoard(board.getNo()).getUrl());
		}
		service.reWrite(board);
		return "redirect:/list";	
	}
	
	@GetMapping("/{no}/remove") // 게시글 삭제
	public String remove(@PathVariable("no")Integer no) throws IllegalStateException, IOException {
		Board board =  service.selectBoard(no);
		FileDelete(board.getUrl());
		service.remove(no);
		return "redirect:/list";
		
	}
	
	@GetMapping("/list")// 게시글 전체 출력
	public String list(Model model, Paging vo) { 
		vo.getPage();
		vo.getOffset();
		vo.getLimit();
		ArrayList<Board> list =  (ArrayList<Board>) service.allBoard(vo);
		for(Board bo : list) {
			LocalDateTime date = bo.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			bo.setFormatDate(formatDate);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("paging" , new Paging(vo.getPage(), service.total()));
		return "list";
	}
	
	
	
	// 파일 업로드 메서드
	public String FileUpload(MultipartFile file) throws IllegalStateException, IOException {
		if(file.getOriginalFilename() == "") {
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
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		FileUpload(file);
		
		return "redirect:/";
	}
	
	@PostMapping("/mulitUpload")
	public String mulitUpload(List<MultipartFile> files) throws IllegalStateException, IOException {	
		for(MultipartFile f : files) {
			FileUpload(f);
		}
		
		return "redirect:/";
	}

}
