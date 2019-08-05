package session4Pkg.uniquePkg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * The class contains method that takes a string and returns the number of unique characters in the string.
 * @author Vinod
 * @date 03/08/2019
 *
 */
public class UniqueCharacters {
    private HashMap<String, Integer> dataMap;
    private Set<Character> uniqueCharacters;
    private Set<Character> repeatedCharacters;
 /**
  * The constructor method    
  */
    public UniqueCharacters() {
        dataMap = new HashMap<String, Integer>();
        uniqueCharacters = new HashSet<Character>();
        repeatedCharacters = new HashSet<Character>();
    }
  
   /**
    * This method counts unique characters in the string i.e characters which are not repeated.
    * it calls checkInCache() to verify if the string is already been present in HashMap
    * @param inputString
    * @return
    */
    public int countUniqueCharacters(String inputString) {
        inputString = inputString.toLowerCase();
        uniqueCharacters.clear();
        repeatedCharacters.clear();
        if(checkInCache(inputString) != -1){
        	return checkInCache(inputString);
        }else{
        	for(int index = 0; index < inputString.length(); index++) {
                if(uniqueCharacters.contains(inputString.charAt(index))) {
                    repeatedCharacters.add(inputString.charAt(index));
                    uniqueCharacters.remove(inputString.charAt(index));
                }else if(!repeatedCharacters.contains(inputString.charAt(index))) {
                    uniqueCharacters.add(inputString.charAt(index));
                }
            }
            dataMap.put(inputString, uniqueCharacters.size());
            return uniqueCharacters.size();
        }
    }
    /**
     * checkInCache() to verify if the string is already been present in HashMap
     * @param inputString
     * @return
     */
    private int checkInCache(String inputString) {
       
        if(dataMap.containsKey(inputString)){
        	return dataMap.get(inputString);
        }else{
        	return -1;
        }
    }
}