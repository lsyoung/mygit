package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {

	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member);//한명정보조회, 로그인까지 사용
	int memberInsert(MemberVO member);
	int memberDelete(MemberVO member);
	int memberUpdate(MemberVO member);
	
	boolean isIdCheck(String id);
}
