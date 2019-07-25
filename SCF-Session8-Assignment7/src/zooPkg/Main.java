package zooPkg;
import java.util.InputMismatchException;
import java.util.Scanner;

import zonePkg.Cage;
import zonePkg.Zone;

/**
 * 
 * @author Vinod
 * @date 21/07/2019
 */
public class Main {
	public static void main(String[] args){
		Scanner inputObj = new Scanner(System.in);
		Menu menu = new Menu();
		ZooOperation operationObj = new ZooOperation();
		operationObj.start();
		String animals[][] = {{"Lion", "Mammal"},{"Tiger","Mammal"},{"Lizard","Reptile"},{"Snake","Reptile"},{"Parrot","Bird"},{"Pigeon","Bird"}};
		int choice = 0;
		do{
			try{
				menu.mainMenu();
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					operationObj.addAnimalOperation();
					break;
				case 2:
					operationObj.removeAnimalOperation();
					break;
				case 3:
					operationObj.display();
					break;
				case 4:
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
		}while(choice!=4);

	}

}
