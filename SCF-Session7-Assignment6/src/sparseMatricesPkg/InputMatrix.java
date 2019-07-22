package sparseMatricesPkg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMatrix {
	
	public SparseMatrix inputMatrix(){
		ArrayList<Node> sparseMatrixList = new ArrayList<Node>();
		SparseMatrix matrixObj = null;
		Scanner inputObj = new Scanner(System.in);
		try{
			System.out.println("Please enter data for Matrix");
			System.out.println("Enter row size");
			int row = inputObj.nextInt();
			System.out.println("Enter column Size");
			int col = inputObj.nextInt();
		
			
			for(int i=0; i<row; i++){
				for(int j =0; j<col; ){
					try{
						System.out.println("Please Enter value at Matrix[" + (i) + "][" + j + "]");
						int value = inputObj.nextInt();
						if(value!=0){
							Node node = new Node(i,j,value);
							sparseMatrixList.add(node);
						}
						j++;
					}catch(InputMismatchException e){
						System.out.println("--------------------------------------------------------");
						System.out.println("Warning : Please enter only integer value !! Try Again");
						System.out.println("--------------------------------------------------------");
						inputObj.nextLine();
					}
					
				}
				
			}
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
