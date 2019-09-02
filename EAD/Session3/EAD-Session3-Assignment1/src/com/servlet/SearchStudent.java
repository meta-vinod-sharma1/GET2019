package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseOperation;
import com.database.Student;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBaseOperation db = new DataBaseOperation();
		ArrayList<Student> studentList = db.searchStudent(request.getParameter("fname"), request.getParameter("lname"));
		PrintWriter out = response.getWriter();
		
		if(studentList!=null){
				request.setAttribute("studentList",studentList);
				RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
				rd.forward(request,response);
			
		}else{
			String upperBody = "<html> <head><title>Search Student</title></head> <body style ='background-color: antiquewhite'>";
			String lowerBody = "</body> <html>";
			String content = "<h1 align=center> No Students Found according giving details </h1>" + "<a href='search.jsp'> Back To Search</a>";
			
			out.println(upperBody + content + lowerBody);
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
