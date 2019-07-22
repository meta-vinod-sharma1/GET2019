package sparseMatricesPkg;

import java.util.ArrayList;

public final class SparseMatrix {
	private final int row;
	private final int col;
	private final ArrayList<Node> matrix;
	
	public SparseMatrix(int row, int col, ArrayList<Node> matrix){
		this.row = row;
		this.col = col;
		this.matrix = matrix;
	}
	
	public SparseMatrix transposeMatrix(){
		
		ArrayList<Node> transposeMatrix = new ArrayList<Node>();
		for(int i=0; i<matrix.size(); i++){
			Node node = new Node(matrix.get(i).col, matrix.get(i).row, matrix.get(i).value);
			transposeMatrix.add(node);
		}
		SparseMatrix transposeMatrixObj = new SparseMatrix(col, row,transposeMatrix);
		return transposeMatrixObj;
		
	}
	
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
	
	public SparseMatrix addMatrices(SparseMatrix ObjOne, SparseMatrix ObjTwo){
		SparseMatrix addObj = null;
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
			addObj = new SparseMatrix(row,col,addList);
		}
		return addObj;
	}
	public SparseMatrix multiplyMatrix(SparseMatrix Obj){
		SparseMatrix multiplyObj = null;
		if(col!=Obj.row){
			System.out.println("Matrices can't multiply because column of first matrix and row of 2nd matrix is not same");
		}else{
			ArrayList<Node> multiplyList = new ArrayList<Node>();
			for(int indexRow=0; indexRow<row; indexRow++){
				for(int indexCol=0; indexCol<col; indexCol++){
				}
			}
			multiplyObj = new SparseMatrix(row,col,multiplyList);
		}
		
		return multiplyObj;
		
	}
	
	
	
	
	
	
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
	
	public int valueAtRowCol(int row, int col, ArrayList<Node> matrixList){
		int value = 0;
		int sizeOfList = matrixList.size();
		for(int i=0; i<sizeOfList;i++){
			if(matrixList.get(i).row==row && matrixList.get(i).col==col){
				value = matrixList.get(i).value;
			}
		}
		return value;
	}

}
