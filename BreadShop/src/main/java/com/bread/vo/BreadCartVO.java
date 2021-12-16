
package com.bread.vo;

public class BreadCartVO { 
	// String cartId;  String memberId; String productId; int cartPrice; int cartCount; String productName; String productImage;
	private String cartId;
	private String memberId;
	private String productId;
	private int cartPrice;
	
	private int cartCount;
	private String productName;
	private String productImage;

	public BreadCartVO() {
		super();
	}

	public BreadCartVO(String cartId, String memberId, String productId, int cartPrice, int cartCount,
			String productName, String productImage) {
		super();
		this.cartId = cartId;
		this.memberId = memberId;
		this.productId = productId;
		this.cartPrice = cartPrice;
		this.cartCount = cartCount;
		this.productName = productName;
		this.productImage = productImage;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "BreadCartVO [cartId=" + cartId + ", memberId=" + memberId + ", productId=" + productId + ", cartPrice="
				+ cartPrice + ", cartCount=" + cartCount + ", productName=" + productName + ", productImage="
				+ productImage + "]";
	}

}
