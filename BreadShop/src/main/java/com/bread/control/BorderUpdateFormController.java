package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.BreadBorderService;
import com.bread.vo.BreadBorderVO;


public class BorderUpdateFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int borderId = Integer.parseInt(req.getParameter("borderId"));
		
		BreadBorderService service = new BreadBorderService();
		BreadBorderVO vo = service.borderOne(borderId);
		req.setAttribute("border", vo);

		req.getRequestDispatcher("breadShop/borderUpdate.jsp").forward(req, res);
		

	}

}
