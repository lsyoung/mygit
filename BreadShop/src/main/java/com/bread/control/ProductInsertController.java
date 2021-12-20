package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.ProductService;
import com.bread.vo.BreadProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 이미지
		String saveUrl = req.getRealPath("/upload");
		int maxSize = 30 * 1024 * 1024;
		String encoding = "UTF-8";
		MultipartRequest mRequest = new MultipartRequest(req, saveUrl, maxSize, encoding,
				new DefaultFileRenamePolicy());

		// int productId, String productName, String productDesc, int productPrice,
		String productId = mRequest.getParameter("product_id");
		String productName = mRequest.getParameter("product_name");
		String productDesc = mRequest.getParameter("product_desc");
		String productPrice = mRequest.getParameter("product_price");
		String productImage = mRequest.getFilesystemName("product_image");
		String productCount = mRequest.getParameter("product_count");
		String productGrade = mRequest.getParameter("product_grade");
		String productInventory = mRequest.getParameter("product_inventory");
		

		BreadProductVO vo = new BreadProductVO();
		vo.setProductDesc(productDesc);
		vo.setProductId(productId.toUpperCase());
		vo.setProductImage(productImage);
		vo.setProductName(productName);
		vo.setProductPrice(Integer.parseInt(productPrice));
		vo.setProductCount(Integer.parseInt(productCount));
		vo.setProductGrade(Double.parseDouble(productGrade));
		vo.setProductInventory(Integer.parseInt(productInventory));

		ProductService service = new ProductService();
		service.insert(vo);
		req.setAttribute("product", vo);

		req.getRequestDispatcher("product/productOutput.jsp").forward(req, res);

	}
}
