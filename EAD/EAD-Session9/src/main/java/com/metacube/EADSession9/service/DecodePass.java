
package com.metacube.EADSession9.service;

/**
 * This class used to retrive a plan and price from the mixed information of prince and plan
 * @author Vinod
 *
 */
public class DecodePass {
	
	/**
	 * This method used to retrive info from the plan example daily, mothly or yearly form the mixed string
	 * @param planString mixed String of plan and price
	 * @return plan of pass
	 */
	public String plan(String planString ){
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
	
	public double price(String priceString){
		String priceValue = "";
		
		for(int index=1;index<priceString.length(); index++){
			priceValue += priceString.charAt(index); 
		}	
		double value = Double.parseDouble(priceValue);
		
		return value;
	}
}
