package markSheetPkg;

public class MathOperation {
	
	
	/**
	 * Method used to be compute average of an array
	 * @param arr array of grades 
	 * @return average of grades 
	 */
	double averageOfElements(int[] arr){
		double result = 0;
		for(int i=0; i<arr.length; i++){
			result += arr[i];
		}
		return (result/arr.length);
	}
	
	/**
	 * Method used to be compute maximum value elements in the array 
	 * @param arr
	 * @return
	 */
	double maximumOfElements(int[] arr){
		double max = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}
	
	/**
	 * Method used to be compute minimum value of elements in the array 
	 * @param arr array of grades
	 * @return minimum value from elements
	 */
	double minimumOfElements(int[] arr){
		double min = 100;
		for(int i=0; i<arr.length; i++){
			if(arr[i] < min) min = arr[i];
		}
		return min;
	}
	
	/**
	 * Method used to be compute to eligible for a condition
	 * @param arr array of grades
	 */
	void eligibleOfElements(int[] arr){
		System.out.println("\tPassed Students ");
		for(int i=0; i<arr.length; i++){
			if(arr[i] >= 40){
				System.out.println("\t\tStudent[" + (i+1) + "] : Passed");
			}
		}
	}
	
}
