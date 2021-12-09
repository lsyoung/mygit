package todo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO extends DAO{
	
	public List<TodoVO> getTodoList	(){
		List<TodoVO> list = new ArrayList();
		String sql = "select * from todo_list";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				TodoVO vo = new TodoVO();
				vo.setContent(rs.getString("content"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	public TodoVO insertTodo(TodoVO vo) {
		
		String sql = "insert into todo_list values(?)";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	public String deleteTodo(String content) {
		
		String sql = "delete from todo_list where content=?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 삭제");
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

}
