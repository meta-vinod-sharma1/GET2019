package sparseMatricesPkg;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class used to operate SparseMatrix class and it's methods it contains Menu class also which provide Options of menu for matrix
 * @author Vinod
 * @date 21/07/2019
 */
public class Main {
	public static void main(String[] args){
		Menu menuObj = new Menu();
		InputMatrix inputMatrixObj = new InputMatrix();
		Scanner inputObj = new Scanner(System.in);
		
		//Creating Object of SparseMatrix by calling method inputMatrix() of InputMatrix class  
		SparseMatrix sparseMatrixObj = inputMatrixObj.inputMatrix();
		int choice = 0;
		do{
			try{
				menuObj.sparseMatrixMenu();
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					SparseMatrix transposeObj = sparseMatrixObj.transposeMatrix();
					transposeObj.displayMatrix();
					break;
				case 2:
					if(sparseMatrixObj.symmetricMatrix(sparseMatrixObj)==true){
						System.out.println("Your Output : Yes !! Matrix is Symmetrical");
					}else{
						System.out.println("Your Output : No !! Matrix is not Symmetrical");
					}
					break;
				case 3:
					System.out.println("Please enter row and column similar to pervious matrix ");
					SparseMatrix addObj = inputMatrixObj.inputMatrix();
					addObj = sparseMatrixObj.addMatrices(sparseMatrixObj,addObj);
					if(addObj != null){
						addObj.displayMatrix();
					}
					break;
				case 4:
					System.out.println("Please enter row and column for matrix which you want multiply ");
					SparseMatrix multiplyObj = inputMatrixObj.inputMatrix();
					multiplyObj = sparseMatrixObj.multiplyMatrix(sparseMatrixObj, multiplyObj);
					if(multiplyObj != null){
						multiplyObj.displayMatrix();
					}
					break;
				case 6: 
					sparseMatrixObj.displayMatrix();
					break;
				case 7 :
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
			}catch(InputMismatchException e){
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=7);

	}

}
