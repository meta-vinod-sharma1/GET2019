package zonePkg;

import java.util.ArrayList;

import animalPkg.Animal;
import animalPkg.Lion;
import animalPkg.Lizard;
import animalPkg.Parrot;
import animalPkg.Pigeon;
import animalPkg.Snake;
import animalPkg.Tiger;

public class Cage {
	public String animalType;
	public int capacity;
	public static int cageId = 101;
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public Cage(String animalType, int animalLimit){
		this.animalType = animalType;
		this.capacity = animalLimit;
		cageId = cageId++;
	}
	public void addAnimal(String name, int age, double weight , int id){
		Animal animalObj = null;
		if(animalType == "Lion"){
			animalObj = new Lion(name , age , weight , id);
		}else if(animalType == "Tiger"){
			animalObj = new Tiger(name , age , weight , id);
		}else if(animalType == "Lizard"){
			animalObj = new Lizard(name , age , weight , id);
		}else if(animalType == "Snake"){
			animalObj = new Snake(name , age , weight , id);
		}else if(animalType == "Parrot"){
			animalObj = new Parrot(name , age , weight , id);
		}else if(animalType == "Piegon"){
			animalObj = new Pigeon(name , age , weight , id);
		}
		animalList.add(animalObj);		
	}
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}

}
