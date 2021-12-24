package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList(); //전체리스트 가져오기
	MemberVO memberSelect(MemberVO vo); //한명분 데이터 조회	
	int memberInsert(MemberVO vo);  
	int memberDelete(MemberVO vo);  
	int memberUpdate(MemberVO vo);  
}
