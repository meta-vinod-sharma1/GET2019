package session3Pkg.playerPkg;

/**
 * This is Player class used to create a player
 * @author Vinod
 *
 */
public class Player {
	
	public String bowlerName;
	public int balls;
	
	/**
	 * Constractor Intialize Bowler Name and Balls left a Player when new Player Created
	 * @param bowlerName name of bowler
	 * @param balls balls left  of a bowler
	 */
	Player(String bowlerName, int balls) {
		this.bowlerName = bowlerName;
		this.balls = balls;
	}


}
