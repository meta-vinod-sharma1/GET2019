/**
 * 
 */
package session2Pkg.queuePkg;

/**
 * This Interface have operations Methods reference for Queue
 * @author Vinod
 * @date 30/07/2019
 */
interface Queue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	boolean isFull();
	int frontElement();
	int rearElement();
	int queueSize();
	void displayQueue();

}
