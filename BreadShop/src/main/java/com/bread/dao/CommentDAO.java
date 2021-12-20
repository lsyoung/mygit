package com.bread.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bread.vo.CommentVO;

public class CommentDAO extends DAO {

	// 전체리스트
	public List<CommentVO> commentList(int borderId) {
		List<CommentVO> list = new ArrayList();
		String sql = "select * from border_comment where comment_board_no=?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, borderId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setCommentNo(rs.getInt("comment_no"));
				vo.setBorderNo(rs.getInt("comment_board_no"));
				vo.setCommentWriter(rs.getString("comment_writer"));
				vo.setCommentContent(rs.getString("comment_content"));
				vo.setCommentPasswd(rs.getString("comment_pwd"));
				vo.setCommentDay(rs.getString("comment_day"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//한건조회
	public CommentVO commentOne(int commentNo) {
		String sql = "select * from border_comment where comment_no=?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, commentNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setCommentNo(rs.getInt("comment_no"));
				vo.setBorderNo(rs.getInt("comment_board_no"));
				vo.setCommentWriter(rs.getString("comment_writer"));
				vo.setCommentContent(rs.getString("comment_content"));
				vo.setCommentPasswd(rs.getString("comment_pwd"));
				vo.setCommentDay(rs.getString("comment_day"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 등록
	public CommentVO commentInsert(CommentVO vo) throws Exception {
		String getqul = "select value from repository where name='border_comment'";
		String sql = "insert into border_comment values(?,?,?,?,?,sysdate)";
		String changesql = "update repository set value=? where name='border_comment'";

		int seq = -1;
		connect();

		stmt = conn.createStatement();
		rs = stmt.executeQuery(getqul);
		if (rs.next()) {
			seq = rs.getInt(1);
		}
		seq++;
		System.out.println(vo);
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		psmt.setInt(2, vo.getBorderNo());
		psmt.setString(3, vo.getCommentWriter());
		psmt.setString(4, vo.getCommentContent());
		psmt.setString(5, vo.getCommentPasswd());
		//psmt.setString(6, vo.getCommentDay());

		int r = psmt.executeUpdate();
		System.out.println(r + "건 등록");

		psmt = conn.prepareStatement(changesql);
		psmt.setInt(1, seq);
		r = psmt.executeUpdate();
		System.out.println(r + "건 변경");
		
		vo.setCommentNo(seq);
		
		disconnect();
		return vo;

	}
	//수정 
	public CommentVO commentUpdate(CommentVO vo) {
		String sql = "update border_comment "
				+ "set   comment_content=?, "
				+ "      comment_day=sysdate "
				+ " where comment_no=?";
		
		connect();
		
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, vo.getCommentContent());
			psmt.setInt(2, vo.getCommentNo());
			
			int r= psmt.executeUpdate();
			System.out.println(r +"건 수정 ");
			System.out.println(vo.getCommentContent());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	//삭제  
	public int commentDelete(int commentNo ) {
		String sql = "delete from border_comment where comment_no=?";
		connect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, commentNo);
			
			r = psmt.executeUpdate();
			System.out.println(r +"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}
}
