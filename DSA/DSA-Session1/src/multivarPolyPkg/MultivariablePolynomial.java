package multivarPolyPkg;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a multivariable polynomial using nested lists
 * @author Vinod
 * Dated 30/07/2019
 */
public class MultivariablePolynomial {
	
	List<Term> multivariablePolynomialList = new ArrayList<>();
	
	public MultivariablePolynomial(List<Term> termList) {
		
		this.multivariablePolynomialList = termList;
	}
	
	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * @return {int} degree of the multivariable polynomial
	 */
	int calculatePolynomialDegree()
	{
		int highestDegree = 0;
		for(int index1=0; index1<multivariablePolynomialList.size(); index1++){
			int degree = 0;
			for(int index2=0; index2<multivariablePolynomialList.get(index1).variableList.size(); index2++){
				degree += multivariablePolynomialList.get(index1).variableList.get(index2).getVariablePower();
			}
			if(degree > highestDegree){
				highestDegree = degree;
			}
		}
		return highestDegree;
	}
	
	/**
	 * This method visualises the Multivariable polynomial into string
	 * @return {String} Multivariable Polynomial
	 */
	String visualiseMultivariablePolynomial()
	{
		String polynomialString = "";
		for(int index1=0; index1<multivariablePolynomialList.size(); index1++){
			polynomialString = polynomialString + multivariablePolynomialList.get(index1).coefficient;
			for(int index2=0; index2<multivariablePolynomialList.get(index1).variableList.size(); index2++){
				polynomialString = polynomialString + "*" + multivariablePolynomialList.get(index1).variableList.get(index2).getVaribleName()
						+ "^" + multivariablePolynomialList.get(index1).variableList.get(index2).getVariablePower();
			}
			if(index1 < multivariablePolynomialList.size()-1){
				polynomialString +=  " + ";
			}
		}
		return polynomialString;
	}

}
