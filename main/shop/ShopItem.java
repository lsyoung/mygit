package com.yedam.shop;

public class ShopItem {

	private String itemCode;
	private String itemName;
	private String itemDesc;
	private int originPrice;
	private int salePrice;
	private double liktIt;
	private String image;
	

	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public double getLiktIt() {
		return liktIt;
	}
	public void setLiktIt(double liktIt) {
		this.liktIt = liktIt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "shopItem [itemCode=" + itemCode + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", originPrice="
				+ originPrice + ", salePrice=" + salePrice + ", liktIt=" + liktIt + ", image=" + image + "]";
	}
	
	

}
