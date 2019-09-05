package com.parking.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.database.DatabaseOperation;
import com.parking.pojo.Profile;

/**
 * Servlet implementation class ViewProfile
 */
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("uem");
		
		DatabaseOperation db = new DatabaseOperation();
		try {
			ResultSet result = db.getProfileByEmail(email);
			Profile profile = new Profile();
			while(result.next()){
				profile.setName(result.getString(1));
				profile.setEmail(result.getString(2));
				profile.setPhoneNumber(result.getString(3));
				profile.setVehicleNumber(result.getString(4));
				profile.setOrganization(result.getString(5));
				request.setAttribute("profile", profile);
				
				RequestDispatcher rd = request.getRequestDispatcher("viewProfile.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
