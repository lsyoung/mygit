package com.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class EmpListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//사원리스트 출력
		//vo, empservice 데이터 가지고 옴
		EmpService service = new EmpService();
		List <EmployeeVO> list = service.getAll();
		
		request.setAttribute("empList", list);
		
		request.getRequestDispatcher("emp/emplist.jsp").forward(request, resp);
		
//		out.print("<h3>사원리스트</h3>");
//		out.print("<ul>");
//		for(EmployeeVO vo : list) {
//			out.print("<li><a href='emp/getEmp.jsp?eid="+vo.getEmployeeId()+"'>"
//		   +vo.getEmployeeId()+ "</a>, " +vo.getFirstName()+ ", " 
//		   +vo.getLastName()+", "+vo.getEmail()+", "+vo.getSalary()+", "+"<input type='button' value='삭제' onclick='../deleteEmp.do?eid="+vo.getEmployeeId()+"'>"+"</li>"
//		   );
//		}
//		out.print("</ul>");
	}

}
