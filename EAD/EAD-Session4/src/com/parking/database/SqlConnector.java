package com.parking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlConnector {
	
	final String jdbcDriver = "com.mysql.jdbc.Driver";
	final String databaseName = "parkingSystem";
	final String url = "jdbc:mysql://localhost/" + databaseName;
	final String userName = "root";
	final String pass = "mysql1228";
	
	
	/**
	 * This method used to get Connection with mysql database
	 * @return connection object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(jdbcDriver);	
		Connection conn = DriverManager.getConnection(url, userName, pass);
		
		return conn;
	}
	
	/**
	 * This method used to close connection and statement
	 * @param conn
	 * @param statement
	 * @throws SQLException
	 */
	protected void closeConnection(Connection conn, PreparedStatement statement) throws SQLException{
		conn.close();
		statement.close();
	}


}
