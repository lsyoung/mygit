package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.emp.EmployeeVO;

import emp.DAO;

class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;

	public Employee() {

	}

	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			String hireDate, String jobId, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + "]";
	}

}

public class EmpDAO extends DAO {
	
	//부서별 사원정보 차트
	public Map<String, Integer> getEmpByDepartment(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql ="select department_name, count(1) "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id "
				+ "group by department_name";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));//select 해당하는컬럼순서대로
			}
			return map;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 한건조회(사원번호)
	public EmployeeVO findEmployee(String empId) {
		String sql = "select * from empl_demo where employee_id =?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setJobId(rs.getString("job_id"));
				vo.setHireDate(rs.getString("hire_date"));
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

	// 삭제기능(사원번호)
	public boolean deleteEmployee(String empId) {
		String sql = "delete from empl_demo where employee_id =?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			int r = psmt.executeUpdate();

			System.out.println(r + "건 입력되었습니다.");

			if (r > 0) {
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 수정기능(사원번호)
	public EmployeeVO updateEmployee(EmployeeVO vo) {
		String sql = "update empl_demo "
				+ "set first_name =?,"
				+ "    last_name =?,"
				+ "    email = ?,"
				+ "    hire_date =?,"
				+ "    salary =?"
				+ " where employee_id =?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setInt(5, vo.getSalary());
			psmt.setInt(6, vo.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 변경됨");
			if (r > 0) {
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 입력기능
	public boolean insertEmp(EmployeeVO vo) {
		String sql = "insert into empl_demo(employee_id, first_name, last_name, email, job_id, hire_date, salary) values(?,?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getJobId());
			psmt.setString(6, vo.getHireDate());
			psmt.setInt(7, vo.getSalary());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");
			if (r < 1) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} finally {
			disconnect();
		}
	}

	// 전체조회
	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList();
		String sql = "select * from empl_demo order by 1 desc";
		// 1db연결
		connect();
		// 2쿼리결과<=> stmt psmt
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
						rs.getString("hire_date").substring(0,10), rs.getString("job_id"), rs.getInt("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 연습용
	public String getString(String name) {
		String something = "Hello, " + name;
		return something;
	}

	public List<String> getNames() {
		String[] names = { "홍길동", "김민기", "박성숙", "최근영" };
		List<String> returnList = new ArrayList<String>();
		for (String name : names) {
			returnList.add(name);
		}
		return returnList;
	}

	public Map<String, Integer> getScores() {
		String[] names = { "홍길동", "김민기", "박성숙", "최근영" };
		Map<String, Integer> map = new HashMap<String, Integer>();
		int score = 80;
		for (String name : names) {
			map.put(name, score++);
		}
		return map;

	}
}
