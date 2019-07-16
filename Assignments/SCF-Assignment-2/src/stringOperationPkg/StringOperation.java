
package stringOperationPkg;
import java.util.*;
/**
 *@author 
 * this class have methods for Sting Operation 
 */
public class StringOperation {
	/**
	 * Method used to be compare two strings
	 * @param str1 take first string 
	 * @param str2 take second string 
	 * @return true if string are equal otherwise false 
	 */
	static boolean compareStrings(String str1, String str2){
		boolean compare_flag = true;
		if(str1.length() == str2.length()){
			for(int i=0; i<str1.length(); i++){
				if(str1.charAt(i) != str2.charAt(i)){
					System.out.println(str1.charAt(i) + "==" + str2.charAt(i));
					return false;
				}
			}
		}else{
			return false;
		}
		
		return compare_flag;
	}
	
	/**
	 * Method used to be reverse a string 
	 * @param str takes the String of operation
	 * @return reverse string 
	 */
	static String reverseString(String str){
		String new_str = "";
		for(int i = (str.length()-1); i>=0; i-- ){
			new_str += str.charAt(i);
		}
		return new_str;
	}
	
	/**
	 * Method used to be replace Upper to lower and lower to Upper
	 * @param str
	 * @return replace string
	 */
	static String replaceWord(String str){
		
		String new_str = "";
		char c;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				c = (char)(str.charAt(i) - 32);
				new_str += c;
			}else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				c = (char)(str.charAt(i) + 32);
				new_str += c;
			}else{
				c = (char)str.charAt(i);
				new_str += c;
			}
		}
		
		return new_str;
	}
	
	/**
	 * Method used to be find last largest word of string 
	 * @param str
	 * @return largest word of string or last largest word if two words have same length
	 */
	static String findLargestWord(String str){
		int max_length = 0, word_length = 0;
		String largest_word = "", word = "";
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) != 32){
				word_length++;
				word += (char)str.charAt(i);
				continue;
			}
			if(word_length > max_length){
				max_length = word_length;
				largest_word = word;		
			}else if(word_length == max_length){
				largest_word = word;
			}
			word="";
			word_length = 0;
		}
		if(word_length >= max_length){
			largest_word = word ;
		}
		
		return largest_word;
	}
	
	

}
