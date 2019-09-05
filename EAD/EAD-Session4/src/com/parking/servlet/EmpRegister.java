package com.parking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.database.DatabaseOperation;
import com.parking.pojo.Employee;
import com.parking.validation.Validation;

/**
 * Servlet implementation class EmpRegister
 */
public class EmpRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Employee Register Form will come here
		Employee empObj = new Employee(request.getParameter("name"),request.getParameter("gender"),request.getParameter("email"),request.getParameter("password"),
					Long.parseLong(request.getParameter("number")),request.getParameter("org"),-1);
		
		DatabaseOperation db = new DatabaseOperation();
		Validation validation = new Validation();
		
		ServletOutputStream out = response.getOutputStream();
		
		String middleBody = "";
		
		try {
				if(validation.EmployeeValidation(empObj)){
					int returnValue = db.addEmployee(empObj);
					if(returnValue == 1){
						
						middleBody = "<h1>Registration Succesfully Submitted</h1>";
						
					}else{
						middleBody = "<h1>Failed !! Try again</h1>";
					}
				}else{
					middleBody = "<h1>Data is too Long</h1>";
				}
		}catch(java.sql.SQLIntegrityConstraintViolationException e){
			middleBody = "<h1>Email is Already Exist</h1>";
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			middleBody = "<h1>Exception occurred</h1>"; 
		} 
		String upperBody = "<html> <head><title>Add Student</title></head> <body style ='background-color: antiquewhite'>";
		String lowerBody = "<a href='home.jsp'>Home</a></body> <html>";
		out.println(upperBody+middleBody+lowerBody);	
	}

}
