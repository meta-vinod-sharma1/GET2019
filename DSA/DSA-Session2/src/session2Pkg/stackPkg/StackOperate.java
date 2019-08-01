package session2Pkg.stackPkg;

/**
 * This class have Stack of String implementation
 * @author Vinod
 *
 */
public class StackOperate implements Stack{
	
	Node root = null;
	

	@Override
	public void push(String element) {
		Node node = new Node(element);
		if(root == null){
			root = node;
		}else{
			Node tempNode = root;
			root = node;
			root.next = tempNode;
		}
		
	}
	
	@Override
	public String pop() {
		String popValue = null;
		if(isEmpty()){
			return popValue;
		}
		popValue = root.element;
		root = root.next;
		return popValue;
	}

	@Override
	public String peek() {
		if(root == null){
			return null;
		}
		return root.element;
	}

	@Override
	public boolean isEmpty() {
		if(root == null){
			return true;
		}
		return false;
	}

}
