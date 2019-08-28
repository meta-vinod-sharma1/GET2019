package com.jdbcPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class have methods of operations on database like fetch orders details, setConnectins etc.
 * @author Vinod
 *
 */
public class DataBaseOperation {


	Connection connectionObj = null;
	PreparedStatement statementObj = null;
	Scanner inputObj = new Scanner(System.in);
	
	/**
	 * This method used to set connections with the database internally in this class
	 * @return true if connection successfully connect otherwise false 
	 */
	private boolean setConnection(){
		
		final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		final String databaseName = "store_front";
		final String url = "jdbc:mysql://localhost/" + databaseName;
		final String userName = "root";
		final String pass = "mysql1228";

		try{
			Class.forName(jdbcDriver);
			connectionObj = DriverManager.getConnection(url, userName, pass);

			return true;
		}catch(SQLException e){
			if(connectionObj == null){
				System.out.println("Connecting Failed ");
			}else{
				System.out.println("Failed !! Exception : " + e);
			}
		}catch(ClassNotFoundException e){
			System.out.println("Diver not intialized Exception : " + e);
		}
		return false;
	}
	
	/**
	 * This method used to retrieve details of Order of given shopperId which are in the shipped state
	 * @param shopperId 
	 * @return ArrayList of Orders object
	 */
	public ArrayList<Order> ordersOfUser(int shopperId){
		
		ArrayList<Order> orderList = null;
		if(setConnection()){
			try{

				String sql = " SELECT shopper_id, orderDate, ordertotal " +
						"FROM ordertable " +
						"WHERE status = 'shipped' && shopper_id =" + Integer.toString(shopperId) + 
						" ORDER BY orderDate"; 
				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);
				orderList = new ArrayList<Order>();
				while(result.next()){
					Order orderObj = new Order(result.getInt(1),result.getString(2),result.getInt(3));
					
					orderList.add(orderObj);
				}
				statementObj.close();
				connectionObj.close();

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}else{
			System.out.println("Connection Failed");
		}
		
		return orderList;
	}
	
	/**
	 * This method used to insert 5 images for a particular product in the database
	 * @return affected rows of database
	 */
	public int insertImage(){
		if(setConnection()){
			try{
				connectionObj.setAutoCommit(false);
				String sql = "INSERT INTO image(product_id, img) " + 
						"VALUES(?,?)";
				statementObj = connectionObj.prepareStatement(sql);


				for(int index=1; index <6; index++){
					System.out.println("Enter product id for image[" + index + "]:");
					int id = inputObj.nextInt();
					inputObj.nextLine();
					System.out.println("Enter image name for image[" + index + "]:");
					String name = inputObj.nextLine();
					name += ".jpg";
					statementObj.setInt(1, id);
					statementObj.setString(2,name ); 
					statementObj.addBatch();
				}
				int count[] = statementObj.executeBatch();	 
				connectionObj.commit();
				statementObj.close();
				connectionObj.close();

				return count.length;


			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}

		return -1;
	}
	
	/**
	 * This method used to delete records of  product which not ordered since 1 year from the product table 
	 * @return rows affected count
	 */
	public int deleteNotOrderedProduct(){
		if(setConnection()){
			try{
				connectionObj.setAutoCommit(false);
				String sql = "DELETE FROM product "+ 
							"WHERE product_id NOT IN( "+
							    "SELECT DISTINCT ordersItem.product_id "+
							    "FROM ordersItem "+
							    "INNER JOIN ordertable "+
							    "ON ordertable.orderid = ordersItem.orderid "+
							    "WHERE ordertable.orderDate >= DATE_SUB(CURDATE(),INTERVAL 1 YEAR) )";
				statementObj = connectionObj.prepareStatement(sql);


				int count = statementObj.executeUpdate(sql);	 
				connectionObj.commit();
				statementObj.close();
				connectionObj.close();
				System.out.println("Count :" + count);

				return count;


			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}

		return -1;
	}
	
	/**
	 * This method used to get Category List 
	 * @return Category List
	 */
	public ArrayList<Category> topCategory(){
		
		ArrayList<Category> categoryList = null;
		if(setConnection()){
			try{

				String sql = "SELECT A.name, COUNT(*) " +
							 "FROM category A " +
							 "LEFT JOIN category B " +
							 "ON A.id = B.parent_id " +
							 "WHERE A.parent_id is null " +
						 	 "GROUP BY A.name " +
							 "ORDER BY A.name";

				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);
				
				categoryList = new ArrayList<Category>();
				
				while(result.next()){
					Category obj = new Category(result.getString(1), result.getInt(2));
					categoryList.add(obj);
				}
				statementObj.close();
				connectionObj.close();
				

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}
		return categoryList;

	}
		
}

