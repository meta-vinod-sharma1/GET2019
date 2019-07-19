package nqProblemPkg;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @description Class NqMain solution for N queen problem
 *  The N Queen is the problem of placing N chess queens on an N×N chessboard
 *  So that no two queens attack each other only in this condition solution is possible and you will get true
 * @author Vinod
 *
 */

public class NqMain {

	public static void main(String[] args){
		Scanner inputObj = new Scanner(System.in);
		System.out.println("Enter Chess Board Size  ");
		try{
			int boardSize = inputObj.nextInt();
			NQProblem  nqProblemObj = new NQProblem(boardSize); 
			if(boardSize < 1){
				main(args);
			}
			int boardArray[][] = new int[boardSize][boardSize];
			boolean result = nqProblemObj.solutionOfNQ(boardArray,0);
			if(result == true){
				System.out.println("\n-------------------------------------------------------------------------------------");
				System.out.println("Your Output : True\nSolution Possible by nq problem");
				System.out.println("---------------------------------------------------------------------------------------\n");
				
			}else{
				System.out.println("\n-------------------------------------------------------------------------------------");
				System.out.println("Your Output : False\nSolution is not Possible by nq problem");
				System.out.println("---------------------------------------------------------------------------------------\n");
			}
			
			main(args);
		}catch(InputMismatchException e){
			System.out.println("Please enter only integer value");
			inputObj.nextLine();
			main(args);
		}
		

	}

}
