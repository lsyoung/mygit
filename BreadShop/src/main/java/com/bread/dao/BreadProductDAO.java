package com.bread.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bread.vo.BreadProductVO;

public class BreadProductDAO extends DAO {
	// =======================================전체조회=======================================
	public List<BreadProductVO> productList() {

		List<BreadProductVO> list = new ArrayList<BreadProductVO>();
		String sql = "SELECT *  FROM bread_product ORDER BY 1";
		connect();
		// int productId, String productName, String productDesc int productPrice

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BreadProductVO vo = new BreadProductVO();
				vo.setProductDesc(rs.getString("product_desc"));
				vo.setProductId(rs.getString("product_id"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductPrice(rs.getInt("product_price"));
				vo.setProductImage(rs.getString("product_image"));
				vo.setProductCount(rs.getInt("product_count"));
				vo.setProductGrade(rs.getDouble("product_grade"));
				vo.setProductInventory(rs.getInt("product_inventory"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	} // list

	// =======================================조회리스트=======================================
	public List<BreadProductVO> productSearchList(String searchField, String searchText) {

		List<BreadProductVO> list = new ArrayList<BreadProductVO>();
		String sql = "SELECT *  FROM bread_product" + " WHERE " + searchField.trim();

		connect();
		// int productId, String productName, String productDesc int productPrice

		try {

			if (searchText != null && !searchText.equals("")) {// 이거 빼면 안 나온다ㅜ 왜지?
				sql += " LIKE '%" + searchText.toUpperCase().trim() + "%' order by 1";
			}

			psmt = conn.prepareStatement(sql);

			String searchName = "%" + searchText + "%";

			rs = psmt.executeQuery();

			while (rs.next()) {
				BreadProductVO vo = new BreadProductVO();
				vo.setProductDesc(rs.getString("product_desc"));
				vo.setProductId(rs.getString("product_id"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductPrice(rs.getInt("product_price"));
				vo.setProductImage(rs.getString("product_image"));
				vo.setProductGrade(rs.getDouble("product_grade"));
				vo.setProductCount(rs.getInt("product_count"));
				vo.setProductInventory(rs.getInt("product_inventory"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	} // list

	// =======================================단건조회=======================================
	public BreadProductVO productSearch(String productId) {
		String sql = "SELECT * FROM bread_product WHERE product_id LIKE ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);

			// String searchName = "%" + productName + "%";

			psmt.setString(1, productId.toUpperCase());
			rs = psmt.executeQuery();

			if (rs.next()) {
				BreadProductVO vo = new BreadProductVO();
				vo.setProductDesc(rs.getString("product_desc"));
				vo.setProductId(rs.getString("product_id"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductPrice(rs.getInt("product_price"));
				vo.setProductImage(rs.getString("product_image"));
				vo.setProductGrade(rs.getDouble("product_grade"));
				vo.setProductCount(rs.getInt("product_count"));
				vo.setProductInventory(rs.getInt("product_inventory"));
				return vo;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// =======================================수정=======================================
	public BreadProductVO productUpdate(BreadProductVO vo) {
		// int productId, String productName, String productDesc int productPrice

		String sql = "UPDATE bread_product "//
				+ "SET product_id=?, product_name=?, product_desc=?, product_price=?, product_image=?, product_inventory=? "//
				+ "WHERE product_name LIKE ?";

		connect();
		String searchName = "%" + vo.getProductName() + "%";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductId());
			psmt.setString(2, vo.getProductName());
			psmt.setString(3, vo.getProductDesc());
			psmt.setInt(4, vo.getProductPrice());
			psmt.setString(5, vo.getProductImage());
			psmt.setInt(6, vo.getProductInventory());

			psmt.setString(7, searchName);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;
	}

	// =======================================입력=======================================
	public BreadProductVO productInsert(BreadProductVO vo) {
		// int productId, String productName, String productDesc, int productPrice,
		// String productImage
//		String getSql = "SELECT value FROM repository WHERE name ='bread_product'";

		String sql = "INSERT INTO bread_product VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

//		String changeSeq = "UPDATE repository SET value=? WHERE name='bread_product'";

		int seq = -1;
		connect();
		try {
			// 시퀀스 받아오기
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(getSql);
//			if (rs.next()) {
//				seq = rs.getInt(1);
//			}
//			seq++;

			// 입력하기
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getProductId());
			psmt.setString(2, vo.getProductName());
			psmt.setString(3, vo.getProductDesc());
			psmt.setInt(4, vo.getProductPrice());
			psmt.setString(5, vo.getProductImage());
			psmt.setDouble(6, vo.getProductGrade());
			psmt.setInt(7, vo.getProductCount());
			psmt.setInt(8, vo.getProductInventory());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

			// 시퀀스 수정하기
//			psmt = conn.prepareStatement(changeSeq);
//			psmt.setInt(1, seq);
//
//			r = psmt.executeUpdate();
//			System.out.println(r + "건 입력");
//
//			vo.setProductId(seq);

			return vo;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// =======================================삭제=======================================

	public BreadProductVO deleteProduct(String productId) {

		// int productId, String productName, String productDesc, int productPrice,
		// String productImage
		String sql = "DELETE bread_product WHERE product_id LIKE ?";

		BreadProductVO vo = new BreadProductVO();
		connect();
		try {
			psmt = conn.prepareStatement(sql);

			// String searchName = "%" + productName + "%";

			psmt.setString(1, productId);

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
