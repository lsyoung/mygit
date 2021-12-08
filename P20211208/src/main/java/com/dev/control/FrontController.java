package com.dev.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {

	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("controller init()");
		
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do",  new MemberInsertController());
		list.put("/memberList.do", new MemberListController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		
		list.put("/login.do", new LoginController());
		list.put("/Logout.do", new LogoutController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI(); //  localhost:80/p2021309/memberInsert.do
		String context = req.getContextPath();
		String path = url.substring(context.length());//memberInsert.do
		
		Controller subCont = list.get(path);
		subCont.execute(req, res);
	}

}
