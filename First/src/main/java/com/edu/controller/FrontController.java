package com.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class FrontController extends HttpServlet {
	
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//요청페이지 -> 실행할 서블릿.
		list = new HashMap<String, Controller>();
		list.put("/emplist.do", new EmpListController());
		list.put("/emplistJson.do", new EmpListJsonControll());
		//입력화면, 입력처리
		list.put("/insertForm.do", new InsertFormController());
		list.put("/insertEmp.do", new InsertEmpController());
		//삭제
		list.put("/deleteEmp.do", new DeleteEmpController());
		//수정updateEmp.do
		list.put("/updateEmp.do", new UpdateEmpController());
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();// /First/emplist.do
		String context = req.getContextPath();// /First
		int toPos = url.indexOf(".do");
		String path = url.substring(context.length(), toPos + 3);
		System.out.println(path);
		
		Controller subCont = list.get(path);
		subCont.execute(req, resp);
	}
	
}
