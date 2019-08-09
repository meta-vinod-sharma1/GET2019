package session4Pkg.uniquePkg;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class for Operations to know unique characters in the string 
 * @author Vinod
 * @date 03/08/2019
 */
public class Main {
	public static String view = "-------------------------------------------------------------------";
	public static void main(String[] args) {
		
		Scanner inputObj = new Scanner(System.in);
		UniqueCharacters uniqueObj = new UniqueCharacters();
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Check Unique Characters in the string\n2.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					inputObj.nextLine();
					System.out.println("Please Enter String");
					System.out.println(view+"\nYour Output : " + uniqueObj.countUniqueCharacters(inputObj.nextLine()));
					System.out.println(view);
					
				case 2:
					break;
					default:
						System.out.println(view);
						System.out.println("Invalid Choice  !! Try Again");
						System.out.println(view);
				}	
			}catch(InputMismatchException exception){
				System.out.println(view);
				System.out.println("Warning : Please Enter only Integer Value !! Try Again");
				System.out.println(view);
				inputObj.nextLine();
			}
		}while(choice!=2);
	}

}