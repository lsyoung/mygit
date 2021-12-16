package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.dao.BreadProductDAO;
import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;

public class ProductListController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ProductService service = new ProductService();
		List<BreadProductVO> list = service.searchAll();
		
		req.setAttribute("productList", list);
		req.getRequestDispatcher("product/productList.jsp").forward(req, res);
		
		
		
	}

}
