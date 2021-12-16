package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CartService;
import com.bread.vo.BreadCartVO;

public class CartInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		필요한 값 String memberId, String productId, int cartCount

		String memberId = req.getParameter("memberId");
		String productId = req.getParameter("productId");
		String cartCount = req.getParameter("cartCount");

		BreadCartVO vo = new BreadCartVO();

		CartService service = new CartService();
		vo = service.insert(memberId, productId, Integer.parseInt(cartCount));

		req.setAttribute("cart", vo);
		//req.getRequestDispatcher("/cartInsert.jsp").forward(req, res);
		
		

	}

}
