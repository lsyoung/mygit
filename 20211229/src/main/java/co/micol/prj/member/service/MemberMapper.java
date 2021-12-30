package co.micol.prj.member.service;

import java.util.List;

public interface MemberMapper {

	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member); //로그인 or select
	int memberInsert(MemberVO member); 
	int memberDelete(MemberVO member);
	int memberUpdate(MemberVO member);
	
	boolean isIdCheck(String id); 
}
