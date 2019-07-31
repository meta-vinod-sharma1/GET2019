package multivarPolyPkg;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent a single term in multivariable polynomial with integer as its coefficient and Variable type list as its variables 
 * @author Vinod
 * Dated 30/07/2019
 */
public class Term {
	
	int coefficient;
	List<Variable> variableList = new ArrayList<>();

	/**
	 * Constructor to initialise the data members of the class
	 * @param coefficient is the term's coefficient
	 * @param variableList is list of variables in the term
	 */
	Term(int coefficient, List<Variable> variableList)
	{
		this.coefficient = coefficient;
		this.variableList = variableList;
	}
}
