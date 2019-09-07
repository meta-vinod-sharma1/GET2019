package com.metacube.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.Validation.DataValidation;
import com.metacube.database.DAO;
import com.metacube.model.Book;

/**
 * This class used to take call towards Dao layer
 * @author Vinod
 *
 */
public class BookResourceService {
	
	
	DAO daoObj = null;
	/**
	 * Service Method to add a book
	 * 
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		boolean isAdded = false;
		
		DataValidation validation = new DataValidation();
		
		if(validation.insertValidation(book)){
			daoObj = new DAO();
			int changes = 0;
			try {
				changes = daoObj.addBook(book);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (changes == 1)
				isAdded = true;
		}
		
		return isAdded;
	}

	/**
	 * Service Method to show all books
	 * 
	 * @return
	 */
	public List<Book> getAllBooks() {
		// Adding all books in arrayList
		List<Book> bookList = new ArrayList<Book>();
		try {
			daoObj = new DAO();
			ResultSet result = daoObj.showAllBooks();
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getInt("book.id"));
				book.setTitle(result.getString("book.title"));
				book.setWriter(result.getString("book.writer"));
				book.setPublisher(result.getString("book.publisher"));
				book.setPublishedYear(result.getInt("book.published_year"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	/**
	 * Service Method to show all books of specific title
	 * 
	 * @param title
	 * @return
	 */
	public List<Book> getBooksByTitle(String title) {
		// Adding all books in arrayList
		List<Book> bookList = new ArrayList<Book>();

		try {
			daoObj = new DAO();
			ResultSet result = daoObj.showBooksByTitle(title);
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getInt("book.id"));
				book.setTitle(result.getString("book.title"));
				book.setWriter(result.getString("book.writer"));
				book.setPublisher(result.getString("book.publisher"));
				book.setPublishedYear(result.getInt("book.published_year"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;

	}

	
	/**
	 * Service Method to delete specific id books
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteBooksById(int id) {
		boolean isDeleted = false;
		daoObj = new DAO();
		int changes = 0;
		try {
			changes = daoObj.deleteBooksById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (changes != 0)
			isDeleted = true;
		return isDeleted;
	}

	/**
	 * Service Method to delete all books
	 */
	public int deleteAllBooks() {
		daoObj = new DAO();
		int value = -1;
		try {
			value = daoObj.deleteAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

	
	/**
	 * Service Method to Update a book
	 * 
	 * @param book
	 * @return
	 */
	public boolean updateBooks(Book book) {
		
		boolean isUpdated = false;
		DataValidation validation = new DataValidation();
		if(validation.insertValidation(book)){
			daoObj = new DAO();
			int changes = 0;
			try {
				changes = daoObj.updateBooks(book);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (changes > 0)
				isUpdated = true;
		}
		
		return isUpdated;
	}

}
