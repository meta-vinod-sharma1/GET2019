

package shop;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class shopping {
	public static void main(String args[]){
		
		cart C= new cart();
		itemList il= new itemList();
		il.create();
		Scanner s= new Scanner(System.in);
		int choice=-999;
		do{
			System.out.println(" 1-> Add item in Cart");
			System.out.println(" 2-> Update item in Cart");
			System.out.println(" 3-> Remove item in Cart");
			System.out.println(" 4-> Generate Bill");
			System.out.println(" 5-> Display Cart");
			System.out.println(" 6-> Exit");
			choice=s.nextInt();
			switch(choice) {
			   case 1 :
				   		C.addItemInCart(il);
				   		break;   
			   case 2 :
					      C.updateItemInCart(il);
					      break;
			   case 3 :
					      C.removeItemInCart();
					      break;
			   case 4 :
					      C.bill();
					      break;
			   case 5:
				   		  C.displayCart();
				   		  break;
			   case 6:
				   		  break;
			   default : 
				   			System.out.println("Please Provide a Valid Key !!!");
			}
			
		}while(choice!=6);
		
		System.out.println("Exit Succesfully");
		
	}
}
