package intSetPkg;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @description This class have a method which can be used when we Making a new Set of integer.  
 * @author LENOVO
 * @date 21/07/2019
 */
public class InputSet{
	Scanner inputObj = new Scanner(System.in);
	/**
	 * This method can be used when we want to create a new object of IntSet class and it will set all the values
	 * of intSetArray of that object
	 * @return it return the integer set object
	 */
	public IntSet setIntSetArray(){
		IntSet inputIntSet = null;
		try{
			System.out.println("Please Enter Array Size for Set");
			int sizeArray = inputObj.nextInt();
			if(sizeArray < 1){
				System.out.println("Wrong input !! Size can be only Positive integer");
				setIntSetArray();
			}else{
				int inputArray[] = new int[sizeArray];
				// collecting integer values for IntSet Object array
				for(int index=0; index<sizeArray; ){
					try{
						System.out.println("Enter integer[" + (index+1) + "] :");
						int enterNumber = inputObj.nextInt();
						if(0<= enterNumber && enterNumber <=1000){
							// check that enter number is already in Array or not
							if(!enterNumberInArray(inputArray,index+1,enterNumber)){
								inputArray[index] = enterNumber;
								index++;
							}else{
								System.out.println("--------------------------------------------------------");
								System.out.println("Warning : Oops !! You are not allowed to enter value again which in the Set");
								System.out.println("--------------------------------------------------------");
							}
						}else{
							System.out.println("--------------------------------------------------------");
							System.out.println("Warning : Please enter number in range 0 - 1000 !! Try Again");
							System.out.println("--------------------------------------------------------");
						}
					}catch(InputMismatchException e){
						System.out.println("--------------------------------------------------------");
						System.out.println("Warning : Please enter only integer value !! Try Again");
						System.out.println("--------------------------------------------------------");
						inputObj.nextLine();
					}
				}
				inputIntSet = new IntSet(inputArray);
			}
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			setIntSetArray();
		}
		return inputIntSet;
	}
	/**
	 * This method evaluate that, is a enter number  in this inputArray or not? if it have it will return true
	 *  otherwise false 
	 * @param inputArray integer Array of IntSet Object
	 * @param size size of inputArray 
	 * @param enterNumber which number you want check
	 * @return true if number is in the Array
	 */
	public boolean enterNumberInArray(int[] inputArray, int size, int enterNumber){
		if(size==1){
			return false;
		}
		for(int index=0; index<size; index++){
			if(inputArray[index]== enterNumber){
				return true;
			}else{
				continue;
			}
		}
		return false;
	}

}
