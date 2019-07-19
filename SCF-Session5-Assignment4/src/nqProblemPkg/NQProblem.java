package nqProblemPkg;

public class NQProblem {
	int boardSize;
	public NQProblem(int boardSize) {
		this.boardSize = boardSize;
	}
	/**
	 * This method can compute that at position(row,col) we can place a queen or not
	 * @param boardArray Integer array of chess board
	 * @param row row value of chess board
	 * @param col column value of chess board
	 * @return true if we can place a queen at position(row,col) otherwise return false
	 */
	public boolean isSafe(int[][] boardArray, int row, int col){
		for(int index=0; index < col ; index++){
			if(boardArray[row][index]==1){
				return false;
			}
		}
		for(int rowIndex=row, colIndex= col; rowIndex>=0 && colIndex>=0; colIndex--, rowIndex--){
			if(boardArray[rowIndex][colIndex]==1){
				return false;
			}
		}
		for(int rowIndex=row, colIndex= col; rowIndex<boardSize && colIndex>=0; rowIndex++, colIndex--){
			if(boardArray[rowIndex][colIndex]==1){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * This Program find that is it possible to place N chess queens on an N×N chessboard
	 * so that no two queens attack each other
	 * @param boardArray two dimensional integer array with values zero
	 * @param col column index of array
	 * @return true if we can place rightly otherwise false
	 */
	public boolean solutionOfNQ(int[][] boardArray, int col){
		
		if(col==boardSize){
			return true;
		}
		boolean resultOfNQ = false;
		for(int index=0; index<boardSize; index++){
			if(isSafe(boardArray, index, col)){
				boardArray[index][col] = 1;
				resultOfNQ = solutionOfNQ(boardArray, col + 1) || resultOfNQ;
				boardArray[index][col] = 0;
			}
		}
		return resultOfNQ;
	}

}
