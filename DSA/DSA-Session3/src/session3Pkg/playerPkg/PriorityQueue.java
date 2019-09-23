package session3Pkg.playerPkg;

/**
 * This Interface Mehods can be used to Operate a Player Object as Priority Queue by It's Attribute
 * @author Vinod
 *
 */
interface PriorityQueue{
	void enQueue(Player data);
	Player deQueue();
	boolean isEmpty();
	int queueSize();

}