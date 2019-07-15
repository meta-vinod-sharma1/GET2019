package hexCalcPkg;
import java.io.*;
import java.util.ArrayList;
public class ConvertNumber {
	int hexToDecimal(String number){
		int base = 1;
		int decimalNumber=0;
		for(int i=number.length()-1;i>=0;i--){
			if(number.charAt(i)>='0' && number.charAt(i)<='9'){
				decimalNumber = decimalNumber + (number.charAt(i)-48)*base;
				base = base*16;
			}else{
				decimalNumber = decimalNumber + (number.charAt(i)-55)*base;
				base = base*16;
			}
		}
		return decimalNumber;	
	}
	
	
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
