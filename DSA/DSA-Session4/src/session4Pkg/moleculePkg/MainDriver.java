package session4Pkg.moleculePkg;

import java.util.*;

import session4Pkg.uniquePkg.UniqueCharacters;

/**
 * This is the class containing main method
 * @author Vinod 
 * @date 08/03/2019
 */
public class MainDriver {

	public static void main(String[] args) {
		String view = "--------------------------------------------------------------------";

		Scanner inputObj = new Scanner(System.in);
		MolecularMass mass = new MolecularMass();
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Calculate Moleculer Mass\n2.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					inputObj.nextLine();
					System.out.println("Enter Compound");
					System.out.println(view+"\nYour Output : " + mass.calculateMass(inputObj.nextLine()));
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
