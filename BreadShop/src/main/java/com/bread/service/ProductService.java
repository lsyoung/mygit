package com.bread.service;

import java.util.List;

import com.bread.dao.BreadProductDAO;
import com.bread.vo.BreadProductVO;

public class ProductService {
	BreadProductDAO dao = new BreadProductDAO();

	// 한건입력
	public BreadProductVO insert(BreadProductVO vo) {
		return dao.productInsert(vo);
	}

	// 전체조회
	public List<BreadProductVO> searchAll() {
		return dao.productList();
	}

	// 조회 리스트
	public List<BreadProductVO> searchList(String searchField, String productName) {
		return dao.productSearchList(searchField, productName);
	}

	// 한건조회
	public BreadProductVO searchOne(String productId) {
		return dao.productSearch(productId);
	}

	// 수정
	public BreadProductVO update(BreadProductVO vo) {
		return dao.productUpdate(vo);
	}

	// 삭제
	public BreadProductVO delete(String productName) {
		return dao.deleteProduct(productName);
	}

}
