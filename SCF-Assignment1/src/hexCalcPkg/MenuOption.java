package hexCalcPkg;
import java.util.*;

public class MenuOption {
	void arithmaticOperation(){
		HexCalc hexCalcObject = new HexCalc();
		Scanner userInputObject = new Scanner(System.in);
		String firstNumber,secondNumber;
		System.out.println("Please Enter First Number");
		firstNumber = userInputObject.nextLine();
		System.out.println("Please Enter Second Number");
		secondNumber = userInputObject.nextLine();
		int choice;
		
		
		do{
			try{
				choice = arithmaticMenu();
			}catch(InputMismatchException e){
				System.out.println("Please enter only integer for Options");
				choice = arithmaticMenu();
			}
			
			switch(choice){
			case 1:
				System.out.println("Your result of Addition is : " + hexCalcObject.addNumbers(firstNumber,secondNumber) + "\n");
				break;
			case 2:
				System.out.println("Your result of Substraction is : " + hexCalcObject.subNumbers(firstNumber,secondNumber));
				break;
			case 3:
				System.out.println("Your Result of Multiplication is : " + hexCalcObject.mulNumbers(firstNumber,secondNumber));
				break;
			case 4:
				System.out.println("Your result of Dividation is : " + hexCalcObject.divNumbers(firstNumber,secondNumber));
				break;
			case 5:
				if(hexCalcObject.isEqual(firstNumber,secondNumber)==true){
					System.out.println("Yes !! Both numbers are equal");
				}else{
					System.out.println("No !! Both numbers are not same");
				}
				break;
			case 6:
				if(hexCalcObject.isGreater(firstNumber,secondNumber)==true){
					System.out.println("Yes !! First Number is greater than Second Number");
				}else{
					System.out.println("No !! First Number is not greater than Second Number");
				}
				break;
			case 7:
				if(hexCalcObject.isLess(firstNumber,secondNumber)==true){
					System.out.println("Yes !! First Number is Less than Second Number");
				}else{
					System.out.println("No !! First Number is not Less than Second Number");
				}
				break;
			case 8:
				System.out.println(" You are in the Main Menu");
				break;
			
			default :
				System.out.println("!!! Invalid Choice");
			}
				
		}while(choice!=8);

	}
	void hexToDecimalRepresantation(){
		Scanner userInputObject = new Scanner(System.in);
		ConvertNumber convertNumberObject = new ConvertNumber();
		System.out.println("Please Enter Hexadecimal Number : ");
		String number = userInputObject.nextLine();
		System.out.println("Hexadecimal Number : " + number + " Decimal Number :" + convertNumberObject.hexToDecimal(number));
	}
	
	void decimalToHexRepresantation(){
		Scanner userInputObject = new Scanner(System.in);
		ConvertNumber convertNumberObject = new ConvertNumber();
		System.out.println("Please Enter Decimal Number : ");
		int numberInt;
		numberInt = userInputObject.nextInt();
		System.out.println("Decimal Number : " + numberInt + " Hexadecimal Number :" + convertNumberObject.decimalToHex(numberInt));
	}
	
	int arithmaticMenu(){
		Scanner userInputObject = new Scanner(System.in);
		System.out.println("Press Key");
		System.out.println("1-> ADD");
		System.out.println("2-> SUB");
		System.out.println("3-> MUL");
		System.out.println("4-> DIV");
		System.out.println("5-> Is FirstNumber is equal to second Number?");
		System.out.println("6-> Is FirstNumber is Greater than the second Number?");
		System.out.println("7-> Is FirstNumber is Less than the second Number?");
		System.out.println("8->Exit");	
		int choice;
		choice = userInputObject.nextInt();
		return choice;
		
	}

}
