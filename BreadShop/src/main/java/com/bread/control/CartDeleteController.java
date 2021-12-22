package com.bread.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CartService;
import com.bread.vo.BreadCartVO;

public class CartDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartId=req.getParameter("cartId");
		
		BreadCartVO vo = new BreadCartVO();
		CartService service = new CartService();
		service.delete(cartId);
		PrintWriter out = res.getWriter();

		out.println("<script>alert('상품이 삭제되었습니다'); </script>");
		
		req.getRequestDispatcher("cart/cartList.jsp").forward(req, res);

		
	}

}
