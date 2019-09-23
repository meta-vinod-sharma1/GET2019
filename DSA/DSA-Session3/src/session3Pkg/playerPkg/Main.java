package session3Pkg.playerPkg;
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
			System.out.println("Enter total balls virat will play");
			int totalPlayBalls = inputObj.nextInt();
			
			System.out.println("Enter total number of bowlers");
			int totalBowler = inputObj.nextInt();
			do{
				queueObj = new PlayerQueue(totalBowler);
				int totalBowlerBalls = 0;
				for(int bowler = 1 ; bowler<=totalBowler; ){
					String name;
					int ball;
					try{
						System.out.println("Enter Bowler[" + bowler + "] Name :");
						inputObj.nextLine();
						name = inputObj.nextLine();
						System.out.println("Enter Balls :");
						ball = inputObj.nextInt();
						if(ball > totalPlayBalls-totalBowlerBalls){
							System.out.println("Don't have enough balls");
							continue;
						}else if(bowler == totalBowler && totalBowlerBalls < totalPlayBalls){
							System.out.println("Re-enter Data !! Total Balls is less than Virat is going to play balls");
							queueObj = null;
						}
						totalBowlerBalls += ball;
						
						queueObj.enQueue(new Player(name, ball));
						bowler++;
						if(totalBowlerBalls == totalPlayBalls){
							break;
						}
					}catch(InputMismatchException e){
						System.out.println(view);
						System.out.println("Warning : Invalid value !! Try Again");
						System.out.println(view);
					}
				}
			}while(queueObj == null);
			
			System.out.println(view + "\nBowlers Rank |   Name");
			int rank = 1;
			while(!queueObj.isEmpty() && rank<= totalPlayBalls){
				System.out.println("   Rank " + rank++ + "    |   " + queueObj.deQueue().bowlerName);
			}
			System.out.println(view);
			main(args);
		}catch(InputMismatchException e){
			System.out.println(view);
			System.out.println("Warning : Invalid value !! Try Again");
			System.out.println(view);
		}
		
		
	}

}
