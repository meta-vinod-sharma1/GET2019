package com.metacube.Validation;

import com.metacube.model.Book;

/**
 * This class is used to validate data which is going to insert in the database.
 * @author Vinod
 *
 */
public class DataValidation {
	
	/**
	 * This method used to validate data which going to insert in database
	 * @param bookObj book object of Book class
	 * @return true if data is valid otherwise false
	 */
	public boolean insertValidation(Book bookObj){
		boolean flag = true;
		if(bookObj.getId() < -1){
			flag = false;
		}else if(bookObj.getTitle().length() > 150){
			flag = false;
		}else if(bookObj.getPublisher().length() > 150){
			flag = false;
		}else if(bookObj.getWriter().length() > 150){
			flag = false;
		}
		
		
		return flag;
	}

}
