package com.shopping.model;


public class Product extends BaseEntity {
	
	private String productType;
	private String productName;
	private double productPrice;
	
	public Product(int productCode, String productType, String productName, double productPrice)
	{
		super(productCode);
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	//Getter methods
	public String getProductType() {
		return productType;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

}
