package com.parking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parking.database.DatabaseOperation;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

		// Get the HttpSession object.
		HttpSession session = request.getSession();
		
		DatabaseOperation db = new DatabaseOperation();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			
			ResultSet result = db.employeeLogInfo(email,password);	
			result.next();
			if(email.equals(result.getString("email")) && password.equals(result.getString("password"))){
				// Store user information into a Session attribute.
				session.setAttribute("email",request.getParameter("email"));
				if(result.getString("type")== null){
					request.setAttribute("empId", result.getString("empId"));
					RequestDispatcher rd = request.getRequestDispatcher("vehicleForm.jsp");
					rd.forward(request,response);
				}else{
					response.sendRedirect("home.jsp");
	
//					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//					rd.forward(request,response);
				}
			}else{
				String upperBody = "<html> <head><title>Log In</title></head> <body style ='background-color: antiquewhite'>";
				String lowerBody = "<a href='logIn.jsp'>Login</a></body> <html>";
				String middleBody = "<h1 align='center'>User name and Password is Wrong !! login Again</h1>";
				ServletOutputStream out = response.getOutputStream();
				out.println(upperBody+middleBody+lowerBody);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
