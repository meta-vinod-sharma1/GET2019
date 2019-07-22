package polyPkg;

import java.util.InputMismatchException;
import java.util.Scanner;
public class InputPoly {

	public Poly setPolyArray() {
		Poly inputPolyObj = null;
		Scanner inputObj = new Scanner(System.in);
		try{
			System.out.println("How many terms you want to enter");
			int terms = inputObj.nextInt();
			int inputArray[][] = new int[terms][2];
			for(int i=0; i<terms; i++){
				for(int j =0; j<2; ){
					try{
						if(j==0){
							System.out.println("Please Enter coffecient");
							inputArray[i][0] = inputObj.nextInt();
						}else{
							System.out.println("Please Enter Power");
							inputArray[i][1] = inputObj.nextInt();
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
