package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;

public class ProductOneController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		String productId=req.getParameter("productId");
		
		ProductService service = new ProductService();
		BreadProductVO vo = service.searchOne(productId);
		req.setAttribute("productOne", vo);
		
		req.getRequestDispatcher("product/productOne.jsp").forward(req, res);
		
	}

}
