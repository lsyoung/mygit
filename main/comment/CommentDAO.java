package com.yedam.comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO;

public class CommentDAO extends DAO {

	// 전체조회
	public List<CommentVO> getCommentList() throws Exception {
		List<CommentVO> list = new ArrayList();
		String qul = "SELECT * FROM comments order by 1 ";
		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(qul);
		while(rs.next()) {
			CommentVO vo  = new CommentVO();
			vo.setId(rs.getString("id"));
			vo.setName( rs.getString("name"));
			vo.setContent(rs.getString("content"));
			
			
			list.add(vo);
		}
		disconnect();
		return list;
	}

	// 한건입력
	public CommentVO insertComment(CommentVO vo) throws Exception {
		String getSql = "SELECT VALUE FROM id_repository where name ='COMMENT'";
		String sql = "INSERT INTO comments values(?,?,?)";
		String changeSeq = "UPDATE id_repository SET value=? where name ='COMMENT'";
		int seq = -1;

		connect();

		stmt = conn.createStatement();
		rs = stmt.executeQuery(getSql);
		if (rs.next()) {
			seq = rs.getInt(1);// 첫번째 컬럼(value)
		}
		seq++;

		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		psmt.setString(2, vo.getName());
		psmt.setString(3, vo.getContent());
		int r = psmt.executeUpdate();
		System.out.println(r + "건 입력");

		psmt = conn.prepareStatement(changeSeq);
		psmt.setInt(1, seq);
		r = psmt.executeUpdate();
		System.out.println(r + "건 변경");
		
		vo.setId(String.valueOf(seq));
		
		disconnect();
		return vo;
	}

	// 수정
	public CommentVO updateComment(CommentVO vo) throws Exception {
		String sql = "UPDATE comments SET name=?, content=? where id=?";
		connect();
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, vo.getName());
		psmt.setString(2, vo.getContent());
		psmt.setString(3, vo.getId());
		
		int r = psmt.executeUpdate();
		System.out.println(r + "건 수정");
		
		disconnect();
		return null;
	}

	// 삭제
	public String deleteComment(String id) throws Exception {
		String sql = "DELETE FROM comments where id=?";
		connect();
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		
		int r = psmt.executeUpdate();
		System.out.println(r +"건 삭제");
		
		disconnect();
		return null;
	}

	// 한건조회
	public CommentVO findComment(String id) throws Exception {
		String sql = "SELECT * FROM comments where id=?";
		connect();
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			CommentVO vo  = new CommentVO();
			vo.setId(rs.getString("id"));
			vo.setName( rs.getString("name"));
			vo.setContent(rs.getString("content"));
			
			disconnect();
			return vo;
		}
		return null;
	}

}
