package com.bread.control;

import java.io.IOException;
import java.io.PrintWriter;
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

		if (memberId.equals("")) {// 로그인 하지 않은 경우
			PrintWriter out = res.getWriter();
			out.println("<script>alert('로그인 후 사용해 주세요'); history.back(); </script>");

		} else {

			req.setAttribute("cartList", list);
			req.getRequestDispatcher("cart/cartList.jsp").forward(req, res);

		}
	}

}
