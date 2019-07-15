/**
 * @author VINOD
 * this class contains the methods for convert base to base 
 */
package hexCalcPkg;
import java.io.*;
import java.util.ArrayList;
public class ConvertNumber {
	
	/**
	 * this method conver hexadecimal number to decimal number 
	 * @param number take the value of hexadecimal number 
	 * @return decimal number of that hexadecimal 
	 */
	int hexToDecimal(String number){
		int base = 1;
		int decimalNumber=0;
		for(int i=number.length()-1;i>=0;i--){
			if(number.charAt(i)>='0' && number.charAt(i)<='9'){
				decimalNumber = decimalNumber + (number.charAt(i)-48)*base;
				base = base*16;
			}else{
				if (number.charAt(i)>='a' && number.charAt(i)<='z'){
					decimalNumber = decimalNumber + (number.charAt(i)-55-32)*base;
				}else{
					decimalNumber = decimalNumber + (number.charAt(i)-55)*base;
				}
				base = base*16;
			}
		}
		return decimalNumber;	
	}
	
	/**
	 * Method Convert decimal number to hexadecimal number 
	 * @param number take the integer parameter
	 * @return Hexadecimal number 
	 */
	String decimalToHex(int number){
		String hexNumber="";
		ArrayList<Character> charList = new ArrayList<Character>();
		int reminder,charCounter=0;
		if(number==0) hexNumber ="0";
		while(number>0){
			
			reminder = number%16;
			number = number/16;
			if(reminder>9){
				charList.add((char)(reminder + 55));
				charCounter++;
			}else{
				charList.add((char)(reminder + 48));
				charCounter++;
			}	
		}
		for(int i=charCounter-1;i>=0;i--){
			hexNumber = hexNumber + charList.get(i);
		}
		return hexNumber;
	}
}
