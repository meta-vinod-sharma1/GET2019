package listPkg;

public class List {
	public Node head = null;
	/**
	 * This method used to add a integer value in the list
	 * @param data integer data to be added in the list
	 */
	public void addElement(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
		}else{
			Node tempHead = head;
			while(tempHead.next != null){
				tempHead = tempHead.next;
			}
			tempHead.next = node;
		}
	}
	/**
	 * This method used to know no of elements in the list
	 * @return no of elements in the list
	 */
	public int noOfElementInList(){
		int count = 0;
		Node tempHead = head;
		while(tempHead != null){
			count++;
			tempHead = tempHead.next;
		}
		return count;
	}
	
	/**
	 * This method used to display list 
	 */
	public void DisplayList(){
		if(head == null){
			throw new AssertionError("List is Empty");
		}else{
			Node tempHead = head;
			while(tempHead.next != null){
				System.out.print(tempHead.data + " -> ");
				tempHead = tempHead.next; 
			}
			System.out.println(tempHead.data);
		}
	}
	
	/**
	 * This method used to convert list integer data into an integer Array
	 * @param list list which will be operated
	 * @return Integer Array of list data
	 */
	public int[] convertListToArray(List list){
		int arr[] = new int[list.noOfElementInList()];
		Node tempHead = list.head;
		for(int i=0; i<arr.length;i++){
			arr[i] = tempHead.data;
			tempHead = tempHead.next;
		}
		return arr;
	}
	

}
