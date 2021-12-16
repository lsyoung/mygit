package com.bread.vo;

public class BreadProductVO {

	private String productId;
	private String productName;
	private String productDesc;
	private int productPrice;
	private String productImage;
	private double productGrade;
	private int productCount;
	private int productInventory;

	public BreadProductVO() {
		super();
	}

	public BreadProductVO(String productId, String productName, String productDesc, int productPrice,
			String productImage, double productGrade, int productCount, int productInventory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productGrade = productGrade;
		this.productCount = productCount;
		this.productInventory = productInventory;
	}

	@Override
	public String toString() {
		return "BreadProductVO [productId=" + productId + ", productName=" + productName + ", productDesc="
				+ productDesc + ", productPrice=" + productPrice + ", productImage=" + productImage + ", productGrade="
				+ productGrade + ", productCount=" + productCount + ", productInventory=" + productInventory + "]";
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductGrade() {
		return productGrade;
	}

	public void setProductGrade(double productGrade) {
		this.productGrade = productGrade;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}

}
