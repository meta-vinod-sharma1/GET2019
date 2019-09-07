package com.metacube.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.model.Book;

/**
 * This class is out dao layer and will interact with our database 
 * @author Vinod 
 *
 */
public class DAO {
	/**
	 * This Method Builds Connection
	 * 
	 * @return Connection Object After Establishing Connection
	 */
	public static Connection buildConnection() {
		Connection connect = null;
		try {
			// JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Getting Connection
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/book_database",
							"root", "mysql1228");
			System.out.println("Remote DB connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

	/**
	 * This method adds a book to database
	 * 
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public static int addBook(Book book) throws SQLException {
		int noOfChanges = 0;
		Connection connect = buildConnection();
		String query = "insert into book() values(?,?,?,?,?)";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, book.getId());
		statement.setString(2, book.getTitle());
		statement.setString(3, book.getWriter());
		statement.setString(4, book.getPublisher());
		statement.setInt(5, book.getPublishedYear());
		noOfChanges = statement.executeUpdate();

		return noOfChanges;
	}

	/**
	 * This method returns a resultset containing all books
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static ResultSet showAllBooks() throws SQLException {
		ResultSet result = null;
		Connection connect = buildConnection();
		String query = "select * from book";
		PreparedStatement statement = connect.prepareStatement(query);
		result = statement.executeQuery();

		return result;
	}

	/**
	 * This method returns a resultset of books of specific titles
	 * 
	 * @param title
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet showBooksByTitle(String title) throws SQLException {
		ResultSet result = null;
			Connection connect = buildConnection();
			String query = "select * from book where book.title=?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, title);
			result = statement.executeQuery();
	
		return result;
	}

	/**
	 * This method update a book in the database
	 * 
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int updateBooks(Book book) throws SQLException {
		int noOfChanges = 0;
			Connection connect = buildConnection();
			String query = "update book "
					+ "set book.writer=?,book.publisher=? "
					+ "where book.title=? and book.published_year=?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, book.getWriter());
			statement.setString(2, book.getPublisher());
			statement.setString(3, book.getTitle());
			statement.setInt(4, book.getPublishedYear());
			noOfChanges = statement.executeUpdate();

		return noOfChanges;
	}

	/**
	 * This method deletes books of specific id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int deleteBooksById(int id) throws SQLException {
		int noOfChanges = 0;

			Connection connect = buildConnection();
			String query = "delete from book where book.id=?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, id);
			noOfChanges = statement.executeUpdate();

		return noOfChanges;
	}

	/**
	 * This method deletes all books from database
	 * @throws SQLException 
	 */
	public int deleteAllBooks() throws SQLException {

			Connection connect = buildConnection();
			String query = "truncate table book";
			PreparedStatement statement = connect.prepareStatement(query);
			int noOfchanges = statement.executeUpdate();
			return noOfchanges;

	}

}
