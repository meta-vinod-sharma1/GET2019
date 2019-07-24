package searchPkg;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		Search searhObj = new Search();
		System.out.println("Enter Array length :");
		int inputArray[] = null;
		try{
			int sizeOfArray = inputObj.nextInt();
			if(sizeOfArray < 1){
				System.out.println("Please enter Array length at least 1 !! Try again");
				main(args);
			}
			inputArray = new int[sizeOfArray];
			//collecting integers in array
			for(int i = 0; i<sizeOfArray;){
				try{
					System.out.println("enter intenger[" + (i+1) + "] :");
					inputArray[i] = inputObj.nextInt();
					if(inputArray[i] < 1){
						System.out.println("Please enter only Positive integers");
					}else{
						i++;
					}
				}catch(InputMismatchException e){
					System.out.println("Please enter only Integers !! Try Again ");
					inputObj.next();
				}
			}
		}catch(InputMismatchException e){
			System.out.println("Please Enter only integers !! Try Again");
			main(args);	
		}
		
		int choice ;
		int searchNumber = 0;
		do{
			choice = 0;
			try{
				System.out.println("Please enter number to be searched in Array");
				searchNumber = inputObj.nextInt();		
			}catch(InputMismatchException e){
				System.out.println("Please enter only integers !! Try Again");
				inputObj.nextLine();
				choice = 1;
			}
		}while(choice != 0);
		do{
			try{
				System.out.println("Enter Your Choice\n1.Search number by Linear Search\n2.Search number by Binary Search\n3.Change Search Number\n4.Exit");
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					int returnValue = searhObj.linearSearch(inputArray, searchNumber);
					if(returnValue != -1){
						System.out.println("\n-------------------------------------------------------------------------------------");
						System.out.println("Index : " + returnValue); 
						System.out.println("---------------------------------------------------------------------------------------\n");
					}else{
						System.out.println("\n-------------------------------------------------------------------------------------");
						System.out.println("Your number " + searchNumber + " is not in the Array"); 
						System.out.println("---------------------------------------------------------------------------------------\n");
					}
					break;
				case 2:
					returnValue = searhObj.binarySearch(inputArray, searchNumber);
					if(returnValue != -1){
						System.out.println("\n-------------------------------------------------------------------------------------");
						System.out.println("Index : " + returnValue); 
						System.out.println("---------------------------------------------------------------------------------------\n");
					}else{
						System.out.println("\n-------------------------------------------------------------------------------------");
						System.out.println("Your number " + searchNumber + " is not in the Array"); 
						System.out.println("---------------------------------------------------------------------------------------\n");
					}
					break;
				case 3:
					System.out.println("Enter New Number :");
					searchNumber = inputObj.nextInt();
					break;
				case 4:
					break;
					default :
						System.out.println("Invalid Choice");
				}
			}catch(InputMismatchException e){
				System.out.println("Please enter only integer value !! Try Again");
				inputObj.nextLine();
			}
		}while(choice != 4);

	}

}
