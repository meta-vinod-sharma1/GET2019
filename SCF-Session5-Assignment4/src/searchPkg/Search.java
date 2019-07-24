package searchPkg;
/**
 * @description This class contains two method which can be used to search an item in the Array
 * @author Vinod
 * @date 18/07/2019
 *
 */
public class Search {
	
	//variable index : we use this variable in the linearSearch method for trace the array until we found base case
	private static int index = 0; 
	
	/**
	 * @description This method used to search a number in the Array and return index of that number
	 * @param inputArray Array of integer in which we will try to find searchNumber
	 * @param searchNumber this is a integer number which we need to find in array 
	 * @return index of searchNumber if we find searchNumber in the inputArray 
	 */
	public int linearSearch(int[] inputArray, int searchNumber){
		if(inputArray[index] == searchNumber){
			int tempVar = index;
			index =0;
			return tempVar;
		}else if(index == inputArray.length-1){
			return -1;
		}else{
			index++;
		}
		return linearSearch(inputArray , searchNumber);
	}
	
	/**
	 * @Warning : this method will not work without call to binarySearchByRecursion so make sure binarySearchByRecursion accessible by this method 
	 * @desciption This method used to be find a number in input Array and return index of that number
	 * @param inputArray Array of integers
	 * @param searchNumber which we need to find in the input Array
	 * @return 
	 */
	public int binarySearch(int[] inputArray, int searchNumber){
		int returnValue;
		if(isArraySorted(inputArray) == false){
			returnValue = -2;
		}
		int startIndex = 0;
		int endIndex = inputArray.length-1;
		return binarySearchByRecursion(inputArray, searchNumber, startIndex, endIndex);
	}
	
	/**
	 * @description This method used to be search a number in the array.
	 * @param inputArray input Array of integers
	 * @param searchNumber number which searched to be in the array
	 * @param startIndex start index of input Array
	 * @param endIndex end index of input Array 
	 * @return index of searched number
	 */
	public int binarySearchByRecursion(int[] inputArray, int searchNumber, int startIndex, int endIndex){
		int midIndex = (startIndex + endIndex)/2;
		if(inputArray[midIndex] == searchNumber){
			return midIndex;
		}else if(midIndex == inputArray.length-1 || midIndex == 0){
			return -1;
		}else if(searchNumber< inputArray[midIndex]){
			startIndex = 0;
			endIndex = midIndex;
		}else{
			startIndex = midIndex;
			endIndex = inputArray.length-1;
		}
		return binarySearchByRecursion(inputArray, searchNumber, startIndex, endIndex);
		
	}
	
	/**
	 * @description This method used to be find that array is sorted or not 
	 * @param inputArray array of integer value
	 * @return true if Array is sorted else false
	 */
	public boolean isArraySorted(int[] inputArray){
		boolean flag = true;
		for(int index = 0; index<inputArray.length-2; index++){
			if(inputArray[index]>inputArray[index+1]){
				flag = false;
				break;
			}
		}	
		return flag;
	}
}
