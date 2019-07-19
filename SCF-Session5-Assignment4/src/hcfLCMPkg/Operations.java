package hcfLCMPkg;

public class Operations {
	
	/**
	 * Method used to be computed Highest common Factor
	 * @param firstNumber First integer number
	 * @param secondNumber Second integer number
	 * @return highest common factor
	 */
	public int highestCommonFactor(int firstNumber, int secondNumber){
		if(secondNumber == 0){
			return firstNumber;
		}
		return highestCommonFactor(secondNumber, firstNumber%secondNumber);
	}
	
	/**
	 * 
	 * @param firstNumber First integer number
	 * @param secondNumber Second integer number
	 * @return least common multiple 
	 */
	public int leastCommonMultiple(int firstNumber, int secondNumber){
		return (firstNumber*secondNumber)/highestCommonFactor(firstNumber, secondNumber);
	}
	
	
	/* this method created if we want use recursion for lcm which is complicated in some situations
	public static int leastCommonMultipleSecond(int firstNumber, int secondNumber, int leastCommonFactor){
		if(leastCommonFactor%firstNumber == 0 && leastCommonFactor%secondNumber ==0){
			return leastCommonFactor;
		}
		
		return leastCommonMultiple( firstNumber, secondNumber, ++leastCommonFactor);
	}
	*/
}
