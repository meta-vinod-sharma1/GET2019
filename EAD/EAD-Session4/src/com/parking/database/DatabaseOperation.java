package com.parking.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parking.pojo.Employee;
import com.parking.pojo.Profile;

public class DatabaseOperation {
	
	PreparedStatement statement = null;
	SqlConnector sqlConn = null;
	Connection conn = null;
	
	public int addEmployee(Employee emp) throws SQLException, ClassNotFoundException{
		int value = 0;
	
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
			
		String sql = "INSERT INTO employeeDetails(name,gender,email,password,phoneNumber,organization) " +
					 "VALUES(?,?,?,?,?,?) ";
		PreparedStatement statement = conn.prepareStatement(sql);
			
		statement.setString(1, emp.getName());
		statement.setString(2, emp.getGender());
		statement.setString(3, emp.getEmail());
		statement.setString(4, emp.getPassword());
		statement.setLong(5, emp.getPhoneNumber());
		statement.setString(6, emp.getOrganization());
			
		value = statement.executeUpdate();
		return value;
		
	}
	
	public ResultSet employeeLogInfo(String email, String password) throws SQLException, ClassNotFoundException{
		ResultSet result = null;
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
		String sql = "CALL EmployeeLogDetail('" + email +"','"+password + "')";
		statement = conn.prepareStatement(sql);
		result = statement.executeQuery();
		
		
		return result;
	}
	



	

	public int addVehicle( String empId, String vehicleName, String vehicleType, String vehicleNumber, String identification) throws SQLException, ClassNotFoundException {
		int value = 0;
		
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
			
		String sql = "INSERT INTO vehicleDetails(empId,name,type,vehicleNumber,identification) " +
					 "VALUES(?,?,?,?,?) ";
		PreparedStatement statement = conn.prepareStatement(sql);
			
		statement.setInt(1, Integer.valueOf(empId));
		statement.setString(2, vehicleName);
		statement.setString(3, vehicleType);
		statement.setString(4, vehicleNumber);
		statement.setString(5, identification);
			
		value = statement.executeUpdate();	
		return value;
	}
	
	
	public int addPlan(String empId, String vehicleNumber, String plan, double price) throws SQLException, ClassNotFoundException{
		int value = 0;
		
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
			
		String sql = "INSERT INTO plan_details(empId,vehicleNumber,plan,price) " +
					 "VALUES(?,?,?,?) ";
		PreparedStatement statement = conn.prepareStatement(sql);
					
		statement.setInt(1, Integer.valueOf(empId));
		statement.setDouble(4, price);
		statement.setString(3, plan);
		statement.setString(2, vehicleNumber);
			
		value = statement.executeUpdate();	
		return value;
	}
	
	public ResultSet getFriends(String email) throws ClassNotFoundException, SQLException{
		ResultSet result = null;
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
		String sql = "CALL Friends('"+ email +"')";
		statement = conn.prepareStatement(sql);
		result = statement.executeQuery();
		
		
		return result;
	}
	
	public Employee getEmployeeByEmail(String email) throws ClassNotFoundException, SQLException{
		Employee emp = null;
		ResultSet result = null;
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
		String sql = "SELECT * FROM employeeDetails WHERE email='" + email +"'";
		statement = conn.prepareStatement(sql);
		result = statement.executeQuery();
		
		while(result.next()){
			emp = new Employee(result.getString("name"),result.getString("gender"),result.getString("email"),"",result.getLong("phoneNumber"),"",result.getInt("empId"));
		}
		
		return emp;
	}
	
	public void closeConnection() throws SQLException{
		sqlConn.closeConnection(conn, statement);
	}

	public int updateEmployee(Employee empObj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE employeeDetails"
				+ " SET name='" + empObj.getName() 
				+"',  gender='" + empObj.getGender()
				+"', password='" + empObj.getPassword()
				+"', phoneNumber='" + empObj.getPhoneNumber()
				+"', organization='" + empObj.getOrganization()
				+ "' WHERE email = '" + empObj.getEmail() +"'";
		int value = 0;
		
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
			
		PreparedStatement statement = conn.prepareStatement(sql);
			
		value = statement.executeUpdate();	
		return value;
	}
	
	public ResultSet getProfileByEmail(String email) throws ClassNotFoundException, SQLException{
		ResultSet result = null;
		sqlConn = new SqlConnector();
		conn = sqlConn.getConnection();
		String sql = "CALL getProfileByEmail('" + email +"')";
		statement = conn.prepareStatement(sql);
		result = statement.executeQuery();

		return result;
	}
}
