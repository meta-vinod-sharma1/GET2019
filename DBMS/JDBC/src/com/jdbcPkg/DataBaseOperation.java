package com.jdbcPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class DataBaseOperation {


	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String databaseName = "store_front";
	private final String url = "jdbc:mysql://localhost/" + databaseName;
	private final String userName = "root";
	private final String pass = "mysql1228";

	Connection connectionObj = null;
	PreparedStatement statementObj = null;
	Scanner inputObj = new Scanner(System.in);

	private boolean setConnection(){

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

	public void ordersOfUser(int shopperId){

		if(setConnection()){
			try{

				String sql = " SELECT shopper_id, orderDate, ordertotal " +
						"FROM ordertable " +
						"WHERE status = 'shipped' && shopper_id =" + Integer.toString(shopperId) + 
						" ORDER BY orderDate"; 
				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);
				
				if (result.next() == false){
					System.out.println("ResultSet in empty");
				}else{ 
							System.out.println("userId\t orderDate\t orderTotal\n");
						do{ System.out.println(result.getString(1) +"         " + result.getString(2) + "   " + result.getString(3));
						 }while (result.next());
				}
				statementObj.close();
				connectionObj.close();

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}
	}

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

	public int deleteNotOrderedProduct(){
		if(setConnection()){
			try{
				connectionObj.setAutoCommit(false);
				String sql = "DELETE P.product_id " +
							 "FROM product P " +
							 "WHERE NOT EXISTS( " +
							 "SELECT O.product_id " +
							 "FROM ordersItem O " +
							 "INNER JOIN ordertable " +
							 "ON O.orderid = ordertable.orderid " + 
						     "WHERE O.product_id = P.product_id " +
							 "&& ordertable.orderDate >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
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
	
	public void topCategory(){
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
				
				if (result.next() == false){
					System.out.println("ResultSet in empty");
				}else{ 
							System.out.println("Category Name\t CountChild");
						do{ 
							System.out.println(result.getString(1) +"         " + result.getString(2));
						 }while (result.next());
				}

				statementObj.close();
				connectionObj.close();
				

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}

	}
		
}

