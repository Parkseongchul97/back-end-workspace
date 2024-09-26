package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public void writeBoard (Board board) {
		mapper.writeBoard(board);
	}
	
	public List<Board> allBoard(Paging vo){		
		
		/*
		 * vo 가공처리 기본 리미트 10 오프셋 0
		 * page 1 = offset 0
		 * page 2 = offset 10
		 * page 3 = offset 20
		 * offset = limit * (page -1)
		 * */
		vo.setOffset(vo.getLimit() * (vo.getPage() - 1));
		
		return mapper.allBoard(vo);
	}
	public  int total() {
		return mapper.total();
	}
	
	public Board selectBoard(int no) {
		return mapper.selectBoard(no);
	}
	
	public void remove(int no) {
		mapper.remove(no);
	}
	
	public void reWrite(Board board) {
		mapper.reWrite(board);
	}
}
