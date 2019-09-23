package session3Pkg.playerPkg;


/**
 * This class is for priority Queue Operation. class have method to add element in queue , Dequeue,  isQueueEmpty etc.
 */
public class  PlayerQueue  implements PriorityQueue{
	
	private final int FIRST = 1 ;
	private int last ;
	private int noOfBowler ;
	private Player[] queueArray;
	
	/**
	 * constructor for playerQueue
	 * @param capacity is max items in queue
	 */
	public PlayerQueue( int capacity){
		this.last = 0;
		this.noOfBowler = capacity;
		this.queueArray = new Player[capacity + 1];
		this.queueArray[0] = new Player("", Integer.MAX_VALUE);
	}
	
	/**
	 * This method used to insert a player in the Queue
	 */
	@Override
	public void enQueue(Player data) {
		if( last == noOfBowler) {
			System.out.println(" Bowler Limit is Full");
			return;
		}else{
			queueArray[++last] = data;
			int dataIndex = last;
			while(dataIndex / 2 != 0) {
				if( queueArray[dataIndex / 2].balls < queueArray[dataIndex].balls) {
					Player tempPlayer;
					tempPlayer = queueArray[dataIndex / 2];
					queueArray[dataIndex / 2] = queueArray[dataIndex];
					queueArray[dataIndex] = tempPlayer;
					dataIndex = dataIndex / 2;
				}else{
					break;
				}
			}
		}
	}
	
	/**
	 * This method used to extract a player form the queue
	 */
	@Override
	public Player deQueue() {
		Player popped = null;
		if(isEmpty()){
			return popped;
		}else{
			popped = queueArray[FIRST];
			queueArray[1] =  queueArray[last--];
			int index = 1;
			
			while( (2 * index <= last) && (queueArray[index * 2].balls > queueArray[index].balls || queueArray[index * 2 + 1].balls > queueArray[index].balls)) {	
				if( queueArray[ index * 2].balls > queueArray[ index * 2 + 1].balls) {
					Player temp = queueArray[ index * 2 ];
					queueArray[ index * 2 ] = queueArray[ index ];
					queueArray[index] = temp;
					
					index = index * 2;
				}else{
					Player temp = queueArray[ index * 2 + 1 ];
					queueArray[ index * 2 + 1 ] = queueArray[ index ];
					queueArray[index] = temp;
					index = index * 2 + 1;
				}
			}
		}
		playerRoutine(popped);
		return popped;
	}
	
	/**
	 * This method used to check that queue is empty or not 
	 */
	@Override
	public boolean isEmpty() {
		if(last == 0)
			return true;
		return false;
	}
	/**
	 * This method used to check queue size
	 */
	@Override
	public int queueSize() {
		return last;
	}
	
	/**
	 * This method used to popped max balls player and then insert again
	 * @param poppedPlayer
	 */
	private void playerRoutine(Player poppedPlayer){
		poppedPlayer.balls--;
		if(poppedPlayer.balls != 0 ){
			enQueue(poppedPlayer);
		}
	}
}
