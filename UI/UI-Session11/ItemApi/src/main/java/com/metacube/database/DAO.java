package com.metacube.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					.getConnection("jdbc:mysql://localhost:3306/items",
							"root", "mysql1228");
			System.out.println("Remote DB connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	/**
	 * This method returns a resultset containing all books
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static ResultSet getItems() throws SQLException {
		ResultSet result = null;
		Connection connect = buildConnection();
		String query = "select * from new_table";
		PreparedStatement statement = connect.prepareStatement(query);
		result = statement.executeQuery();
		return result;
	}

	

}
