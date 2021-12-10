package com.dev.service;

import java.util.List;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {
	
	//한건입력
	MemberDAO dao = new MemberDAO();
	
	public MemberVO insert(MemberVO vo) {
		return dao.memberInsert(vo);
	}
	//전체 리스트
	public List<MemberVO> searchAll(){
		return dao.memberList();	
	}
	
	//한건조회
	public MemberVO searchOne(String id) {
		return dao.memberSearch(id);
	}
	
	//ㅅ수정
	public MemberVO update(MemberVO vo) {
		return dao.memberUpdate(vo);
	}
	//삭제
	public MemberVO delete(String id) {
		return dao.memberDelete(id);
	}
	//로그인
	public MemberVO login(String id, String pw) {
		return dao.loginCheck(id, pw);
	}
}
