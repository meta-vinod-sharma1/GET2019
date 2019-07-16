package stringOperationPkg;
import java.util.*;

public class StringOperationMain {

	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);
		int choice;
		try{
			do{
				
				
				System.out.println("Choose the Operation");
				System.out.println("1-> Compare Strings");
				System.out.println("2-> Reverse String");
				System.out.println("3-> Replace Upper to Lower or Lower to Upper");
				System.out.println("4-> Largest Word?");
				System.out.println("5-> Exit");
				choice = scannerObj.nextInt();
				scannerObj.nextLine();
				String str ="";
				switch(choice){
				case 1:
					System.out.println("Please enter First String :");
					String str1 = scannerObj.nextLine();
					System.out.println("Please enter Second String :");
					String str2 = scannerObj.nextLine();
					if(StringOperation.compareStrings(str1, str2) == true){
						System.out.println("\nResult :  Strings are Equal\n");
					}else{
						System.out.println("\nResult  : String are not Equal\n");
					}
					break;
				case 2:
					System.out.println("Please enter String ");
					str = scannerObj.nextLine();
					System.out.println("\nReverse String : " + StringOperation.reverseString(str));
					break;
				case 3:
					System.out.println("Please enter Sting ");
					str = scannerObj.nextLine();
					System.out.println("\nResult : " + StringOperation.replaceWord(str));
					break;
				case 4:
					System.out.println("Please enter String ");
					str = scannerObj.nextLine();
					System.out.println("\nResult : " + StringOperation.findLargestWord(str));
					break;
				default :
					System.out.println("Invalid Choice");
					
				}
				
			}while(choice!= 5);
		}catch(InputMismatchException e){
			System.out.println("Please enter only Integer value for choice !! try again");
			main(args);
		}
		

	}

}
