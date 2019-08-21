package com.jdbcPkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


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
						db.ordersOfUser(userId);
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
						db.topCategory();
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
