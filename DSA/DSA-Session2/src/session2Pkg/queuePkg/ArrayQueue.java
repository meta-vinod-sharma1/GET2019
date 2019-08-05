package session2Pkg.queuePkg;

/**
 * This class is for Queue Operation. class have method to operate like add element in queue , Dequeue,  isQueueEmpty etc
 * @author Vinod
 *
 */
public class ArrayQueue implements Queue{
	
	private int front ;
	private int rear ;
	private int queueSize;
	private int capacityOfQueue ;
	private int[] queueArray;
	
	public ArrayQueue( int capacity){
		this.front = -1;
		this.rear = -1;
		this.queueSize = 0;
		this.capacityOfQueue = capacity;
		this.queueArray = new int[capacity];
	}

	@Override
	public void enQueue(int data) {
		if(isEmpty()){
			front = 0;
			rear = 0;
			queueArray[rear] = data;
			queueSize++;
			
		}else{
			if(!isFull()){
				rear = (rear+1) % capacityOfQueue;
				queueArray[rear] = data;
				queueSize++;
			}else{
				System.out.println("Queue is full");
			}
		}
		
	}

	@Override
	public int deQueue() {
		if(isEmpty()){
			return -1111;
		}
		int data = queueArray[front];
		front = (front+1)%capacityOfQueue;
		queueSize--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		if(queueSize == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(queueSize == capacityOfQueue){
			return true;
		}
		return false;
	}

	@Override
	public int frontElement() {
		if(isEmpty()){
			return -1111;
		}
		return queueArray[front];
	}

	@Override
	public int rearElement() {
		if(isEmpty()){
			return -1111;
		}
		return queueArray[rear];
	}

	@Override
	public int queueSize() {
		return queueSize;
	}
	
	@Override
	public void displayQueue(){
		for(int index = front; ; ){
			if(index == rear){
				System.out.println(queueArray[index] );
				break;
			}
			System.out.print(queueArray[index] + " ");
			index = (index+1) % capacityOfQueue;
		}
	}
}
