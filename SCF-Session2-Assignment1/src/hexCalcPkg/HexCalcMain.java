package hexCalcPkg;

import java.util.Scanner;

public class HexCalcMain {

	public static void main(String[] args) {
		Scanner userInputObject = new Scanner(System.in);
		MenuOption menu = new MenuOption();
		int choice;
		do{
			System.out.println("Press the key");
			System.out.println("1->Arithmatic Operation");
			System.out.println("2->Hexadecimal to Decimal Represantaion");
			System.out.println("3->Decimal to Hexadecimal Represantaion");
			System.out.println("4->Exit");
			choice = userInputObject.nextInt();
			switch(choice){
			case 1:
				menu.arthmaticMenu();
				break;
			case 2:
				menu.hexToDecimalRepresantation();
				break;
			case 3:
				menu.decimalToHexRepresantation();
				break;
			case 4:
				break;
			default :
				System.out.println("!! Invalid Choice");		
			}
		}while(choice!=4);

	}

}
