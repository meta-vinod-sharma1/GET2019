package sparseMatricesPkg;

import java.util.ArrayList;
/**
 * This class have Operations method of matrix by using them we can find symmetric,Transpose and can add another matrix and can multiply.
 * @author Vinod
 * @date 22/07/2019
 */

public final class SparseMatrix {
	private final int row;
	private final int col;
	
	//Non-zero values of a matrix
	private final ArrayList<Node> matrix;
	/**
	 * Contractor used to set all instance of SparseMatrix class
	 * @param row row-size of matrix
	 * @param col col-size of matrix
	 * @param matrix ArrayList of User's non-zero input
	 */
	public SparseMatrix(int row, int col, ArrayList<Node> matrix){
		this.row = row;
		this.col = col;
		this.matrix = matrix;
	}
	
	/**
	 * Method used to find transpose matrix of matrix
	 * @return Object of SparseMatrix which have transpose matrix 
	 */
	public SparseMatrix transposeMatrix(){
		
		ArrayList<Node> transposeMatrix = new ArrayList<Node>();
		for(int i=0; i<matrix.size(); i++){
			Node node = new Node(matrix.get(i).col, matrix.get(i).row, matrix.get(i).value);
			transposeMatrix.add(node);
		}
		SparseMatrix transposeMatrixObj = new SparseMatrix(col, row,transposeMatrix);
		return transposeMatrixObj;
		
	}
	
	/**
	 * This method used to find whether a matrix is symmetrical or not
	 * @param Obj SparseMatrix Object 
	 * @return true if Matrix is Symmetrical otherwise false
	 */
	public boolean symmetricMatrix(SparseMatrix Obj){
		if(row!=col){
			return false;
		}
		SparseMatrix transposeMatrixObj = Obj.transposeMatrix();
		for(int i=0; i<Obj.row; i++){
			for(int j=0; j<Obj.col; j++){
				if(valueAtRowCol(i,j,Obj.matrix)!=valueAtRowCol(i,j,transposeMatrixObj.matrix)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * This method used to get addition of two matrices 
	 * @param ObjOne firstMatrix Object of SparseMatrix
	 * @param ObjTwo SecondMatrix Object of SparseMatrix
	 * @return Addition Matrix Object of SparseMatrix
	 */
	public SparseMatrix addMatrices(SparseMatrix ObjOne, SparseMatrix ObjTwo){
		SparseMatrix additionObj = null;
		if(ObjOne.row!=ObjTwo.row || ObjOne.col!=ObjTwo.col){
			System.out.println("Matrices Can't add because row and column not similar");
		}else{
			ArrayList<Node> addList = new ArrayList<Node>();
			for(int indexRow=0; indexRow<ObjOne.row; indexRow++){
				for(int indexCol=0; indexCol<ObjOne.col; indexCol++){
					int value = valueAtRowCol(indexRow, indexCol, ObjOne.matrix) + valueAtRowCol(indexRow, indexCol, ObjTwo.matrix);
					if(value!=0){
						Node node = new Node(indexRow,indexCol,value);
						addList.add(node);
					}else{
						continue;
					}
				}
			}
			additionObj = new SparseMatrix(row,col,addList);
		}
		return additionObj;
	}
	/**
	 * This method used to get Multiplication of two matrices
	 * @param Obj1 firstMatrix Object
	 * @param Obj2 SeconfMatrix Object
	 * @return multiplication matrix Object
	 */
	public SparseMatrix multiplyMatrix(SparseMatrix Obj1, SparseMatrix Obj2){
		SparseMatrix multiplyObj = null;
		if(Obj1.col!=Obj2.row){
			System.out.println("Matrices can't multiply because column of first matrix and row of 2nd matrix is not same");
		}else{
			ArrayList<Node> multiplyList = new ArrayList<Node>();
			for(int i=0; i<Obj1.row; i++){
				for(int q=0; q<Obj2.col; q++){
					int sum = 0;
					for(int j=0;j<Obj1.col; j++){
						sum += Obj1.valueAtRowCol(i,j, Obj1.matrix) * Obj2.valueAtRowCol(j, q, Obj2.matrix);
					}
					Node node = new Node(i,q,sum);
					multiplyList.add(node);
				}
			}
			multiplyObj = new SparseMatrix(Obj1.row,Obj2.col,multiplyList);
		}
		
		return multiplyObj;
		
	}
	/**
	 * This method Used to display sparse matrix
	 */
	public void displayMatrix(){
		System.out.println("--------------------------------------------------------");
		for(int i=0; i<row; i++){
			for(int j=0;j<col;j++){
				int value = valueAtRowCol(i,j,matrix);
				System.out.print( value +" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		
	}
	
	/**
	 * This method used to get value of Matrix at given row and col
	 * @param row row-size of matrix
	 * @param col column size of matrix
	 * @param matrix ArrayList of non-zero values of matrix
	 * @return value at [row][column] of matrix
	 */
	public int valueAtRowCol(int row, int col, ArrayList<Node> matrix){
		int value = 0;
		int sizeOfList = matrix.size();
		for(int i=0; i<sizeOfList;i++){
			if(matrix.get(i).row==row && matrix.get(i).col==col){
				value = matrix.get(i).value;
			}
		}
		return value;
	}

}
