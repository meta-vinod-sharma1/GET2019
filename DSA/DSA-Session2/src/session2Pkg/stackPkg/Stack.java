/**
 * 
 */
package session2Pkg.stackPkg;

/**
 * This interface used to operate a Stack of String
 * @author Vinod
 *
 */
public interface Stack {
	// root is node class reference which will track the top element of Stack
	Node root = null;
	
	/**
	 * This method used to push a element in the Stack
	 * @param element
	 */
	public void push(String element);
	
	/**
	 * This method used to remove a element from Stack
	 * @return removed element
	 */
	public String pop();
	
	/**
	 * This method used to know top element of the Stack
	 * @return
	 */
	public String peek();
	
	/**
	 * This method used to check that Stack is empty or not
	 * @return true if empty otherwise false
	 */
	boolean isEmpty();
	
}
