package com.kh.mybatis.model.dto;

import com.kh.mybatis.model.vo.Member;
// DTO(Data Transfer Object) : 데이터 전송 객체

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchDTO {
	private String select;
	private String keyword;
//	private Member member;
	
}
