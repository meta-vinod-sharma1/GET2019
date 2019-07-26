package zooPkg;
/**
 * 
 * @author Vinod
 * @date 24/07/2019
 */
public class Menu {
	public void mainMenu(){
		System.out.println("Enter Your Choice");
		System.out.println("1.Add Animal");
		System.out.println("2.Remove Animal");
		System.out.println("3.List of Animal");
		System.out.println("4.Add Cage");
		System.out.println("5.Add Zone");
		System.out.println("6.Total Animal in Zone");
		System.out.println("7.Exit");
	}
	public void animalMenu(){
		System.out.println("1.Lion\n2.Tiger\n3.Lizard\n4.Snake\n5.Parrot\n6.Piegon");
	}
	public void zoneCategory() {
		System.out.println("Choose Zone Category to Add");
		System.out.println("1.Mammal");
		System.out.println("2.Reptile");
		System.out.println("3.Bird");
	}

}
