package com.yedam.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/ShopItemServlet")
public class ShopItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShopItemServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//요청정보
		response.setCharacterEncoding("utf-8");//응답정보 한글
		response.setContentType("text/json;charset=utf-8");
		
		
		ShopDAO dao = new ShopDAO();
		List<ShopItem> list = dao.getItemList();//전체조회
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.getWriter().print(gson.toJson(list).toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//요청정보
		response.setCharacterEncoding("utf-8");//응답정보 한글
		response.setContentType("text/json;charset=utf-8");
		
//		String item_code = request.getParameter("item_code");
//		System.out.println(item_code); null값
		
		//1.request 2.저장위치 3 maxSize 4.UTF-8 5.리네임정책  ""String 타입의미
		ServletContext context = getServletContext(); //최상위 폴더 webapp context담고
		String savePath = context.getRealPath("upload"); //context 기준으로 upload폴더찾음
		int maxSize = 1024 * 1024 * 30;
		String encoding = "UTF-8";
		MultipartRequest mRequest = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy() 같은 이름의 파일이있을때 다른이름으로 업로드될수있도록하는 정책
		
		String itemCode = mRequest.getParameter("item_code");
		String itemName = mRequest.getParameter("item_name");
		String itemDesc = mRequest.getParameter("item_description");
		String likeIt = mRequest.getParameter("like_it");
		String originPrice = mRequest.getParameter("origin_price");
		String salePrice = mRequest.getParameter("sale_price");
		String image = mRequest.getFilesystemName("image");//바뀐파일이름으로
		
		ShopItem si = new ShopItem();
		si.setItemCode(itemCode);
		si.setItemName(itemName);
		si.setItemDesc(itemDesc);
		System.out.println(itemDesc);
		
		likeIt = likeIt == null ? "0" : likeIt;
		si.setLiktIt(Double.parseDouble(likeIt));
		originPrice = originPrice == null ? "0" : originPrice;
		si.setOriginPrice(Integer.parseInt(originPrice));
		salePrice = salePrice == null ? "0" : salePrice;
		si.setSalePrice(Integer.parseInt(salePrice));
		
		si.setImage(image);
		ShopDAO dao = new ShopDAO();
		dao.insertShopItem(si);
		
		System.out.println(itemCode);//입력값 받아옴
	}

}
