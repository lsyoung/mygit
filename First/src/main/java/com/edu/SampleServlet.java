package com.edu;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet > GenericServlet -> HttpServlet
@WebServlet("/sample1.do")
public class SampleServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init call");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		System.out.println("init config");
	}
	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		
//		super.service(req, res);
//		System.out.println("service servletRequest");
//	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		super.service(req, resp);
//		System.out.println("service HttpServletRequest");
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//super.doGet(req, resp);
		ServletContext sc = this.getServletContext();//애플리케이션(First)하나씩 생성되는 객체
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destory");
		super.destroy();
	}
}
