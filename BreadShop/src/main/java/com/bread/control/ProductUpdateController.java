package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;

public class ProductUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// product_id, product_name, product_desc, product_price, product_image,
		// product_inventory
		String productId = req.getParameter("product_id");
		String productName = req.getParameter("product_name");
		String productDesc = req.getParameter("product_desc");
		String productPrice = req.getParameter("product_price");
		String productImage = req.getParameter("product_image");
		String productInventory = req.getParameter("product_inventory");

		// 밑의 두개는 일단 넣어둬봤음...
		String productCount = req.getParameter("product_count");
		String productGrade = req.getParameter("product_grade");

		BreadProductVO vo = new BreadProductVO();
		vo.setProductId(productId);
		vo.setProductName(productName);
		vo.setProductDesc(productDesc);
		vo.setProductPrice(Integer.parseInt(productPrice));
		vo.setProductImage(productImage);
		vo.setProductInventory(Integer.parseInt(productInventory));

		// vo.setProductCount(Integer.parseInt(productCount));
		// vo.setProductGrade(Double.parseDouble(productGrade));

		ProductService service = new ProductService();
		service.update(vo);

//		req.setAttribute("update_id", productId);
//		req.setAttribute("update_name", productName);
//		req.setAttribute("update_desc", productDesc);
//		req.setAttribute("update_price", productDesc);
//		req.setAttribute("update_image", productImage);
//		req.setAttribute("update_inventory", productInventory);

		req.setAttribute("product", vo);

		req.getRequestDispatcher("product/productUpdateOutput.jsp").forward(req, res);
	}

}
