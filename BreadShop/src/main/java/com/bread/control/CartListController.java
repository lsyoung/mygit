package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CartService;
import com.bread.vo.BreadCartVO;

public class CartListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String memberId = req.getParameter("memberId");
		CartService service = new CartService();
		List<BreadCartVO> list = service.searchList(memberId);
		
		req.setAttribute("cartList", list);
		req.getRequestDispatcher("cart/cartList.jsp").forward(req, res);

	}

}
