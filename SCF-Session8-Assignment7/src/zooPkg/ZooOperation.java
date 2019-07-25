package zooPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

import zonePkg.Cage;
import zonePkg.Zone;

public class ZooOperation {
	Scanner inputObj = new Scanner(System.in);
	Menu menu = new Menu();
	Zoo zooObj = new Zoo();

	static int id = 1;
	private String animals[][] = {{"Lion", "Mammal"},{"Tiger","Mammal"},{"Lizard","Reptile"},{"Snake","Reptile"},{"Parrot","Bird"},{"Pigeon","Bird"}};

	/**
	 * This method used to add an animal in the zone
	 * @param name name of animal 
	 * @param age age of animal 	
	 * @param weight of animal	
	 * @param category 
	 * @param animalType
	 * @return true if successfully added otherwise false
	 */
	boolean addAnimalOperation(String name, int age, double weight , String category, String animalType){
		//Search for Zone
		boolean flag = false;
		for(int index1=0; index1<zooObj.zoneList.size(); index1++){
			// if Zone category found
			if(zooObj.zoneList.get(index1).zoneCategory.equals(category)){
				Zone zoneObj = zooObj.zoneList.get(index1);
				//Search for Cage
				System.out.println(zoneObj.cageList.size());
				for(int index2=0; index2<zoneObj.cageList.size(); index2++){
					//if cage Type is found
					System.out.println(" here : " + zoneObj.cageList.get(index2).animalType);
					if(zoneObj.cageList.get(index2).animalType.equals(animalType)){
						System.out.println(" here");
						if(zoneObj.cageList.get(index2).addAnimal(name, age, weight, id)==true){
							zooObj.totalAnimal++;
							id++;
							flag = true;
							break;
						}
					}
				}
			}
		}
		return flag;
	}
	
	/**
	 * This method used to remove an animal from the Zoo
	 */
	public void removeAnimalOperation(){
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		if(zooObj.totalAnimal==0){
			System.out.println("Sorry Zoo is empty\n");
		}else{
			System.out.println("Enter Animal id to remove Animal");
			int animalId = inputObj.nextInt();
			for(int index1=0; index1<zooObj.zoneList.size(); index1++){
				for(int index2=0; index2<zooObj.zoneList.get(index1).cageList.size();index2++){
					Cage cageObj = zooObj.zoneList.get(index1).cageList.get(index2);
					for(int index3=0; index3<cageObj.getAnimalList().size(); index3++){
						if(cageObj.getAnimalList().get(index3).getAnimalId() == animalId){
							cageObj.getAnimalList().remove(index3);
							System.out.println("Animal with id " + animalId + " is removed");
							zooObj.totalAnimal--;
							break;
						}else{
							System.out.println("Failed !! Zoo don't have an animal with id " + animalId);
							break;
						}
					}
	
				}
			}
		}
	
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * This method used to display Animals in Zoo
	 */
	void display(){
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		for(int index1=0; index1<zooObj.zoneList.size(); index1++){
			for(int index2=0; index2<zooObj.zoneList.get(index1).cageList.size();index2++){
				Cage cageObj = zooObj.zoneList.get(index1).cageList.get(index2);
				for(int index3=0; index3<cageObj.getAnimalList().size(); index3++){
					System.out.println("\t-----------------");
					System.out.println("\tId :" + cageObj.getAnimalList().get(index3).getAnimalId());
					System.out.println("\tName :" + cageObj.getAnimalList().get(index3).getName());
					System.out.println("\tAge :" + cageObj.getAnimalList().get(index3).getAge());
					System.out.println("\tWeight :" + cageObj.getAnimalList().get(index3).getWeight());
					System.out.println("\tSound :" + cageObj.getAnimalList().get(index3).getSound());
					System.out.println("\t----------------\n");
				}
	
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
		public void start(){
			zooObj.addZone();
		}
	/**
	 * This method used to add a cage in zone
	 * @param category category of animal 
	 * @param animalType Animal Type 
	 * @param animalLimit How many animal can fit in a cage
	 * @return true if cage successfully added in zone otherwise false
	 */
	public boolean addCageOperation(String category, String animalType , int animalLimit){
		boolean flag = false;
		for(int i=0; i<zooObj.zoneList.size(); i++){
			if(zooObj.zoneList.get(i).zoneCategory.equals(category)){
				if(zooObj.zoneList.get(i).addCage(animalType, animalLimit)){
					flag = true;
					break;
				}
			}
		}
			
		return flag;
	}
	/**
	 * This method used to compute total animal in zoo
	 * @return
	 */
	public int totalAnimal() {
		return zooObj.totalAnimal;
	}

}
