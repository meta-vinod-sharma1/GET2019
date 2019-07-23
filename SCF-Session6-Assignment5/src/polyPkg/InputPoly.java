package polyPkg;
import java.util.InputMismatchException;
/**
 * This class used to take input from user's for polynomial
 * @author Vinod
 * @date 21/07/2019
 */
import java.util.Scanner;
public class InputPoly {

	/**
	 * Method used to take Input values for PolynomialArray and create a object of Poly class for Polynomial Array
	 * @return Object of Poly class
	 */
	public Poly setPolyArray() {
		Poly inputPolyObj = null;
		Scanner inputObj = new Scanner(System.in);
		try{
			System.out.println("How many terms you want to enter");
			int terms = inputObj.nextInt();
			int inputArray[][] = new int[terms][2];
			for(int i=0; i<terms; i++){
				System.out.println("Term[" + (i+1) + "] :");
				try{
					for(int j =0; j<2; j++ ){
						if(j==0){
							System.out.println("coffecient");
							inputArray[i][0] = inputObj.nextInt();
						}else{
							System.out.println("Power");
							inputArray[i][1] = inputObj.nextInt();
						}
					}
				}catch(InputMismatchException e){
					System.out.println("--------------------------------------------------------");
					System.out.println("Warning : Please enter only integer value !! Try Again");
					System.out.println("--------------------------------------------------------");
					inputObj.nextLine();
				}
			}
			inputPolyObj = new Poly(inputArray);
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			setPolyArray();
		}
		return inputPolyObj;
	}



}
