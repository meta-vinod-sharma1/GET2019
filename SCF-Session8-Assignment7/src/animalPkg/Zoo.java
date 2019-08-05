package animalPkg;

import java.util.Scanner;

public class Zoo{
	static int id = 1;
	public static void main(String args[]){
		Animal aObj = null;
		Scanner in = new Scanner(System.in);
		int choice = 0;
		do{
			choice = in.nextInt();
			switch(choice){
			case 1:
				aObj = new Lion("lion1",3,60.5, id++);
				break;
			case 2:
				aObj = new Tiger("tiger1",3,60.5, id++);
				break;
			case 3:
				aObj = new Parrot("Parrot",2,10.5, id++);
				break;
			case 4:
				System.out.println("Name : " + aObj.name);
				System.out.println("Age : " + aObj.age);
				System.out.println("Animal Type : " + aObj.animalType);
				System.out.println("Animal Category : " + aObj.animalCategory);
				System.out.println("Animal Id : " + aObj.animalId);
				System.out.println("Animal Sound : " + aObj.getSound());
				System.out.println("weight : " + aObj.weight);
				
			}
			
		}while(choice != 7);
		
	}

}
