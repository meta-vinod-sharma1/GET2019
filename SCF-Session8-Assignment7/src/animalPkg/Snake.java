package animalPkg;

public class Snake extends Reptile{
	public Snake(String name, int age, double weight, int animalId ){
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.animalId = animalId;
		animalType = "Snake";
	}
	
	@Override
	public String getSound(){
		return "Hissss";
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
