package com.shopping.model;


public class BaseEntity {

	private int id;

    public BaseEntity(int id) {
        this.id = id;
    }
    public BaseEntity(){
        
    }
  
 // Getters Method
    public int getId() {
        return id;
    }
}
