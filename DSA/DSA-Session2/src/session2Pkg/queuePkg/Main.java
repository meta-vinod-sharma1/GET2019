package session2Pkg.queuePkg;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is main class for Queue operations
 * @author Vinod
 * @date 31/07/2019
 */
public class Main {
	public static void main(String[] args){
		Queue queueObj = new ArrayQueue(5);
		Scanner inputObj = new Scanner(System.in);
		
		int choice = 0;
		do{
			System.out.println("1.Enqueue\n2.Deque\n3.is Queue full ?\n4. is Queue Empty\n5.Front Element\n6.Rear Element\n7.Display Queue\n8.Size of Queue\n9.Exit");
			try{
				choice = inputObj.nextInt();
				System.out.println("-------------------------------------------------------------------------------");
				switch(choice){
				case 1:
					System.out.println("Enter data :");
					queueObj.enQueue(inputObj.nextInt());
					break;
				case 2:
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Queue is already Empty");
					}else{
						System.out.println("Your Output : Data " + queueObj.deQueue() + " successfully removed");
					}
					break;
				case 3:
					if(queueObj.isFull()){
						System.out.println("Your Output : Yes !! Queue is Full");
					}else{
						System.out.println("Your Output : No !! Queue is not Full");
					}
					break;
				case 4:
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Yes !! Queue is Empty");
					}else{
						System.out.println("Your Output : No !! Queue is not Empty");
					}
					break;
				case 5:
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Sorry !! Queue is Empty");
					}else{
						System.out.println("Your Output :  " + queueObj.frontElement());
					}
					break;
				case 6:
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Sorry !! Queue is Empty");
					}else{
						System.out.println("Your Output :   " + queueObj.rearElement() );
					}
					break;
				case 7:
					System.out.print("Your Output : ");
					queueObj.displayQueue();
					break;
				case 8:
					System.out.println("Your Output : " + queueObj.queueSize());
					break;
				case 9:
					break;
					default:
						System.out.println("Invalid Choice");
				}
				System.out.println("-------------------------------------------------------------------------------");
			}catch(InputMismatchException e){
				
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("-------------------------------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=9);

	}

}
