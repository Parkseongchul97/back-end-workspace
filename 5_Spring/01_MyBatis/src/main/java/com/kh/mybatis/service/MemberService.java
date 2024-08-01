package com.kh.mybatis.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
//	public MemberService(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
	
	public void register(Member member) {
		mapper.register(member);
	}
	public ArrayList<Member> allMember(){
		return mapper.allMember();
	}
	public Member login(Member member) {
		return mapper.login(member);
		
	}
	public void update(Member member) {
		
		mapper.update(member);
	}
	public List<Member> search(SearchDTO dto){//
	
	
		return mapper.search(dto);
	}
	public void delete(ArrayList<String> idList) {
		mapper.delete(idList);
		}

}
