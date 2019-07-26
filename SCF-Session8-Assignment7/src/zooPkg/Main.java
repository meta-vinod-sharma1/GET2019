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
		Zoo zooObj = operationObj.zooObj;
		Zone zoneObj = null;
		Cage cageObj = null;
		String animals[][] = {{"Lion", "Mammal"},{"Tiger","Mammal"},{"Lizard","Reptile"},{"Snake","Reptile"},{"Parrot","Bird"},{"Pigeon","Bird"}};
		String categoryArr[] = {"Mammal" ,"Reptile" , "Bird"};
		int choice = 0;
		do{
			try{
				menu.mainMenu();
				choice = inputObj.nextInt();
				int choiceAnimal = 0;
				switch(choice){
				case 1:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					if(zooObj.totalZone == 0){
						System.out.println("Sorry !! Zoo don't have Zone please add zone first from Main menu by press 5");
					}else{
						System.out.println("Please Choose Animal Type to add");
						menu.animalMenu();
						choiceAnimal = inputObj.nextInt();
						if(0<choiceAnimal && choiceAnimal< 7){
							String animalType = animals[choiceAnimal-1][0];
							String category = animals[choiceAnimal-1][1];
							zoneObj = operationObj.isZone(category);
							if(zoneObj !=null){
								cageObj = operationObj.isCage(zoneObj, animalType);
								if(cageObj != null){
									System.out.println("\tEnter Animal name");
									String name = inputObj.next();
									System.out.println("\tEnter Age of animal");
									int age = inputObj.nextInt();
									System.out.println("\tEnter weight of animal");
									double weight = inputObj.nextDouble();
									if(operationObj.addAnimalOperation(name, age, weight , category , animalType)==true){
										System.out.println("Successful !! Animal "+ name +" is successfully added " + " with id "+ (ZooOperation.id -1));
									}else{
										System.out.println("Failed !! Cage don't have Space for animal type " + animalType);
									}
								}else{
									System.out.println("Failed !! Cage not found for this Animal !! Please Add cage in this Zone by Main menu");
								}
							}else{
								System.out.println("Failed !! Zoo don't have Zone of category " + category);
							}
							
							
						}else{
							System.out.println("Invalid Choice");
						}
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					break;
				case 2:
					operationObj.removeAnimalOperation();
					break;
				case 3:
					if(zooObj.totalAnimal == 0){
						System.out.println("----------------------------------\n Sorry !! Zoo don't have animlas to display\n---------------------------------------------");
						break;
					}
					operationObj.display();
					break;
				case 4:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					if(zooObj.totalZone == 0){
						System.out.println("Zoo don't have zone please add Zone first");
					}else{
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
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					break;
				case 6:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					System.out.println("Total Animal : " + operationObj.totalAnimal());
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					break;
				case 5:
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					menu.zoneCategory();
					choiceAnimal = inputObj.nextInt();
					if(1 > choiceAnimal || choiceAnimal > 3){
						System.out.println("Invalid choice");
					}else{
						String category = categoryArr[choiceAnimal - 1];
						System.out.println("Enter Cage Limit in Zone");
						int limit = inputObj.nextInt();
						if(operationObj.addZoneOperation(category, limit, true, true) == true){
							System.out.println("Successful !! Zone with category " + category + " added with Cage Limit " + limit);
						}
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------");
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
