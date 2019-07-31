package listPkg;

public class SubListOperation {
	/**
	 * This method used to rotate Sub list of a list of integer
	 * @param leftPosition Starting Point of SubList and Position of List
	 * @param rightPosition end Point of SubList and Position of List
	 * @param rotateRound How many time sub list should be rotate
	 * @param listObj List object which need to Operate
	 */
	public void rotateSubList(int leftPosition, int rightPosition, int rotateRound, List listObj){
		
		if(leftPosition > rightPosition){ 
			throw new AssertionError("Right Position can't be less than Left Position ");
		}else if(leftPosition < 1 || rightPosition <1){
			throw new AssertionError("Position can't less than 1 ");
		}else if( rotateRound < 0){
			throw new AssertionError("Rotate Round can't be negative !! Please Try Again");
		}else if(leftPosition > listObj.noOfElementInList() || rightPosition > listObj.noOfElementInList()){
			throw new AssertionError("Position's Can't go outside List");
		}else if(leftPosition == rightPosition){
			throw new AssertionError("Position's can't be equal");
		}else{

			int noOfElementInSubList = rightPosition-leftPosition+1;
			rotateRound = rotateRound % noOfElementInSubList;
			if(rotateRound != 0){
				Node leftNodeOfSubList = null, startNode = null, endNode = null, leftNode=null, rightNode = null, tempHead = listObj.head;
				int count = 0;
				while(tempHead != null){
					count++;
					if(count == leftPosition -1){
						leftNodeOfSubList = tempHead;
					}
					if(count == leftPosition){
						leftNode  = tempHead;
					}
					if(count == leftPosition + noOfElementInSubList - rotateRound-1){
						rightNode = tempHead;
					}
					if(count == leftPosition + noOfElementInSubList - rotateRound){
						startNode = tempHead;
					}
					if(count == rightPosition){
						endNode = tempHead;
					}
					tempHead = tempHead.next;
				}
				rightNode.next = endNode.next;
				endNode.next = leftNode;
				if(leftNodeOfSubList !=null ){
					leftNodeOfSubList.next = startNode;
				}else{
					listObj.head = startNode;
				}
				
			}
		}
		
	}
}
