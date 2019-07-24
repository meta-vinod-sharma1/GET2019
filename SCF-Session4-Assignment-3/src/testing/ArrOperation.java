package testing;
import java.util.*;
import java.io.*;
/**
 * class ArrOperation can used for specific array operation
 * 
 * @author Vinod
 *
 *
 */
public class ArrOperation {
	/**
	 * 
	 * @param arrOfIntegers 
	 * @return length of mirror in the array
	 * @exception throws error for Assertion Error
	 */
	public static int lengthOfMirror(int[] arrOfIntegers) throws AssertionError {
		int lengthOfMirror = 0;
		int tempLength = 0;
		if(arrOfIntegers.length==0){
			throw new AssertionError("Null Array Found");
		}else{
			for(int i=0; i<arrOfIntegers.length; i++){
				int pivotIndex=i;
				tempLength=0;
				for(int j=arrOfIntegers.length-1; j>=i;){
					if(arrOfIntegers[pivotIndex]==arrOfIntegers[j]){
						tempLength++;
						pivotIndex++;
						j--;
					}else if(tempLength > 0){
							if(tempLength > lengthOfMirror){
							lengthOfMirror = tempLength;
							tempLength = 0;
							pivotIndex = i;
						}else{
							tempLength = 0;
							pivotIndex = i;
						}	
					}else{
						tempLength = 0;
						pivotIndex = i;
						j--;
					}
				}
				if(tempLength>lengthOfMirror) lengthOfMirror=tempLength;
				
			}
		}
		
		return lengthOfMirror;
	}
	/**
	 * Method used to be count clumps 
	 * @param arrOfIntegers array of integers
	 * @return number of clumps
	 * @exception throws Assertion Error
	 */
	public static int numberOfClumps(int[] arrOfIntegers) throws AssertionError{
		int countAdjacent = 0;
		int countClumps = 0;
		if(arrOfIntegers.length == 0){
			throw new AssertionError("Empty Array Found");
		}else{
			for(int i=0; i<arrOfIntegers.length-1; i++){
				if(arrOfIntegers[i] == arrOfIntegers[i+1]){
					countAdjacent++;
				}else if(countAdjacent > 0){
					countClumps++;
					countAdjacent = 0;
				}else{
					continue;
				}
			}
			if(countAdjacent > 0){
				countClumps++;
			}
		}
		
		return countClumps;
	}
	
	/**
	 * @param X
	 * @param Y
	 * @param arrOfIntegers
	 * @return rearranged array according fixXY
	 * @exception  throws Assertion Error
	 */
	public static int[] fixXY(int X, int Y, int[] arrOfIntegers) throws AssertionError{
		int newArrayAfterFixXY[] = new int[arrOfIntegers.length];
		if(arrOfIntegers.length == 0){
			throw new AssertionError("Empty Array Found");
		}else{
			ArrayList<Integer> indexListOfY = new ArrayList<Integer>();
			int numberOfX = 0;
			for(int i=0; i<arrOfIntegers.length; i++){
				newArrayAfterFixXY[i] = arrOfIntegers[i];
				if(X== arrOfIntegers[i]){
					numberOfX++;
				}
				if(Y == arrOfIntegers[i]){
					indexListOfY.add(i);
				}else{
					continue;
				}
			}
			if(indexListOfY.size() == 0){
				throw new AssertionError("Y is not Found");
			}else if(numberOfX != indexListOfY.size()){
				throw new AssertionError("X and Y is unequal");
			}else{
				int indexOfList = 0;
				for(int i=0; i<newArrayAfterFixXY.length ; i++){
					if(X == newArrayAfterFixXY[i]){
						if( i == newArrayAfterFixXY.length -1){
							throw new AssertionError("X occurs at last index");
						}else{
							if(newArrayAfterFixXY[i] == newArrayAfterFixXY[i+1]){
								throw new AssertionError("Two Adjacent values is here");
							}else{
								int tempValue = newArrayAfterFixXY[i+1];
								newArrayAfterFixXY[i+1] = newArrayAfterFixXY[indexListOfY.get(indexOfList)];
								newArrayAfterFixXY[indexListOfY.get(indexOfList++)] = tempValue;
							}
						}
					}
				}
			}
		}

		return newArrayAfterFixXY;
	}
	
	/**
	 * 
	 * @param arrOfIntegers
	 * @return index which split array as left side sum equal right side sum
	 * @exception throws Assertion Errors
	 */
	public static int indexOfSplitArray(int[] arrOfIntegers){
		int index = -1;
		if(arrOfIntegers.length == 0){
			throw new AssertionError("Null Array Found");
		}else{
			int leftSideSum = 0;
			int rightSideSum = 0;
			for(int i =0; i<arrOfIntegers.length ; i++){
				rightSideSum += arrOfIntegers[i]; 
			}
			for(int i=0; i<arrOfIntegers.length; i++){
				if(leftSideSum<rightSideSum){
					leftSideSum += arrOfIntegers[i];
					rightSideSum -= arrOfIntegers[i];
				}else if(leftSideSum == rightSideSum){
					index = i;
					break;
				}else{
					break;
				}
			}
		}		
		return index;
	}

}
