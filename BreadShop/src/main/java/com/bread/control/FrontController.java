package com.bread.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 설 product
		list = new HashMap<String, Controller>();
		list.put("/productList.do", new ProductListController());
		list.put("/productInsert.do", new ProductInsertController());
		list.put("/productSearch.do", new ProductSearchController());
		list.put("/productUpdate.do", new ProductUpdateController());
		list.put("/productDelete.do", new ProductDeleteController());
		list.put("/productSearchList.do", new ProductSearchListController());
		list.put("/productOne.do", new ProductOneController());
		
		// 설 cart
		list.put("/cartInsert.do", new CartInsertController());
		list.put("/cartList.do", new CartListController());
		list.put("/cartDelete.do", new CartDeleteController());
		
		// 설영
		list.put("/borderList.do", new BorderListController());
		list.put("/borderInsert.do", new BorderInsertControlloer());
		list.put("/borderUpdate.do", new BorderUpdateControlloer());
		list.put("/borderDelete.do", new BorderDeleteControlloer());
		list.put("/borderOne.do", new BorderOneController());
		list.put("/borderUpdateForm.do", new BorderUpdateFormController());
		list.put("/commentInsert.do", new CommentInsertController());
		list.put("/commentList.do", new CommentListController());
		list.put("/commentDelete.do", new CommentDeleteController());
		list.put("/commentUpdateForm.do", new CommentUpdateFormController());
		list.put("/commentUpdate.do", new commentUpdateController());
		
		list.put("/memberinsert.do", new MemberInsertController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberInfo.do", new MemberInfoControlloer());
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI();// uri : 알짜배기만 가져오기

		System.out.println("url : " + url);
		String context = req.getContextPath();
		String path = url.substring(context.length());


		System.out.println("path : " + path);

		Controller subCont = list.get(path);
		subCont.execute(req, res);
	}

}
