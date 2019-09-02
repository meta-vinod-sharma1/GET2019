package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		final String jdbcDriver = "com.mysql.jdbc.Driver";
		final String databaseName = "school";
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
	
	public int addStudent(String firstName, String lastName, String fatherName, String email, int classNo, int age){
		
		if(setConnection()){
			try{
				connectionObj.setAutoCommit(false);
				String sql = "INSERT INTO student_details(firstName,lastName,fatherName,email,classNo,age) " +
							 "VALUES(?,?,?,?,?,?) "; 
				
				statementObj = connectionObj.prepareStatement(sql);
				
				statementObj.setString(1,firstName);
				statementObj.setString(2,lastName);
				statementObj.setString(3,fatherName);
				statementObj.setString(4,email);
				statementObj.setInt(5, classNo);
				statementObj.setInt(6, age);
				
				int value = statementObj.executeUpdate();	 
				connectionObj.commit();
				statementObj.close();
				connectionObj.close();

				return value;


			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}

		return -1;
	}
	
	public ArrayList<Student> getStudent(){
		ArrayList<Student> studentList = null;
		
		if(setConnection()){
			try{

				String sql = "SELECT * FROM student_details"; 
				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);
				studentList = new ArrayList<Student>();
				while(result.next()){
					Student studentObj = new Student(result.getInt(1),result.getString(2), result.getString(3),result.getString(4),result.getString(5),
															result.getInt(6),result.getInt(7));
					studentList.add(studentObj);
				}
				statementObj.close();
				connectionObj.close();

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}else{
			System.out.println("Connection Failed");
		}
		
		return studentList;
	}
	
	public Student getStudentById(int studentId){
		Student studentObj = null;
		if(setConnection()){
			try{

				String sql = "SELECT * FROM student_details WHERE studentId =" + studentId; 
				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);

				while(result.next()){
					studentObj = new Student(result.getInt(1),result.getString(2), result.getString(3),result.getString(4),result.getString(5),
															result.getInt(6),result.getInt(7));
				}
				statementObj.close();
				connectionObj.close();

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}
		}else{
			System.out.println("Connection Failed");
		}
		return studentObj;
	}
	
	public int updateStudent(int studentId,String firstName, String lastName, String fatherName, String email, int classNo, int age){
			int value = -1;
			if(setConnection()){
				try{
					
					System.out.println(studentId);

					String sql = "UPDATE student_details"
							+ " SET firstName='" + firstName
							+"',  lastName='" + lastName
							+"', fatherName='" + fatherName
							+"', email='" + email
							+"', classNo='" + classNo
							+"', age='" + age
							+ "' WHERE studentId =" + studentId; 
					statementObj  = connectionObj.prepareStatement(sql);
					value = statementObj.executeUpdate();
					statementObj.close();
					connectionObj.close();

				}catch(SQLException e){

					System.out.println("Exception : " + e);
				}
			}else{
				System.out.println("Connection Failed");
			}
			
		return value;
	}
	
	public ArrayList<Student> searchStudent(String firstName, String lastName){
		ArrayList<Student> studentList = null;
		if(setConnection()){
			try{

				String sql = "SELECT * FROM student_details WHERE firstName ='"+ firstName + "' AND lastName='" +lastName + "'"; 
				statementObj  = connectionObj.prepareStatement(sql);
				ResultSet result = statementObj.executeQuery(sql);
				
				studentList = new ArrayList<Student>();
				while(result.next()){
					studentList.add(new Student(result.getInt(1),result.getString(2), result.getString(3),result.getString(4),result.getString(5),
															result.getInt(6),result.getInt(7)));
				}
				statementObj.close();
				connectionObj.close();

			}catch(SQLException e){

				System.out.println("Exception : " + e);
			}catch(Exception e){
				System.out.println("Exception :" + e);
			}
		}else{
			System.out.println("Connection Failed");
		}
		
		return studentList;
	}
}

