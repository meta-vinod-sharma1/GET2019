package polyPkg;
/**
 * This class contains method for operation on polynomial. you can add, multiply polynomial by using this class
 * @author Vinod
 * @date 22/07/2019
 */
public final class Poly {

	private final int[][] polynomialArray;

	// constructor to initialize polynomial with input array.
	Poly(int[][] input) {
		if (input.length == 0){
			throw new AssertionError("input can't be empty");
		}
		polynomialArray = input;
	}

	// constructor to declare size of polynomial 2D array.
	Poly(int size) {
		polynomialArray = new int[size][2];
	}

	/*
	 * This method is used to evaluate the value of polynomial at a value.
	 * @param value is the constant put in variable.
	 * @return result of evaluation.
	 */
	int evaluate(float value) {
		int result = 0;
		for (int index = 0; index < polynomialArray.length; index++) {
			result += getPolynomialArray()[index][0] * Math.pow(value, getPolynomialArray()[index][1]);
		}
		return result;
	}

	/*
	 * This method is used to compute the degree of a polynomial.
	 * @return the {int} degree of the polynomial.
	 */
	int degree() {
		int degree = 0;
		for (int index = 0; index < getPolynomialArray().length; index++) {
			if (degree < getPolynomialArray()[index][1]){
				degree = getPolynomialArray()[index][1];
			}
		}
		return degree;
	}

	/*
	 * This method is used to get coefficient of existing power in polynomial.
	 * @param power is the input whose coefficient to be found.
	 * @return {int} coefficient of x^power.
	 */
	private int getCofficient(int power) {
		for(int index = 0; index < getPolynomialArray().length; index++) {
			if (getPolynomialArray()[index][1] == power) {
				return getPolynomialArray()[index][0];
			}
		}
		return 0;
	}

	/*
	 * add two polynomial
	 * @param polynomialOne is the first polynomial
	 * @param polynomialTwo is the second polynomial
	 * @return {Poly} the addition polynomial
	 */
	static Poly addPoly(Poly polynomialOne, Poly polynomialTwo) {
		int degree = Math.max(polynomialOne.degree(), polynomialTwo.degree());
		Poly additionObj = new Poly(degree + 1);
		int cofficient = 0;
		for (int index = 0; index <= degree; index++) {

			if (polynomialOne.getCofficient(index) != 0 || polynomialTwo.getCofficient(index) != 0) {
				cofficient = polynomialOne.getCofficient(index) + polynomialTwo.getCofficient(index);
				additionObj.getPolynomialArray()[index][0] = cofficient;
				additionObj.getPolynomialArray()[index][1] = index;
			}
		}
		return additionObj;
	}

	/*
	 * To check if 2D array contains the given power
	 * @param givenArray is the polynomial to be checked
	 * @param power is the power of variable to be checked
	 * @return index where the power of variable & its coefficient exists or -1 if doesn't exist
	 */
	private static int returnIndex(int[][] givenArray, int power) {
		int indexOfPower = -1;
		for (int index = 0; index < givenArray.length; index++) {
			if (givenArray[index][1] == power) {
				indexOfPower = index;
			}
		}
		return indexOfPower;
	}

	/*
	 * multiply two polynomial
	 * @param polyOne is the first polynomial
	 * @param polyTwo is the second polynomial
	 * @return {Poly} multiplication polynomial
	 */

	static Poly multiplyPoly(Poly polyOne, Poly polyTwo) {

		int degree = polyOne.degree() + polyTwo.degree();
		Poly multiplicationObj = new Poly(degree + 1);
		int indexOfPower = 0;
		int incrementIndex = 0;
		for (int index1 = 0; index1 < polyOne.getPolynomialArray().length; index1++) {
			for (int index2 = 0; index2 < polyTwo.getPolynomialArray().length; index2++) {
				int cofficient = polyOne.getPolynomialArray()[index1][0] * polyTwo.getPolynomialArray()[index2][0];
				int power = polyOne.getPolynomialArray()[index1][1] + polyTwo.getPolynomialArray()[index2][1];

				indexOfPower = returnIndex(multiplicationObj.getPolynomialArray(), power);
				if (indexOfPower != -1) {
					multiplicationObj.getPolynomialArray()[indexOfPower][0] += cofficient;
				} else if (cofficient != 0) {
					multiplicationObj.getPolynomialArray()[incrementIndex][0] = cofficient;
					multiplicationObj.getPolynomialArray()[incrementIndex][1] = power;
					incrementIndex++;
				}
			}
		}
		return multiplicationObj;
	}
	/**
	 * This method used to display polynomial
	 */
	public void displayPoly(){
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<polynomialArray.length-1; i++){
			if(polynomialArray[i][0]!=0){
				System.out.print(polynomialArray[i][0] + "x_" + polynomialArray[i][1] + " + ");
			}
		}
		if(polynomialArray[polynomialArray.length-1][0]!=0){
			System.out.println(polynomialArray[polynomialArray.length-1][0] + "x_" + polynomialArray[polynomialArray.length-1][1]);
		}
		System.out.println("----------------------------------------------------------");
	}
	
	/**
	 * This method used to get polynomialArray by other class
	 * @return polynomial Array for calling object
	 */
	public int[][] getPolynomialArray() {
		return polynomialArray;
	}
}