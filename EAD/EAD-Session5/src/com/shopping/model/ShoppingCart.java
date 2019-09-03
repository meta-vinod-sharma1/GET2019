package com.shopping.model;


public class ShoppingCart extends BaseEntity {
	private int productId;
	private int productQuantity;
	private int userId;
	
	public ShoppingCart(int cartId, int userId, int productId, int productQuantity)
	{
		super(cartId);
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.userId = userId;
	}
	public ShoppingCart()
	{
		super();
	}

	//Getter methods
	public int getProductId() {
		return productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public int getUserId() {
		return userId;
	}
}
