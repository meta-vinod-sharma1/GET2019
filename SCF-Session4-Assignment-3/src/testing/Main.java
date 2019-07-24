package testing;
import java.util.*;
/**
 * This is main class it contains menu for all Array Operation 
 * @author Vinod
 *
 */
public class Main {
	
	public static void main(String args[]){
		
		// object for user input 
		Scanner inputObj = new Scanner(System.in);
		System.out.println("Enter Array length :");
		int inputArray[] = null;
		try{
			int sizeOfArray = inputObj.nextInt();
			inputArray = new int[sizeOfArray];
			//collecting integers in array
			for(int i = 0; i<sizeOfArray;){
				try{
					System.out.println("enter intenger[" + (i+1) + "] :");
					inputArray[i] = inputObj.nextInt();
					if(inputArray[i] < 1){
						System.out.println("Please enter only Positive integers");
					}else{
						i++;
					}
				}catch(InputMismatchException e){
					System.out.println("Please enter only Integers !! Try Again ");
					inputObj.next();
				}
			}
		}catch(NegativeArraySizeException e){
			System.out.println("Array Size Can't be Negative   Exception : " + e + "\nTry Again");
			main(args);
		}catch(InputMismatchException e){
			System.out.println("Please Enter only integers !! Try Again");
			main(args);	
		}
		int choice = 0;
		// Menu List in contain do - while loop
		do{
			try{
				System.out.println("Enter Your Choice :");
				System.out.println("1.Largest Mirror Length\n2.Number of clumps\n3.Array after fixXY\n4.Split Array Index");
				System.out.println("5.For Change Array\n6.Exit");
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("\n-------------------------------------------------------------------------------------");
					System.out.println("Largest Mirror Length : " + ArrOperation.lengthOfMirror(inputArray));
					System.out.println("---------------------------------------------------------------------------------------\n");
					break;
				case 2:
					System.out.println("\n-------------------------------------------------------------------------------------");
					System.out.println("Number of clumps : " + ArrOperation.numberOfClumps(inputArray));
					System.out.println("---------------------------------------------------------------------------------------\n");
					break;
				case 3:
					int X,Y;
					System.out.println("Enter value of X:");
					X = inputObj.nextInt();
					System.out.println("Enter value of Y:");
					Y = inputObj.nextInt();
					System.out.println("\n-------------------------------------------------------------------------------------");
					int[] newArray = ArrOperation.fixXY(X, Y, inputArray);
					System.out.print("New Array after FixXy : " );
					for(int i=0; i<newArray.length; i++){
						System.out.print(" " + newArray[i]);
					}
					System.out.println("\n---------------------------------------------------------------------------------------\n");
					break;
				case 4:
					System.out.println("\n-------------------------------------------------------------------------------------");
					System.out.println("Largest Mirror Length : " + ArrOperation.indexOfSplitArray(inputArray));
					System.out.println("---------------------------------------------------------------------------------------\n");
					break;
				case 5:
					main(args);
					break;
				case 6:
					break;
					default :
						System.out.println("Invalid Choice");
				}
			}catch(AssertionError e){
				System.out.println("Assertion Error : " + e);
			}catch(InputMismatchException e){
				System.out.println("Please enter Only Integer Value !! Try Again");
			}
		}while(choice != 6);	
	}
}
