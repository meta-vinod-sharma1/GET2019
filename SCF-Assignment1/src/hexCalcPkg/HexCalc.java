/**
 * @author VINOD
 * @version 1.0
 * 
 */
package hexCalcPkg;
import java.io.*;
public class HexCalc {
	
	/**
	 * method addNumbers Calculate addition of two hexadecimal numbers
	 * @param firstNumber use as first hexadecimal number
	 * @param secondNumber use as 2nd hexadecimal number 
	 * @return addition of two hexadecimal number
	 */
	String addNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) + convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
	}
	
	/**
	 * method gives subtraction of two hexadecimal number 
	 * @param firstNumber
	 * @param secondNumber
	 * @return subtraction of two hexadecimal number
	 */
	String subNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) - convertNumberObject.hexToDecimal(secondNumber);
		if(result<0){
			result = - result;
			return "-" + convertNumberObject.decimalToHex(result);
		}else{
			return convertNumberObject.decimalToHex(result);
		}
		
	}
	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return multiplication of two hexadecimal numbers
	 */
	String mulNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) * convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
		
	}
	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return dividation of two hexadecimal numbers
	 */
	String divNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) / convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
	}
	
	/**
	 *  Method check that two hexadecimal are same or not 
	 * @param firstNumber
	 * @param secondNumber
	 * @return true if equal
	 */
	boolean isEqual(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) == convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	
	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return that firstNumber is greater or not 
	 */
	boolean isGreater(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) > convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return first number is less than or not 
	 */
	boolean isLess(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) < convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	
	
}
