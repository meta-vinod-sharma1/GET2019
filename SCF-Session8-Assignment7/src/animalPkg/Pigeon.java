package animalPkg;

public class Pigeon extends Bird {
	public Pigeon(String name, int age, double weight, int animalId){
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.animalId = animalId++;
		animalType = "Pigeons";
	}
	
	@Override
	public String getSound(){
		return "Coooo";
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
