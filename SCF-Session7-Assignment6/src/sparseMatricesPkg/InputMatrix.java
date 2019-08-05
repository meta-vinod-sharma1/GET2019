package sparseMatricesPkg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class have a method by which we can insert user's input in Sparse matrix by using inputMatrix method
 * @author Vinod
 * @date 23/07/2019
 *
 */
public class InputMatrix {
	/**
	 * This method used to insert User's input in a ArrayList as sparse matrix and then this method create a object of SparseMatrix
	 * by using ArrayList of input
	 * @return Object of SparseMatrix
	 */
	public SparseMatrix inputMatrix(){
		// list to insert Input's
		ArrayList<Node> sparseMatrixList = new ArrayList<Node>();
		// Object of SparseMatrix Class
		SparseMatrix matrixObj = null;
		Scanner inputObj = new Scanner(System.in);
		try{
			System.out.println("Please enter data for Matrix");
			System.out.println("Enter row size");
			int row = inputObj.nextInt();
			if(row<1){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only Positive value for row size !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputMatrix();
			}
			System.out.println("Enter column Size");
			int col = inputObj.nextInt();
			if(col<1){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only Positive value for column size !! Try Again");
				System.out.println("--------------------------------------------------------");
			}
		
			// Collecting Non-zero values in list
			for(int indexOne=0; indexOne<row; indexOne++){
				for(int indexTwo =0; indexTwo<col; ){
					try{
						System.out.println("Please Enter value at Matrix[" + (indexOne) + "][" + indexTwo + "]");
						int value = inputObj.nextInt();
						if(value!=0){
							Node node = new Node(indexOne,indexTwo,value);
							sparseMatrixList.add(node);
						}
						indexTwo++;
					}catch(InputMismatchException e){
						System.out.println("--------------------------------------------------------");
						System.out.println("Warning : Please enter only integer value !! Try Again");
						System.out.println("--------------------------------------------------------");
						inputObj.nextLine();
					}
					
				}
				
			}
			// Initialise matrixObj by calling constractor 
			matrixObj = new SparseMatrix(row, col, sparseMatrixList);
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			inputMatrix();
		}
		
		 return matrixObj;
		
		
	}

}
