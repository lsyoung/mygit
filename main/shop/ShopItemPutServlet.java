package com.yedam.shop;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ShopItemPutServlet")
public class ShopItemPutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShopItemPutServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ckeditor 서버로 전송
		ServletContext context = getServletContext();
		String saveUrl = context.getRealPath("upload");
		int maxSize = 3 * 1024 * 1024;
		String encoding = "UTF-8";

		MultipartRequest mRequest = new MultipartRequest(request, // 요청정보
				saveUrl, // 저장위치
				maxSize, // maxSize
				encoding, // 인코딩
				new DefaultFileRenamePolicy());

		Enumeration names =  mRequest.getFileNames();
		while(names.hasMoreElements()) {
		String name = (String)names.nextElement(); //기존파일이름있으면 다른이름으로저장
		String fileName = mRequest.getFilesystemName(name);
		
		String fileUrl =  request.getContextPath() + "/upload/" + fileName;
		
		// ckeditor 결과값을 반환
		JsonObject json = new JsonObject();
		json.addProperty("uploaded", 1);
		json.addProperty("fileName", fileName); 
		json.addProperty("url", fileUrl);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
		}

	}

}
