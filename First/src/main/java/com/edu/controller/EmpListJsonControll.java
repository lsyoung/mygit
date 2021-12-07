package com.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmpListJsonControll implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/json;charset=UTF-8");
		
		EmpService service = new EmpService();
		List<EmployeeVO> list =  service.getAll();
		
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(list).toString());
	}

}
