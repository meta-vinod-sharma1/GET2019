package animalPkg;

public abstract class Animal {
	String name;
	int age;
	double weight;
	int animalId = 1;
	String animalType;
	String animalCategory;
	
	
	abstract public String getSound();
	abstract public String getName();
	abstract public int getAge();
	abstract public double getWeight();
	abstract public int getAnimalId();
}
