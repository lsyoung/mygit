package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;

public class ProductSearchController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String productId = req.getParameter("name");
		String job = req.getParameter("job");

		ProductService service = new ProductService();
		BreadProductVO vo = service.searchOne(productId);
		req.setAttribute("product", vo);

		if (job.equals("search"))
			req.getRequestDispatcher("product/productSearchOutput.jsp").forward(req, res);

		else if (job.equals("update"))
			req.getRequestDispatcher("product/productUpdateForm.jsp").forward(req, res);

		else if (job.equals("delete"))

			req.getRequestDispatcher("product/productDeleteForm.jsp").forward(req, res);
		
//		else if(job.equals("searchList"))
//			req.getRequestDispatcher("product/productSearchListOutput.jsp").forward(req, res);

	}
}
