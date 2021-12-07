package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class InsertEmpController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String jobId = request.getParameter("job_id");
		String hireD = request.getParameter("hire_date");
		String salary = request.getParameter("salary");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(fname);
		vo.setLastName(lname);
		vo.setEmail(email);
		vo.setJobId(jobId);
		vo.setHireDate(hireD);
		vo.setSalary(Integer.parseInt(salary));
		
		EmpService service = new EmpService();
		service.insert(vo);
		
		request.getRequestDispatcher("emplist.do").forward(request, response);
		
	}

}
