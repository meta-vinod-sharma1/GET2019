package detectLoopPkg;

import listPkg.List;
import listPkg.Node;

/**
 * This class have a method to detect that list have loop or not
 * @author Vinod
 * @date 30/07/2019
 */
public class DetectLoop{
	/**
	 * This method can used to know that list have loop or not
	 * @param head Head of the list
	 * @return true if list have loop otherwise return false
	 */
	public static boolean foundLoop(Node head){
		Node slowCounter=head, fastCounter=head;
		while (slowCounter != null && fastCounter != null && fastCounter.next != null) { 
            slowCounter = slowCounter.next; 
            fastCounter = fastCounter.next.next; 
            if (slowCounter == fastCounter) { 
                return true; 
            } 
        } 
        return false; 
	}
}
