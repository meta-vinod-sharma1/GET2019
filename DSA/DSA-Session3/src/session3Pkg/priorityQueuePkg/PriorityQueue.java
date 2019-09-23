package session3Pkg.priorityQueuePkg;

/**
 * This Interface can be used in implement Priority Queue.
 */
public interface PriorityQueue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	int firstElement();
	int queueSize();

}