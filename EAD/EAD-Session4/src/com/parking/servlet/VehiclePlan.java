package com.parking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parking.database.DatabaseOperation;
import com.parking.validation.Validation;

/**
 * Servlet implementation class VehiclePlan
 */
public class VehiclePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiclePlan() {
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
		DatabaseOperation db = new DatabaseOperation();
		ServletOutputStream out = response.getOutputStream();
		Validation validation = new Validation();
		String middleBody = "";
		try {
			if(!request.getParameter("empId").equals("null")){
				if(validation.SessionValidation(request)){
					System.out.println(request.getParameter("empId")+request.getParameter("vname")+request.getParameter("vtype")+request.getParameter("vnumber")+
							request.getParameter("identification"));
					int returnVehicleValue = db.addVehicle(request.getParameter("empId"),request.getParameter("vname"),request.getParameter("vtype"),request.getParameter("vnumber"),
											request.getParameter("identification"));
					
					
					int returnPlanValue = db.addPlan(request.getParameter("empId"),request.getParameter("vnumber"), plan(request.getParameter("price")), price(request.getParameter("price")));
						
					if(returnPlanValue == 1 && returnVehicleValue ==1){
						middleBody = "<h1> Successfully Vehicle and Plan added</h1>";
					}else{
						middleBody = "<h1> Failed !! try Again";
					}
				}else{
					middleBody = "<h1> Can't process without Login </h1>";
				}
			}else{
				middleBody = "<h1>You Can't process this manually <h1>";
			}
			String upperBody = "<html> <head><title>Vehicle Resiter Form</title></head> <body style ='background-color: antiquewhite'>";
			String lowerBody = "<a href='home.jsp'>Home</a></body> <html>";
			out.println(upperBody+middleBody+lowerBody);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * This method used to retrive information of plan from a mixed String
	 * @param planString mixed String coming from form
	 * @return plan of the pass
	 */
	private String plan(String planString){
		char planCharacter = planString.charAt(0);
		String plan;
		
		switch(planCharacter){
		case 'D':
			plan = "Daily";
			break;
		case 'M':
			plan = "Monthly";
			break;
		case 'Y':
			plan ="Yearly";
			break;
			default:
				plan = "";
			
		}
		return plan;
	}
	
	/**
	 * This method used to retrive information from the mixed String
	 * @param priceString
	 * @return
	 */
	private double price(String priceString){
		String priceValue = "";
		
		for(int index=1;index<priceString.length(); index++){
			priceValue += priceString.charAt(index); 
		}
		
		double value = Double.parseDouble(priceValue);
		
		return value;
	}

}
