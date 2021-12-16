package com.bread.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bread.vo.BreadMemberVO;

public class BreadMemberDAO extends DAO{
	
	//전체조회
	public List<BreadMemberVO> memberList(){
		List<BreadMemberVO> list = new ArrayList();
		String sql = "select * from bread_member";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BreadMemberVO vo = new BreadMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("email"));
				
				list.add(vo);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//한건 조회
	public BreadMemberVO memberSearch(String id) {
		String sql = "select * from bread_member where id=?";
		connect();
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				BreadMemberVO vo = new BreadMemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("email"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	//등록
	public BreadMemberVO memberInsert(BreadMemberVO vo) {
		String sql ="insert into bread_member values(?,?,?,?)";
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
	//수정 
	public BreadMemberVO memberUpdate(BreadMemberVO vo) {
		
		String sql = "update bread_member"
				      + "set  passwd=?, "
				      + "     mail=? "
				      + "where id=? ";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getMail());
			psmt.setString(3, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	//삭제
	public BreadMemberVO memberDelete(String id) {
		BreadMemberVO vo = memberSearch(id);
		String sql = "delete from bread_member where id=?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	//로그인 체크
	public BreadMemberVO loginCheck(String id, String pw) {
		String sql = "select * from bread_member where id=? and passwd=?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				BreadMemberVO vo = new BreadMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("email"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
