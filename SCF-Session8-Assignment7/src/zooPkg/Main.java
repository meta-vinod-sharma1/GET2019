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
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					System.out.println("Please Choose Animal Type to add");
					menu.animalMenu();
					int choiceAnimal = inputObj.nextInt();
					if(0<choiceAnimal && choiceAnimal< 7){
						String animalType = animals[choiceAnimal-1][0];
						String category = animals[choiceAnimal-1][1];
						System.out.println("\tEnter Animal name");
						String name = inputObj.next();
						System.out.println("\tEnter Age of animal");
						int age = inputObj.nextInt();
						System.out.println("\tEnter weight of animal");
						double weight = inputObj.nextDouble();
						if(operationObj.addAnimalOperation(name, age, weight , category , animalType)==true){
							System.out.println("Successful !! Animal "+ name +" is successfully added " + " with id "+ (ZooOperation.id -1));
						}else{
							System.out.println("Failed !! Cage not found for this Animal !! Please Add cage in this Zone by Main menu");
						}
					}else{
						System.out.println("Invalid Choice");
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					break;
				case 2:
					operationObj.removeAnimalOperation();
					break;
				case 3:
					operationObj.display();
					break;
				case 4:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					System.out.println("Choose Cage Type :");
					menu.animalMenu();
					choiceAnimal = inputObj.nextInt();
					if(0<choiceAnimal && choiceAnimal< 7){
						String animalType = animals[choiceAnimal-1][0];
						String category = animals[choiceAnimal-1][1];
						System.out.println("Enter Animal capacity for cage : ");
						int animalLimit = inputObj.nextInt();
						if(operationObj.addCageOperation(category, animalType , animalLimit) == true){
							System.out.println("Successful !! Your Cage is Succesfully Added");
						}else{
							System.out.println("Failed !! Zone with category " + animals[choiceAnimal-1][1] + " don't have space for cage");
						}
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					break;
				case 5:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					System.out.println("Total Animal : " + operationObj.totalAnimal());
					System.out.println("---------------------------------------------------------------------------------------------------------------");
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
		}while(choice!=6);
	}

}
