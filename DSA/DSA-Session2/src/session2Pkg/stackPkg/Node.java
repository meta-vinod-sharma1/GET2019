package session2Pkg.stackPkg;

/**
 * This class have used to make a node which have one element and one reference
 * @author Vinod
 *
 */
public class Node {
	public String element;
	public Node next;
	
	/**
	 * Constractor of Node class will set element value and next to null
	 * @param element
	 */
	public Node(String element) {
		this.element = element;
		this.next = null;
	}

}
