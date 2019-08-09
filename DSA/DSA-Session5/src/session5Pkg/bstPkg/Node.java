package session5Pkg.bstPkg;


public class Node {

	private int key;
	private String value;
	public Node left;
	public Node right;

	/**
	 * Constructor to Initialize node values.
	 * 
	 * @param key  Key of the node.
	 * @param value Value of the node.
	 */
	public Node(int key, String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/**
	 * Getter for key value
	 * @return the key
	 */
	public int getKey() {
		return this.key;
	}

	/**
	 * Getter for value
	 * @return the value.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * setter for key 
	 * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * setter for value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}