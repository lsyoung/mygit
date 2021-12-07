package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		StringBuffer html = new StringBuffer();
		html.append("<form action='insertEmp.do' method='post'>");
		html.append("   사원번호: <input type='text' name='employee_id' ><br>");
		html.append("   이름: <input type='text' name='first_name' > <br>");
		html.append("   성씨: <input type='text' name='last_name' ><br>");
		html.append("   이메일: <input type='email' name='email' ><br>");
		html.append("   입사일자: <input type='date' name='hire_date' >");
		html.append("   <input type='hidden' name='job_id' value='IT_PROG' ><br>");
		html.append("   급여: <input type='number' name='salary' ><br>");
		html.append("<input type='submit' value='저장' >");
		html.append("</form>");
		response.getWriter().print(html);
	}

}
