package com.jdbcPkg;

/*
 *This is Category Class which have method to get Name of Top Category and it's Child 
 */
public class Category {
	
	private String name;
	private int child;

	public Category(String name, int noOfChild){
		this.name = name;
		this.child = noOfChild;
	}
	
	/**
	 * get to know name of Category
	 * @return name of category
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method used to get no of child of a Category
	 * @return
	 */
	public int getnoOfChild(){
		return child;
	}

}
