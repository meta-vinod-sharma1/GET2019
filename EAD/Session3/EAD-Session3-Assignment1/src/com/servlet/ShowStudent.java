package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseOperation;
import com.database.Student;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		DataBaseOperation db = new DataBaseOperation();
		ArrayList<Student> studentList = db.getStudent();
		
		String upperBody = "<html> <head><title>Add Student</title> <link rel='stylesheet' type='text/css' href='/EAD-Session3/css/studentDisplay.css'>"
				+ "</head> <body> <a href='index.html/'>Back to Homea</a>";
		String lowerBody = "</body> <html>";
		String content = "<table>"+
							"<th>StudentId</th> <th>FirstName</th> <th>LastName</th> <th>FatherName</th> <th>Email</th> <th></th>";
		if(studentList != null){
			for(int i=0; i<studentList.size(); i++){
				content = content + "<tr>" +
									"<td>" + studentList.get(i).getStudentId() + "</td>" +
									"<td>" + studentList.get(i).getFirstName() + "</td>" +
									"<td>" + studentList.get(i).getLastName() + "</td>" +
									"<td>" + studentList.get(i).getFatherName() + "</td>" +
									"<td>" + studentList.get(i).getEmail() + "</td>" +
									"<td>" + "<a href=" +
									"http://localhost:8081/EAD-Session3/updateStudent.jsp?" +
									"studentId=" + studentList.get(i).getStudentId() + ">Update</a>" + "</td>";	
				
			}
		}else{
			content = "<h1> Failed Try Again <h1>";
		}		
		out.println(upperBody + lowerBody + content);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
