package com.bread.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bread.service.ProductService;
import com.bread.vo.BreadCartVO;
import com.bread.vo.BreadProductVO;

public class BreadCartDAO extends DAO {
	// String cartId; String memberId; String productId; int cartPrice;
	// int cartCount; String productName; String productImage;

	// 입력
	public BreadCartVO cartInsert(String memberId, String productId, int cartCount) {

		// 필요한 fk 값 memberId, productId, 그리고 productId를 통해서 기타등등의 값을 다 받아와야함
		// 그럼 vo가 3개 있어야 할거같음 memberVo, productVo, cartVo
		// 그리고 이거를 searchOne로 하나씩 값을 찾아오고 그 값을 입력하면 될거같음 -> 일단 이거는 나중에 할거같긴 한데...

		// 1. 시퀀스로 cartId 하나씩 늘리기
		// 2. memberVo에서 memberId 받아오기
		// 3. productVo에서 productId 받아오기
		// 4. productVo에서 기타등등의 값 다 받아와서 cart에 입력하기
		// 5. productVo에서 값 줄이기

		// 시퀀스
		String getSql = "SELECT value FROM repository WHERE name ='bread_cart'";// 시퀀스 값 받아오기
		String changeSeq = "UPDATE repository SET value=? WHERE name='bread_cart'"; // 시퀀스 값 업데이트

		// 입력 sql
		String sql = "INSERT INTO bread_cart VALUES(?, ?, ?, ?, ?, ?, ?)";// bread_cart에 값 입력

		// product 테이블의 inventory 고치기
		String searchProduct = "SELECT product_inventory FROM bread_product WHERE product_id=?"; // inventory 값 찾기
		String updateInventory = "UPDATE bread_product SET product_inventory=? WHERE product_id=?"; // inventory 값 바꾸기

		BreadProductVO productVo = new BreadProductVO();

		ProductService service = new ProductService();
		productVo = service.searchOne(productId);

		int seq = -1;
		int sum = 0;
		int inventory = 0;

		connect();
		try {
			// 시퀀스 받아오기
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getSql);
			if (rs.next()) {
				seq = rs.getInt(1);
			}
			seq++;

			// 장바구니 입력
			// String cartId; String memberId; String productId; int cartPrice;
			// int cartCount; String productName; String productImage;
			sum = (cartCount * productVo.getProductPrice());

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setString(2, memberId);
			psmt.setString(3, productVo.getProductId());
			psmt.setInt(4, sum);
			psmt.setInt(5, cartCount);
			psmt.setString(6, productVo.getProductName());
			psmt.setString(7, productVo.getProductImage());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

			// 시퀀스 수정하기
			psmt = conn.prepareStatement(changeSeq);
			psmt.setInt(1, seq);

			rs = psmt.executeQuery();
			System.out.println("cart 시퀀스 수정됨");

			// bread_product의 inventory 수정하기
			inventory = productVo.getProductInventory();

			inventory -= cartCount;
			System.out.println("cartCount : " + cartCount);

			psmt = conn.prepareStatement(updateInventory);
			psmt.setInt(1, inventory);
			psmt.setString(2, productVo.getProductId());
			rs = psmt.executeQuery();
			System.out.println("productId 확인하기" + productVo.getProductId());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 조회(어차피 전체출력할 일 없기 때문에 조회 리스트로 출력해야함)
	public List<BreadCartVO> cartSearchList(String memberId) {

		List<BreadCartVO> list = new ArrayList<BreadCartVO>();
		String sql = "SELECT * FROM bread_cart WHERE member_id=?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);

			rs = psmt.executeQuery();
			while (rs.next()) {
				BreadCartVO cartVo = new BreadCartVO();
				cartVo.setCartCount(rs.getInt("cart_count"));
				cartVo.setCartId(rs.getString("cart_id"));
				cartVo.setCartPrice(rs.getInt("cart_price"));
				cartVo.setMemberId(rs.getString("member_id"));
				cartVo.setProductId(rs.getString("product_id"));
				cartVo.setProductImage(rs.getString("product_image"));
				cartVo.setProductName(rs.getString("product_name"));

				list.add(cartVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 삭제
	public BreadCartVO deleteCart(String cartId) {
		String sql = "DELETE bread_cart WHERE cart_id=?";
		BreadCartVO vo = new BreadCartVO();

		connect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, cartId);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");

			if (r > 0) {
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;

	}

}
