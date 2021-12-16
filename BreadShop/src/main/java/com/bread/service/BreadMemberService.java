package com.bread.service;

import java.util.List;

import com.bread.dao.BreadMemberDAO;
import com.bread.vo.BreadMemberVO;

public class BreadMemberService {
	
	BreadMemberDAO dao = new BreadMemberDAO();
	
	//전체리스트
	public List<BreadMemberVO> searchAll(){
		return dao.memberList();
	}
	
	//한건조회
	public BreadMemberVO searchOne(String id) {
		return dao.memberSearch(id);
	}
	//수정
	public BreadMemberVO update(BreadMemberVO vo) {
		return dao.memberUpdate(vo);
	}
	//삭제
	public BreadMemberVO delete(String id) {
		return dao.memberDelete(id);
	}
	//입력
	public BreadMemberVO insert(BreadMemberVO vo) {
		return dao.memberInsert(vo);
	}
	//로그인 
	public BreadMemberVO login(String id, String pw) {
		return dao.loginCheck(id, pw);
	}
}
