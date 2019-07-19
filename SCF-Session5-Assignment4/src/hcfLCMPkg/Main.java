package hcfLCMPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *@description This class can be used to Menu options for find LCM and HCF
 * @author Vinod
 * @date 18/07/2019
 *
 */
public class Main {

	public static void main(String[] args) {
		Operations OperationsObj = new Operations();
		Scanner inputObj = new Scanner(System.in);
		int choice = 0;
		int firstNumber;
		int secondNumber;
		do{
			System.out.println("Enter Your Choice\n1.Find HCF\n2.Find LCM\n3.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("Enter First Number :");
					firstNumber= inputObj.nextInt();
					System.out.println("Enter Second Number");
					secondNumber = inputObj.nextInt();
					if(firstNumber < 0 || secondNumber < 0){
						System.out.println("you filled negative values Sorry !! Try again");
						break;
					}
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("HCF :" + OperationsObj.highestCommonFactor(firstNumber, secondNumber));
					System.out.println("-------------------------------------------------------------------------------------------");
					break;
				case 2:
					System.out.println("Enter First Number :");
					firstNumber= inputObj.nextInt();
					System.out.println("Enter Second Number");
					secondNumber = inputObj.nextInt();
					if(firstNumber < 0 || secondNumber < 0){
						System.out.println("you filled negative values Sorry !! Try again");
						break;
					}
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("LCM :" + OperationsObj.leastCommonMultiple(firstNumber, secondNumber));
					System.out.println("-------------------------------------------------------------------------------------------");
					break;
				case 3:
					break;
					default:
						System.out.println("Invalid Choice !!");
				}
				
			}catch(InputMismatchException e){
				System.out.println("Please Enter only integer value !!Try again");
				inputObj.nextLine();
				
			}
		}while(choice!=3);
	}
}
