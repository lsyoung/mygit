package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;

public class ProductSearchListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productName = req.getParameter("name");
		String searchText = req.getParameter("searchField");
		ProductService service = new ProductService();
		List<BreadProductVO> list = service.searchList(searchText, productName);

		req.setAttribute("productList", list);
		req.getRequestDispatcher("product/productSearchListOutput.jsp").forward(req, res);

	}

}
