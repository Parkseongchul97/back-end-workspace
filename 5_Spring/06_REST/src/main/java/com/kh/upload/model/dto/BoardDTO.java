package com.kh.upload.model.dto;

import java.util.List;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BoardDTO {
	private Paging paging;
	private List<Board> board;

}
