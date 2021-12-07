package com.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.vo.EmployeeVO;

public class EmpDAO extends DAO {
	// 리스트
	public List<EmployeeVO> getEmployees() {
		String sql = "select * from empl_demo";
		connect();
		List<EmployeeVO> list = new ArrayList();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmail(rs.getString("email"));
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	// 한건 조회

	public EmployeeVO getEmployee(String id) {
		String sql = "select * from empl_demo where employee_id=?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmail(rs.getString("email"));
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				return vo;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 입력
	public EmployeeVO insertEmployee(EmployeeVO vo) {
		String seqSql = "select employees_seq.nextval from dual";
		String insertSql = "insert into empl_demo(employee_id, first_name, last_name, email, job_id, hire_date, salary)"
				+ " values(?,?,?,?,?,?,?)";
		connect();
		int seq = -1;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(seqSql);
			if (rs.next()) {
				seq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getJobId());
			psmt.setString(6, vo.getHireDate());
			psmt.setInt(7, vo.getSalary());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

			vo.setEmployeeId(seq);
			return vo;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 수정
	public EmployeeVO updateEmployee(EmployeeVO vo) {
		String sql = "update empl_demo "
				+ "set  first_name=nvl(?, first_name)"
				+ "    ,last_name =nvl(?, last_name)"
				+ "    ,email=nvl(?, email)"
				+ "    ,hire_date=nvl(?, hire_date)"
				+ "    ,job_id=nvl(?, job_id)"
				+ "    ,salary=nvl(?, salary)"
				+ "    where employee_id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getSalary());
			psmt.setInt(7, vo.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;		
	}

	// 삭제
	public EmployeeVO deleteEmployee(String id) {
		EmployeeVO vo = getEmployee(id);
		String sql = "delete from empl_demo where employee_id = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}

}
