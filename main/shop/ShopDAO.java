package com.yedam.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO;

public class ShopDAO extends DAO {

	// 전체조회
	public List<ShopItem> getItemList() {
		List<ShopItem> list = new ArrayList();

		String sql = "select * from shop_item order by 1 desc";

		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ShopItem item = new ShopItem();
			
				item.setItemCode(rs.getString("item_code"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDesc(rs.getString("item_description"));
				item.setLiktIt(rs.getDouble("like_it"));
				item.setOriginPrice(rs.getInt("origin_price"));
				item.setSalePrice(rs.getInt("sale_price"));
				item.setImage(rs.getString("image"));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public void insertShopItem(ShopItem si) { // 입력
		String sql = "insert into shop_item(item_code, item_name, item_description, like_it, origin_price, sale_price, image) values(?,?,?,?,?,?,?)";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, si.getItemCode());
			psmt.setString(2, si.getItemName());
			psmt.setString(3, si.getItemDesc());
			psmt.setDouble(4, si.getLiktIt());
			psmt.setInt(5, si.getOriginPrice());
			psmt.setInt(6, si.getSalePrice());
			psmt.setString(7, si.getImage());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
