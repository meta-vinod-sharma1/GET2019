package intSetPkg;
/**
 * This class can be used for making a integer Set or using it's operation. You can check number exist or not 
 * you can use it for union of two set or can use it for sub set check
 * @author LENOVO
 * @date 20/07/2019
 */
public final class IntSet {
	private final int[] intSetArray;
	private final int intSetArrayLength;
	

	/**
	 * This Contractor set Class member when new object created of that class
	 * @param inputArray integer Array of this object
	 */
	public IntSet(int[] inputArray){
		this.intSetArray = inputArray;
		this.intSetArrayLength = intSetArray.length;
		
	}
	
	/**
	 * This method check the number that it is exist in the Integer Set or not 
	 * @param checkNumber number to be check
	 * @return true if number in the set otherwise false
	 */
	public boolean isMember(int checkNumber){
		boolean flag = false;
		for(int index = 0; index<intSetArrayLength; index++){
			if(intSetArray[index]== checkNumber){
				flag = true;
				break;
			}
		}
		return flag;		
	}
	/**
	 * Method to find size of Integer set
	 * @return size of integer set
	 */
	public int size(){
		return intSetArray.length;
	}
	
	/**
	 * Method used to find that intSubSetObj is the subset of IntSet or not 
	 * @param intSubSetObj integer set to be check 
	 * @return true if it is subset of IntSet otherwise flase
	 */
	public boolean isSubSet(IntSet intSubSetObj){
		boolean flag = false;
		for(int subSetIndex=0; subSetIndex<intSubSetObj.intSetArray.length;subSetIndex++){
			flag = false;
			for(int intSetIndex=0; intSetIndex<intSetArrayLength; intSetIndex++){
				if(intSubSetObj.intSetArray[subSetIndex] == intSetArray[intSetIndex]){
					flag = true;
					break;
				}
			}
			if(flag==true){
				continue;
			}
			break;
		}
		
		return flag;
		
	}
	
	/**
	 * This method used to find complement set of IntSet
	 * @return complement set Array of IntSet
	 */
	public int[] getComplement(){
		int[] complementSetArray = new int[1001 - intSetArrayLength];
		int tempIndex = 0;
		for(int index=0; index<=1000; index++){
			if(isMember(index)){
				continue;
			}else{
				complementSetArray[tempIndex++] = index;
			}
		}
		return complementSetArray;
	}
	
	/**
	 * This method used to find Union Set of two Integer set 
	 * @param s1 first integer set
	 * @param s2 second integer set
	 * @return union set of s1 and s2
	 */
	public int[] union(IntSet s1, IntSet s2){
		int sizeOfUnion = s1.intSetArrayLength+s2.intSetArrayLength;
		int tempUnionSetArray[] = new int[sizeOfUnion];
		int unionCountIndex = 0;
		for(int index=0; index<=1000; index++){
			if(s1.isMember(index) || s2.isMember(index)){
				tempUnionSetArray[unionCountIndex++] = index;
			}else{
				continue;
			}
		}
		for(int index=0; index<unionCountIndex; index++){
			for(int index2=index+1; index2<unionCountIndex; index2++){
				if(tempUnionSetArray[index]>tempUnionSetArray[index2]){
					int tempValue = tempUnionSetArray[index];
					tempUnionSetArray[index] = tempUnionSetArray[index2];
					tempUnionSetArray[index2] = tempValue;
				}
			}
		}
		int unionSetArray[] = new int[unionCountIndex];
		for(int index =0;index<unionCountIndex; index++){
			unionSetArray[index] = tempUnionSetArray[index];
		}
		return unionSetArray;
		
	}
	
}
