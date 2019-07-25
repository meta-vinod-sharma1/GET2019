package zooPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

import zonePkg.Cage;
import zonePkg.Zone;

public class ZooOperation {
	Scanner inputObj = new Scanner(System.in);
	Menu menu = new Menu();
	Zoo zooObj = new Zoo();
	
	private static int id = 1;
	private String animals[][] = {{"Lion", "Mammal"},{"Tiger","Mammal"},{"Lizard","Reptile"},{"Snake","Reptile"},{"Parrot","Bird"},{"Pigeon","Bird"}};
	
	
	void addAnimalOperation(){
		try{
			menu.animalMenu();
			int choiceAnimal = inputObj.nextInt();
			if(0<choiceAnimal && choiceAnimal< 7){
				String animalType = animals[choiceAnimal-1][0];
				String category = animals[choiceAnimal-1][1];
				//Search for Zone
				for(int i=0; i<zooObj.zoneList.size(); i++){
					// if Zone category found
					if(zooObj.zoneList.get(i).zoneCategory.equals(category)){
						Zone zoneObj = zooObj.zoneList.get(i);
						//Search for Cage in found zone
						for(int j=0; j<zoneObj.cageList.size(); j++){
							if(zoneObj.cageList.get(j).animalType.equals(animalType)){
								Cage cageObj = zoneObj.cageList.get(j);
								try{
									if(cageObj.getAnimalList().size()<cageObj.capacity){
										System.out.println("Enter Animal name");
										String name = inputObj.next();
										System.out.println("Enter Age of animal");
										int age = inputObj.nextInt();
										System.out.println("Enter weight of animal");
										double weight = inputObj.nextDouble();
										zoneObj.cageList.get(j).addAnimal(name, age, weight, id++);
										zooObj.totalAnimal++;
										System.out.println("---------------------------------------------------------------------------------------------------------------");
										System.out.println("Animal " + name + " is succesfully added " + "with id " + (id-1));
										System.out.println("---------------------------------------------------------------------------------------------------------------");
									}else{
										System.out.println("---------------------------------------------------------------------------------------------------------------");
										System.out.println("Oppss !! Cage don't have space for animal\n Creating new cage....................");
										//For creating new cage
										if(zoneObj.cageList.size() < zoneObj.cageLimit){
											System.out.println("Please enter animal Limit for new Cage : ");
											int capacity = inputObj.nextInt();
											zoneObj.addCage(animalType, capacity);
											System.out.println("Cage is succesfully added and It's capacity is : " + capacity);
										}else{
											System.out.println("Failed !! Zone don't have space for new Cage");
										}
										System.out.println("---------------------------------------------------------------------------------------------------------------");
									}
								}catch(InputMismatchException e){
									System.out.println("--------------------------------------------------------");
									System.out.println("Warning : Please enter only integer value !! Try Again");
									System.out.println("--------------------------------------------------------");
									inputObj.nextLine();
									j--;
								}
							}
						}
					}
				}
			}else{
				System.out.println("Invalid Choice !! Try Again");
				addAnimalOperation();
			}	
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			addAnimalOperation();
		}
	}
	public void removeAnimalOperation(){
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		if(zooObj.totalAnimal==0){
			System.out.println("Sorry Zoo is empty\n");
		}else{
			System.out.println("Enter Animal id to remove Animal");
			int animalId = inputObj.nextInt();
			for(int i=0; i<zooObj.zoneList.size(); i++){
				for(int j=0; j<zooObj.zoneList.get(i).cageList.size();j++){
					Cage cageObj = zooObj.zoneList.get(i).cageList.get(j);
					for(int k=0; k<cageObj.getAnimalList().size(); k++){
						if(cageObj.getAnimalList().get(k).getAnimalId() == animalId){
							cageObj.getAnimalList().remove(k);
							System.out.println("Animal with id " + animalId + " is removed");
							zooObj.totalAnimal--;
						}else{
							System.out.println("Failed !! Zoo don't have an animal with id " + animalId);
						}
					}
					
				}
			}
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	void display(){
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<zooObj.zoneList.size(); i++){
			for(int j=0; j<zooObj.zoneList.get(i).cageList.size();j++){
				Cage cageObj = zooObj.zoneList.get(i).cageList.get(j);
				for(int k=0; k<cageObj.getAnimalList().size(); k++){
					System.out.println("\t-----------------");
					System.out.println("\tId :" + cageObj.getAnimalList().get(k).getAnimalId());
					System.out.println("\tName :" + cageObj.getAnimalList().get(k).getName());
					System.out.println("\tAge :" + cageObj.getAnimalList().get(k).getAge());
					System.out.println("\tWeight :" + cageObj.getAnimalList().get(k).getWeight());
					System.out.println("\tSound :" + cageObj.getAnimalList().get(k).getSound());
					System.out.println("\t----------------\n");
				}
				
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	public void start(){
		zooObj.addZone();
	}

}
