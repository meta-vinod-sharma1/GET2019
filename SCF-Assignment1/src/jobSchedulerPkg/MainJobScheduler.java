package jobSchedulerPkg;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MainJobScheduler {

	public static void main(String[] args) {
		try{
			Scanner inputObject = new Scanner(System.in);
			JobScheduler jobSchedulerObj = new JobScheduler();
			System.out.println("How many Process do You Want ");
			int numberOfProcess = inputObject.nextInt();
			int arrOfTime[][] = new int[numberOfProcess][2];
		
			for(int i=0;i<numberOfProcess;i++){  // Collecting Arrival time & Burst time of processes in Seconds
				System.out.println("Enter Arrival time and Burst time For Process P" + (i+1) + " :");
				for(int j=0;j<2;j++){
					arrOfTime[i][j] = inputObject.nextInt();
				}
			}
			jobSchedulerObj.jobScheduling(arrOfTime);
			int choice;
			do{
				System.out.println("Press any key 1. complition time\n2. Turn Around Time\n3.Waiting Time");
				System.out.println("4.Maximum Waiting Time\n5.Average Waiting Time\n6.All Data Display\n7.Exit");
				choice = inputObject.nextInt();
				switch(choice){
				case 1:
					System.out.println("\tCompletion Time");
					for(int i=0; i<numberOfProcess; i++){
						System.out.println("Process[" + (i+1) + "] : " +jobSchedulerObj.completionTime(i));
					}
					break;
				case 2:
					System.out.println("\tTurn Around Time");
					for(int i=0; i<numberOfProcess; i++){
						System.out.println("Process[" + (i+1) + "] : " +jobSchedulerObj.turnAroundTime(i));
					}
					break;
				case 3:
					System.out.println("\tWaiting Time");
					for(int i=0; i<numberOfProcess; i++){
						System.out.println("Process[" + (i+1) + "] : " +jobSchedulerObj.waitingTime(i));
					}
					break;
				case 4:
					System.out.println("Maximum Waiting Time : " + jobSchedulerObj.maxWaitingTime());
					break;
				case 5:
					System.out.println("Average Waiting Time : " + jobSchedulerObj.averageWaitingTime());
					break;
				case 6:
					System.out.println("Data For All Process");
					jobSchedulerObj.allTypeTimeOfAllProcess();
					break;
				}
			}while(choice!=7);

		}catch(InputMismatchException e){
			System.out.println("Please enter only Integer value !! Try again ");
			main(args);
		}
		
	}
}
