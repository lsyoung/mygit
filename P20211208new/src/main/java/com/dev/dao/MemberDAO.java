package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.vo.MemberVO;


public class MemberDAO extends DAO {
	//로그인 체크 
	public MemberVO loginCheck(String id, String pw) {
		String sql = "select * from member where id=? and passwd=?";
		connect();
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
	
	//삭제
	public MemberVO memberDelete(String id) {
		MemberVO vo = memberSearch(id);
		String sql = "delete from member where id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}
	// 수정
	public MemberVO memberUpdate(MemberVO vo) {
		
		String sql = "update member "
				+ "set passwd=?, "
				+ "    name=?, "
				+ "    mail=? "
				+ " where id=? ";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getMail());
			psmt.setString(4, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 한건 조회
	public MemberVO memberSearch(String id) {

		String sql = "select * from member where id=?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 전체 리스트
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList();
		String sql = "select * from member order by 1";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 한건입력처리
	public MemberVO memberInsert(MemberVO vo) {
		String sql = "insert into member values(?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getMail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return vo;
	}
}
