package hexCalcPkg;
import java.io.*;
public class HexCalc {
	
	// addNumbers method add to hexadecimal Number
	String addNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) + convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
	}
	
	// subNumbers method doing substraction of two hexadecimal Number
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
	
	String mulNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) * convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
		
	}
	
	String divNumbers(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		int result = convertNumberObject.hexToDecimal(firstNumber) / convertNumberObject.hexToDecimal(secondNumber);
		return convertNumberObject.decimalToHex(result);
	}
	
	boolean isEqual(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) == convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	
	
	boolean isGreater(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) > convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	
	boolean isLess(String firstNumber, String secondNumber){
		ConvertNumber convertNumberObject = new ConvertNumber();
		if( convertNumberObject.hexToDecimal(firstNumber) < convertNumberObject.hexToDecimal(secondNumber)){
			return true;
		}else{
			return false;
		}	
	}
	
	
}
