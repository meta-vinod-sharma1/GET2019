package session3Pkg.priorityQueuePkg;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is main class for Priority Queue operations
 * @author Vinod
 * @date 02/07/2019
 */
public class Main {
	private final static String view = "----------------------------------------------------------------------------------------------------";
	public static void main(String[] args){
		
		Scanner inputObj = new Scanner(System.in);
		PriorityQueue queueObj = null;
		try{
			System.out.println("Please Enter the Size of Priority Queue :");
			int size = inputObj.nextInt();
			if(size < 1){
				System.out.println(view);
				System.out.println("Please Enter at least size 1 !! Try again");
				System.out.println(view);
				main(args);
			}
			queueObj = new ArrayPriorityQueue(size);
		}catch(InputMismatchException e){
			
			System.out.println(view);
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println(view);
			inputObj.nextLine();
			main(args);
		}
		int choice = 0;
		do{
			System.out.println("1.Enter Priority In Queue\n2.Extract Element from Queue\n3.Most Priority Value\n4.Size of Queue\n5.Create new Queue\n6.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("Enter data :");
					System.out.println(view);
					queueObj.enQueue(inputObj.nextInt());
					break;
				case 2:
					System.out.println(view);
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Queue is already Empty");
					}else{
						System.out.println("Your Output : " + queueObj.deQueue() + " successfully removed");
					}
					break;
				case 3:
					System.out.println(view);
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Queue is Empty");
					}else{
						System.out.println("Your Output : " + queueObj.firstElement());
					}
					break;
				case 4:
					
					System.out.println("Your Output : " + queueObj.queueSize());
					break;
				case 5:
					main(args);
					break;
				case 6:
					break;
					default:
						System.out.println("Invalid Choice");
				}
				System.out.println(view);
			}catch(InputMismatchException e){
				System.out.println(view);
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println(view);
				inputObj.nextLine();
			}
		}while(choice!=6);
		
		System.out.println("Program Terminated");
		System.out.println(view);

	}

}
