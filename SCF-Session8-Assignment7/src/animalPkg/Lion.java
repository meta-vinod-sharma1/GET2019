package animalPkg;

public class Lion extends Mammal {

	public Lion(String name, int age, double weight, int animalId ){
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.animalId = animalId;
		animalType = "Lion";
	}
	
	@Override
	public String getSound(){
		return "Roars";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public int getAnimalId() {
		return animalId;
		
	}
}
