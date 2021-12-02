package com.my.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.my.common.EmpDAO;
import com.my.common.Employee;


@WebServlet("/EmpSourceServlet")
public class EmpSourceServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		
		EmpDAO dao = new EmpDAO();
		
		List<Employee> list = dao.getEmployees();
		
		JSONArray outAry = new JSONArray();
		for(Employee emp : list) {
			
			JSONArray inAry = new JSONArray();
			
			inAry.add(emp.getEmployeeId());
			inAry.add(emp.getFirstName());
			inAry.add(emp.getLastName());
			inAry.add(emp.getEmail());
			inAry.add(emp.getHireDate());
			inAry.add(emp.getSalary());
			
			outAry.add(inAry);
			
		}
		
		resp.getWriter().print(outAry.toString());
	}
}

