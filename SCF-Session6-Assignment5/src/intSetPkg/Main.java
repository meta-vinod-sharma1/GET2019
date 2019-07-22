package intSetPkg;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class used to operate IntSet class and it's methods it contains Menu class also
 * @author Vinod
 * @date 21/07/2019
 */
public class Main {
	public static void main(String[] args){
		IntSet intSetMainObj = null;
		Menu menuObj = new Menu();
		InputSet inputSetObj = new InputSet();
		Scanner inputObj = new Scanner(System.in);
		// setting the main Object of IntSet class
		intSetMainObj = inputSetObj.setIntSetArray();
		int choice = 0;
		do{
			try{
				menuObj.intSetMenu();
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("Enter number");
					int searchNumber = inputObj.nextInt();
					if(intSetMainObj.isMember(searchNumber)==true){
						System.out.println("--------------------------------------------------------");
						System.out.println("Your Output : Number is in the Set");
						System.out.println("--------------------------------------------------------");
					}else{
						System.out.println("--------------------------------------------------------");
						System.out.println("Your Output : Number is not in the set");
						System.out.println("--------------------------------------------------------");
					}
					break;
				case 2:
					System.out.println("--------------------------------------------------------");
					System.out.println("Size of IntSet : " + intSetMainObj.size());
					System.out.println("--------------------------------------------------------");
					break;
				case 3:
					System.out.println("Please Enter sub Set Data.....");
					IntSet subSetObj = inputSetObj.setIntSetArray();
					System.out.println("--------------------------------------------------------");
					if(intSetMainObj.isSubSet(subSetObj)){
						System.out.println("Your Output : True !! This is Sub Set of Int Set");
					}else{
						System.out.println("Your Output : False !! This is not the Sub Set of Int Set");
					}
					System.out.println("--------------------------------------------------------");
					break;
				case 4:
					int complementArray[] = intSetMainObj.getComplement();
					System.out.print("\n--------------------------------------------------------\n{ ");
					for(int index=0; index<complementArray.length; index++){
						System.out.print(complementArray[index] +" ");
						if(index%10 == 0){
							System.out.println();
						}
					}
					System.out.println(" }\n--------------------------------------------------------");
					break;
				case 5:
					int unionSetArray[] = intSetMainObj.union(inputSetObj.setIntSetArray(), inputSetObj.setIntSetArray());
					System.out.print("--------------------------------------------------------\n { ");
					for(int index=0; index<unionSetArray.length; index++){
						System.out.print(unionSetArray[index] + " ");
					}
					System.out.println(" }\n--------------------------------------------------------");
					break;
				case 6:
					main(args);
					break;
				case 7 :
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
			}catch(InputMismatchException e){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=6);

	}

}
