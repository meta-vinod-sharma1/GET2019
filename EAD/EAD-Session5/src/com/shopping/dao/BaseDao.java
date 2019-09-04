package com.shopping.dao;

import java.util.List;

import com.shopping.enums.Status;
import com.shopping.model.*;


public interface BaseDao<T extends BaseEntity> {
  
    /**
     * Method to return the list of Product and  available stock
     * @param query is the query to be executed
     * @return {List<Product>} the list of Product and available stock
     */
    public List<Product> getAllProduct(String query);
    
    /**
     * Method to add product into cart
     * @param query is the query to be executed
     * @return {Status} status of product added to cart or not
     */
    public Status addProductToCart(String query);
    
    /**
     * Method to get cart items with quantity
     * @param query is the query to be executed
     * @return {List<ShoppingCart>} cart items with quantity
     */
    public List<ShoppingCart> getCart(String query);
    
    /**
     * Method to update cart items
     * @param query is the query to be executed
     * @return {Status} status of cart updated or not
     */
    public Status updateProductsInCart(String query);

    /**
     * Method to find product id by product name
     * @param query is the query to be executed
     * @return {int} product id
     */
	public int findProductIdByName(String query);

	/**
     * Method to find product Name by product Id
     * @param productName is the name of the product
     * @return {String} product Name
     */
	public String getProductNameById(String query);

	/**
     * Method to delete product from cart
     * @param userId is the user id
     * @param productId is the product id
     * @return {Status}
     */
	public Status deleteProductFromCart(String query);

	/**
     * Method to find user Id by user email
     * @param emailId is the email id of the user
     * @return {int} user Id
     */
	public int findUserIdByEmailId(String query);

	/**
	 * Method to authenticate the user
	 * @param userId is the user id
	 * @param password is the user password
	 * @return {boolean}
	 */
	public boolean authenticateUser(String query);
   
}
