package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.vo.Member;


import mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public Member idCheck(String id) {
		System.out.println("서비스" + id);
	
		return mapper.idCheck(id);
	}
	public void serialize(Member member) {
		mapper.serialize(member);
		
	
	}
}
