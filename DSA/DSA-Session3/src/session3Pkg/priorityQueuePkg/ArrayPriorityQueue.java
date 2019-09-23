package session3Pkg.priorityQueuePkg;

/**
 * This class is for Priority Queue Operation. class have method to add element in Queue with check it's value as Priority, Dequeue,  isQueueEmpty etc.
 */
public class  ArrayPriorityQueue  implements PriorityQueue{

	private final int FIRST = 1 ;
	private int last ;
	private int capacityOfQueue ;
	private int[] queueArray;

	/**
	 * constructor for ArrayPriorityQueue
	 * @param capacity is max items in queue
	 */
	public ArrayPriorityQueue( int capacity){
		this.last = 0;
		this.capacityOfQueue = capacity + 1;
		this.queueArray = new int[capacity + 1];
		this.queueArray[0] = Integer.MAX_VALUE;
	}
	
	/**
	 * This method used to insert an element with checking it's Priority and make sure while inserting that parent will be greater than child
	 * @data data to be entered
	 */
	@Override
	public void enQueue(int data) {

		if( last + 1 == capacityOfQueue){
			System.out.println(" Queue is full !! Can't Added");
			return;
		}else{
			queueArray[++last] = data;
			int position = last;
			
			while(position / 2 != 0) {
				// it will check that entered data is Grater than it's parent or not 
				if( queueArray[position / 2] < queueArray[position] ) {
					
					int tempValue = queueArray[position / 2];
					queueArray[position / 2] = queueArray[position];
					queueArray[position] = tempValue;
					position = position / 2;
				}else {
					//if parent is greater than it's child
					break;
				}
			}
		}
	}
	
	/**
	 * This method used to extract Most Priority Element from the Queue.
	 * @return return popped data
	 */
	@Override
	public int deQueue() {
		int poppedData = Integer.MIN_VALUE;
		if(isEmpty()){
			return poppedData;
		}else{
			poppedData = queueArray[FIRST];
			queueArray[1] = queueArray[last--];
			
			int index = 1;

			while( (2*index <= last ) && (queueArray[index * 2] > queueArray[index] || queueArray[index * 2 + 1] > queueArray[index])) {
				
				// left child greater than right child
				if( queueArray[ index * 2] > queueArray[ index * 2 + 1]) {
					int tempValue = queueArray[ index * 2 ];
					queueArray[ index * 2 ] = queueArray[ index ];
					queueArray[index] = tempValue;
					index = index * 2;
				}
				else if( queueArray[ index * 2 + 1] >= queueArray[ index * 2 ]) {
					int temp = queueArray[ index * 2 + 1 ];
					queueArray[ index * 2 + 1 ] = queueArray[ index ];
					queueArray[index] = temp;
					index = index * 2 + 1;
				}
			}
		}
		return poppedData;
	}
	
	/**
	 * This method used to know that PriorityQueue is empty or not
	 * @return true if empty otherwise false
	 */
	@Override
	public boolean isEmpty() {
		if(last == 0){
			return true;
		}	
		return false;
	}

	/**
	 * This method used to get Most Priority Value
	 * @return Most Priority Value
	 */
	@Override
	public int firstElement() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return queueArray[FIRST];
	}
	
	/**
	 * This method used to get size of Queue
	 * @return Queue Size
	 */
	@Override
	public int queueSize() {
		return last;
	}
}
