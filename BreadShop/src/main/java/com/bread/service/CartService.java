package com.bread.service;

import java.util.List;

import com.bread.dao.BreadCartDAO;
import com.bread.vo.BreadCartVO;

public class CartService {
	BreadCartDAO dao = new BreadCartDAO();

	// 입력
	public BreadCartVO insert(String memberId, String productId, int cartCount) {
		return dao.cartInsert(memberId, productId, cartCount);
	}

	// 조회 리스트
	public List<BreadCartVO> searchList(String memberId) {
		return dao.cartSearchList(memberId);
	}

	// 삭제
	public BreadCartVO delete(String cartId) {
		return dao.deleteCart(cartId);
	}
	//수정
	public BreadCartVO update(String memberId, String productId, int cartCount) {
		return null;
	}

}
