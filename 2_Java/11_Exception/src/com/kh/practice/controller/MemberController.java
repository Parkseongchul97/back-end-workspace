package com.kh.practice.controller;



import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;

public class MemberController {
	private Member mArr[] = new Member[3];
	public int count = 0;
	// 맴버추가 
	public void insertMember(Member m) throws DuplicateNameException {
		
		int index = checkId(m.getId());
		if(index == -1) {
			mArr[count++] = new Member(m.getId(), m.getName(), m.getPwd(),
					m.getEmail(), m.getGender(), m.getAge());
			
			}else {
				throw new DuplicateNameException();
			}
		
		
		
	}
	
	// 맴버 아이디 검색  -> 맴버 index를 조회 
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) { // id null 값이 아니면서 id값들이 같지 않을때  
				// 기존 맴버 배열에 아이디가 있는 경우!
				return i;
			}
		}
		// 아이디가 없는 경우 , -1은 인덱스 번호가 될 수 없기 때문 
		return -1;
	}
	public int checkUpdateId(String id) throws RecordNotFoundException {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) { 
				
				return i;
			}else {
				throw new RecordNotFoundException();
			}
		}
	
		return -1;
	}
	
	
	// 맴버 업데이트 
	public void updateMember(String id, String name, String email, String pwd) throws RecordNotFoundException {
		// 해당 맴버의 index를 찾아야함
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);			
	}
	// 회원 정보 출력 
	public Member[] printAll() {
		return mArr;
	}
	
				
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	}
//	public int length() {
//		return m.length;
//	}
//	public void updateID(int i ,String id) {
//		m[i].setId(id);
//	}
//	public void updateName(int i ,String name) {
//		m[i].setName(name);
//	}
//	public void updateEmail(int i,String email) {
//		m[i].setEmail(email);
//	}
//	public void updatePwd(int i,String pwd) {
//		m[i].setPwd(pwd);
//	}
//
//	
//	public String idCheck(int i) {
//			return m[i].getId();
//		}
//	public String info(int i) {
//		
//		return "Member [id=" + m[i].getId() + ", name=" + m[i].getName() + ", pwd=" + m[i].getPwd() + ", email=" + m[i].getEmail() + ", gender=" + m[i].getGender()
//				+ ", age=" + m[i].getAge() + "]";
//		
//		
//	}
			}

