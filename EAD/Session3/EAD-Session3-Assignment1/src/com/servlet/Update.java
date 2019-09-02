package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseOperation;
import com.database.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter data = response.getWriter();	
		DataBaseOperation db = new DataBaseOperation();
		int value = db.updateStudent(Integer.parseInt(request.getParameter("studentId")),request.getParameter("fname"),request.getParameter("lname"),request.getParameter("father_name"),request.getParameter("email"),
				Integer.parseInt(request.getParameter("class")),Integer.parseInt(request.getParameter("age")));
		String upperBody = "<html> <head><title>Add Student</title></head> <body style ='background-color: antiquewhite'>";
		String lowerBody = "</body> <html>";
		String content = "";
		
		if(value == 1){
			
			content = "<h2 align = center> Student is Updated <h2> " +
							"<a href='index.html'> Back To HOME </a>";
			
			
			
		}else{
			content = "<h2 align = center> Email is Already Exist <h2>" +
					 "<a href='index.html'> Back To Home</a>";
		}
		
		data.println(upperBody + content + lowerBody);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
