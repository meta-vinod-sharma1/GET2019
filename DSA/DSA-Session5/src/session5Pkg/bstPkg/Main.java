package session5Pkg.bstPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

import session5Pkg.employeePkg.Employee;

/**
 * This is main class used to Operations on Dictionary
 * @author Vinod
 * @date 08/06/2019
 */
public class Main {
	public final static String view = "-----------------------------------------------------------";
	public static void main(String args[]){
		final String filePath = "pairs.json";
		BST treeObj = new BST(filePath);
		
		Scanner inputObj = new Scanner(System.in);
		
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Add Key-Value in Dictionary\n2.Delete a Key\n3.Get value of a Key\n4.Sorted List of key-value Pairs\n"
						+ "5.Sorted in Range key1 to key2\n6.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("Enter Key");
					int key = inputObj.nextInt();
					System.out.println("Enter value");
					inputObj.nextLine();
					treeObj.add(new Node(key,inputObj.nextLine()), treeObj.root);
					break;
				case 2:
					System.out.println("Enter key");
					key = inputObj.nextInt();
					treeObj.delete(key, treeObj.root);
					
					break;
				case 3:
					System.out.println("Enter Key");
					String value = treeObj.getValue(inputObj.nextInt(), treeObj.root);
					System.out.println(view);
					if( value != null){
						System.out.println("Your Output :  " + value);
					}else{
						System.out.println("Key not found");
					}
					break;
				case 4:
					treeObj.sortedList.clear();
					treeObj.sortedList(treeObj.root);
					System.out.println(view);
					if(treeObj.sortedList.size()!= 0){
						System.out.println("  Key  ->  Value");
						for(int index = 0; index<treeObj.sortedList.size(); index++){
							System.out.format("%5d%6s%s", treeObj.sortedList.get(index).getKey(),"  ->  ",treeObj.sortedList.get(index).getValue());
							System.out.println();
						}
					}else{
						System.out.println("List don't have key-value pairs");
					}
				
					break;
				case 5:
					System.out.println("Enter lower Key :" );
					int key1 = inputObj.nextInt();
					System.out.println("Enter Upper Key");
					int key2 = inputObj.nextInt();
					treeObj.sortedListInRange.clear();
					treeObj.sortedListRange(treeObj.root, key1, key2);
					System.out.println(view);
					if(treeObj.sortedListInRange.size()!=0){
						System.out.println("  Key  ->  Value");
						for(int index = 0; index<treeObj.sortedListInRange.size(); index++){
							System.out.format("%5d%6s%s", treeObj.sortedListInRange.get(index).getKey(),"  ->  ",treeObj.sortedListInRange.get(index).getValue());
							System.out.println();
						}
					}else{
						System.out.println("List In this Range is not available");
					}
					break;
				case 6:
					break;
					default :
						System.out.println(view + "\nInvalid Choice");
				}
				System.out.println(view);
			}catch(InputMismatchException exception){
				System.out.println(view + "\nWarning : Please Enter only Integer Value !! Try Again\n" + view);
				inputObj.nextLine();
			}
		}while(choice!=6);
	
	}
	
	
}
