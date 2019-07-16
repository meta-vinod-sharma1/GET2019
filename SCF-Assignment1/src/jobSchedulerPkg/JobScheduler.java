package jobSchedulerPkg;
import java.util.Scanner;
import java.util.*;
public class JobScheduler {
	
	ArrayList<Process> processList = new ArrayList<Process>(); //processList store all process data
	/**
	 * Method Schedule all the process as first come first serve and store the data in processList
	 * @param arrOfTime this array contains arrival time and burst time of all process
	 */
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
	/**
	 * 
	 * @param processNumber processor number 
	 * @return completion time for that processor
	 */
	public int completionTime(int processNumber){
			return processList.get(processNumber).endTime;	
	}
	
	/**
	 * 
	 * @param processNumber processor number
	 * @return turn Around time for that processor
	 */
	public int turnAroundTime(int processNumber){
		return processList.get(processNumber).endTime - processList.get(processNumber).arrivalTime;
	}
	
	/**
	 * 
	 * @param processNumber processor number
	 * @return waiting Time for that processor 
	 */
	public int waitingTime(int processNumber){
		return processList.get(processNumber).startTime - processList.get(processNumber).arrivalTime;
	}
	
	/**
	 * 
	 * @return maximum waiting time 
	 */
	public int maxWaitingTime(){
		int maxWaitingTime = 0;
		for(int i=0; i<processList.size(); i++){
			if(maxWaitingTime <= waitingTime(i)){
				maxWaitingTime = waitingTime(i);
			}
		}
		
		return maxWaitingTime ;
	}
	
	/**
	 * 
	 * @return average waiting time
	 */
	public int averageWaitingTime(){
		int avgWaitingTime = 0;
		for(int i=0; i<processList.size(); i++){
			avgWaitingTime += waitingTime(i);
		}
		
		return avgWaitingTime;
	}
	
	/**
	 * Method used to be Print all the times of all process
	 */
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
	
