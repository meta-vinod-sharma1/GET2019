package jobSchedulerPkg;
import java.util.Scanner;
import java.util.*;
public class JobScheduler {
	
	ArrayList<Process> processList = new ArrayList<Process>();
	void jobScheduling(int[][] arrOfTime){		
		int startTime=0;
		int endTime=0;
		int processTimeTrack =0;
		for(int i =0; i<arrOfTime.length;i++){
			Process process = new Process();
			process.arrivalTime = arrOfTime[i][0];
			if(process.arrivalTime <= processTimeTrack){
				process.startTime = processTimeTrack;
			}else{
				process.startTime = process.arrivalTime;
			}
			process.endTime = process.startTime + arrOfTime[i][1];
			processTimeTrack = process.endTime;
			processList.add(process);
		}
		
	}
	
	void allTypeTimeOfAllProcess(){
		System.out.println("\t\t\tCompletionTime\t\tTurn Around Time \t Waiting Time\n");
		int averageWaitingTime = 0;
		int maxWaitingTime =0;
		for(int i=0;i<processList.size();i++){
			System.out.print("Process : " + (i+1));
			int completionTime = processList.get(i).endTime;
			int turnAroundTime = completionTime - processList.get(i).arrivalTime;
			int waitingTime = processList.get(i).startTime -processList.get(i).arrivalTime;
			averageWaitingTime += waitingTime; 
			if(maxWaitingTime < waitingTime) maxWaitingTime = waitingTime;
			System.out.println( "\t\t     " + completionTime + "\t\t\t\t" + turnAroundTime + "\t\t\t" + waitingTime);
		}
		System.out.println("\n\n\t\t\t Average Waiting Time : " + averageWaitingTime/processList.size() + "\n\t\t\tMaximum Waiting Time Period : " + maxWaitingTime);
	}
}
	
