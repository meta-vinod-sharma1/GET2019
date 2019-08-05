package sparseMatricesPkg;

/**
 * This class used to make non-zero element of Sparse matrix
 * @author Vinod
 * @date 22/07/2019
 */
public class Node {
	
	public int row;
	public int col;
	public int value;
	
	public Node(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}

}
