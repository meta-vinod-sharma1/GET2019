package jobSchedulerPkg;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MainJobScheduler {

	public static void main(String[] args) {
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
		jobSchedulerObj.allTypeTimeOfAllProcess();
		

	}

}
