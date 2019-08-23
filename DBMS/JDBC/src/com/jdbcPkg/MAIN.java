package com.jdbcPkg;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This class contain operations and provide console to do operations on database.
 * @author Vinod
 * @date 23/08/2019
 *
 */
public class MAIN {

	public static void main(String[] args){
		
		 String view = "---------------------------------------------------------------------";
		 DataBaseOperation db = new DataBaseOperation();
		 Scanner inputObj = new Scanner(System.in);
		 ResultSet result = null;
		 int choice = 0;
			do{
				System.out.println("Enter Your Choice\n1.Fetch all orders by user id\n2.Insert 5 image\n" + 
									"3.delete products\n4. display top parent categories and count\n5.Exit");
				try{
					choice = inputObj.nextInt();
					System.out.println(view);
					switch(choice){
					case 1:
						System.out.println("Please Enter user id");
						int userId = inputObj.nextInt();
						System.out.println(view);
						ArrayList<Order> orderList = db.ordersOfUser(userId);
						if(orderList == null){
							System.out.println("This User don't have orders which is in Shipped State");
						}else{
							System.out.println("UserId\tOrderDate\tOrderTotal");
							for(int index = 0; index< orderList.size(); index++){
								System.out.format("%d%s%s%s%d", orderList.get(index).getId(),"       ",orderList.get(index).getDate(),"      ",orderList.get(index).orderTotal());
								System.out.println();
							}
						}
						break;
					case 2:
						int count = db.insertImage();
						if(count != -1){
							System.out.println(count + "rows are affected");
						}
						break;
					case 3:
						db.deleteNotOrderedProduct();
						break;
					case 4:
						ArrayList<Category> categoryList = db.topCategory();
						if(categoryList == null){
							System.out.println("NO Category Found");
						}else{
							System.out.println("CategoryName \t No of Child");
							for(int index=0; index<categoryList.size(); index++){
								System.out.format("%10s%s%d", categoryList.get(index).getName(),"         " ,categoryList.get(index).getnoOfChild());
								System.out.println();
							}
						}
						break;
					case 5:
						default:
							System.out.println(view + "\nInvalid Choice  !! Try Again\n" + view);
					}
					System.out.println(view);
					inputObj.nextLine();
				}catch(InputMismatchException exception){
					System.out.println(view + "\nWarning : Please Enter only Integer Value !! Try Again\n" + view);
					inputObj.nextLine();
				}
			}while(choice!=5);

	}

}
