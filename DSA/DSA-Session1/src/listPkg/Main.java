package listPkg;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is Main class which have Main menu for Rotating sub list, add elements in list , total elements in list , change list and display list etc
 * @author Vinod
 * @date 30/07/2019
 */
public class Main {
	public static void main(String[] args){
		Scanner inputObj = new Scanner(System.in);
		List listObj = new List();
		int choice = 0;
		do{
			System.out.println("Please Enter Your Choice\n1.Add Element in List\n2.Change List\n3.Rotate Sub List In List\n4.Display List\n5.Total Elements in List\n6.Exit");
			try{
				choice = inputObj.nextInt();
				System.out.println("--------------------------------------------------------");
				switch(choice){
				case 1:
					// this case will add elements in the list
					System.out.println("Enter How many Elements You want in List :");
					int noOfElement = inputObj.nextInt();
					for(int i = 0; i< noOfElement; ){
						try{
							System.out.println("Data[" + (i+1) + "] : ");
							int data = inputObj.nextInt();
							listObj.addElement(data);
							i++;
						}catch(InputMismatchException e){
							System.out.println("--------------------------------------------------------");
							System.out.println("Warning : Please enter only integer value !! Try Again");
							System.out.println("--------------------------------------------------------");
							inputObj.nextLine();
						}
					}
					break;
				case 2:	
					// this case will make new list 
					if(listObj.head == null){
						System.out.println("List is Already Empty");
					}else{
						listObj.head = null;
						System.out.println("Enter How many Elements You want in New List :");
						noOfElement = inputObj.nextInt();
						for(int i = 0; i< noOfElement; ){
							try{
								System.out.println("Data[" + (i+1) + "] : ");
								int data = inputObj.nextInt();
								listObj.addElement(data);
								i++;
							}catch(InputMismatchException e){
								System.out.println("--------------------------------------------------------");
								System.out.println("Warning : Please enter only integer value !! Try Again");
								System.out.println("--------------------------------------------------------");
								inputObj.nextLine();
							}
						}
					}
					break;
				case 3:
					// this case will rotate a sublist of list 
					if(listObj.head == null){
						System.out.println("Opps !! List is Empty can't operate");
						break;
					}
					System.out.println("Enter left Position :");
					int leftPosition = inputObj.nextInt();
					System.out.println("Enter Right Position : ");
					int rightPosition = inputObj.nextInt();
					System.out.println("Enter Rounds to rotate : ");
					int rotateRound = inputObj.nextInt();
					SubListOperation subListObj = new SubListOperation();
					subListObj.rotateSubList(leftPosition, rightPosition, rotateRound, listObj);
					break;
				case 4:
					// this case will print list
					System.out.print("Your output : ");
					listObj.DisplayList();
					break;
				case 5: 
					// this case will print total elements in the list
					System.out.println("Total Elements in List : " + listObj.noOfElementInList());
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
				System.out.println("-----------------------------------------------------------------------");
			}catch(AssertionError e){
				System.out.println("--------------------------------------------------------");
				System.out.println("Assertion Error : " + e);
				System.out.println("--------------------------------------------------------");
			}catch(InputMismatchException e){
			
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=6);

	}

}
