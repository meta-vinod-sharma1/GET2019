package polyPkg;

import intSetPkg.InputSet;
import intSetPkg.IntSet;
import intSetPkg.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Poly polyObj = null;
		Menu menuObj = new Menu();
		InputPoly inputPolyObj = new InputPoly();
		Scanner inputObj = new Scanner(System.in);
		// setting the Object of Poly class by InputPoly class
		polyObj = inputPolyObj.setPolyArray();
		int choice = 0;
		do{
			try{
				menuObj.polyMenu();
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("Please enter value to evaluate in polynomial");
					float value = inputObj.nextFloat();
					System.out.println("--------------------------------------------------------");
					System.out.println("Your Output : " + polyObj.evaluate(value));
					System.out.println("--------------------------------------------------------");
					break;
				case 2:
					System.out.println("--------------------------------------------------------");
					System.out.println("Your Output : " + polyObj.degree());
					System.out.println("--------------------------------------------------------");
					break;
				case 3:
					System.out.println("--------------------------------------------------------");
					System.out.println("--------------------------------------------------------");
					break;
				case 4:
					System.out.println("Please enter details for polinomial which you want to multiply");
					System.out.print("\n-----------------------------------------------------------");
					System.out.println("----------------------------------------------------------");
					break;
				case 5:
					polyObj = inputPolyObj.setPolyArray();
					break;
				case 6:
					polyObj.displayPoly();
					break;
				case 7:
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
			}catch(InputMismatchException e){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=7);

	}

}
