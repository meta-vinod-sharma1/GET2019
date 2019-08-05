package detectLoopPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

import listPkg.List;
import listPkg.Node;

/**
 * This is Main Class which give you options like  add a list , connect last node with the given position node or Detect loop in the list
 * @author Vinod
 *
 */
public class Main {
	public static void main(String[] args){
		Scanner inputObj= new Scanner(System.in);
		List linkedList = new List();
		int choice =0;
		int noOfElementInList = 0;
		do{
			try{
				System.out.println("Enter Your Choice\n1.InsertList\n2.connect last index with other index\n3.Check for DetectLoop\n4.Exit");
				choice = inputObj.nextInt();
				System.out.println("-----------------------------------------------------------------------------");
				switch(choice){
					case 1:
						// This case will create list
						System.out.println("Enter How many Elements You want in List :");
						int noOfElement = inputObj.nextInt();
						for(int i = 0; i< noOfElement; ){
							try{
								System.out.println("Data[" + (i+1) + "] : ");
								int data = inputObj.nextInt();
								linkedList.addElement(data);
								i++;
							}catch(InputMismatchException e){
								System.out.println("--------------------------------------------------------");
								System.out.println("Warning : Please enter only integer value !! Try Again");
								System.out.println("--------------------------------------------------------");
								inputObj.nextLine();
							}
						}
						noOfElementInList = linkedList.noOfElementInList();
						
						break;
					case 2 :
						// this case will connect last node to given position
						if(noOfElementInList == 0){
							System.out.println("Sorry !! List is Empty");
						}else if(noOfElementInList < 2){
							System.out.println("List don't have sufficient Node to connect !! list should have at least 2 node");
						}else{
							System.out.println("Enter Position :");
							int position = inputObj.nextInt();
							if(position < noOfElementInList ){
								int count = 1;
								Node tempHead = linkedList.head;
								Node positionNode = null, lastNode = null;
								while(tempHead!= null){
									if(position == count){
										positionNode = tempHead;
									}
									lastNode = tempHead;
									tempHead = tempHead.next;
									count++;
								}
								lastNode.next = positionNode;
							}else{
								System.out.println("Invalid Choice !! Position should be less than list size");
							}
							
						}
						break;
					case 3:
						//This case will check that list have loop or not
						if(noOfElementInList == 0){
							System.out.println("Sorry !! List is Empty");
						}else{
							if(DetectLoop.foundLoop(linkedList.head) == true){
								System.out.println("Yes !! List have loop");
							}else{
								System.out.println("No  !! list don't have loop");
							}
						}
						break;
					case 4:
						break;
						default :
							System.out.println("Invalid Choice");
				}
				System.out.println("------------------------------------------------------------------------------------");
			}catch(InputMismatchException e){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
			
		}while(choice != 4);
	}
}
