package com.bread.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		
		PrintWriter out = res.getWriter();

		if (memberId.equals("")) { // 로그인 하지 않은 경우
			out.println("<script>alert('로그인 후 사용해 주세요'); history.back(); </script>");

		} else if (memberId != null) { // 로그인 한 경우
			if (cartCount.equals("")) {
				out.println("<script>alert('상품의 개수를 입력해주세요'); history.back(); </script>");

			} else {
				int count = Integer.parseInt(cartCount);

				BreadCartVO vo = new BreadCartVO();
				CartService service = new CartService();
				List<BreadCartVO> list = service.searchList(memberId);

				// 같은 항목이 list에 있는지 확인하기
				boolean run = false;

				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
					System.out.println(list.get(i).getMemberId());
					System.out.println(list.get(i).getProductId());
					if (list.get(i).getMemberId().equals(memberId) && list.get(i).getProductId().equals(productId)) {
						// 이미 같은걸 추가한 경우
						run = true;
						break;

					}
				}

				if (run) {// 값이 있는 경우 -->값 수정
					out.println("<script>alert('상품이 장바구니에 추가되었습니다'); history.back(); </script>");
					vo = service.update(memberId, productId, count);

				} else { // 값이 없는 경우 --> 새로운 값 입력
					vo = service.insert(memberId, productId, count);
					out.println("<script>alert('상품이 장바구니에 추가되었습니다'); history.back(); </script>");

				}
			}
		}
	}
}
