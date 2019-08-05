package multivarPolyPkg;

/**
 * This class represents a single variable along with its power in a multivariable polynomial
 * @author Vinod
 * Dated 30/07/2019
 */
public class Variable {
	
	private char variable;
	private int variablePower;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param variable is the variable name(x or y or z or etc.)
	 * @param variablePower is the variable power
	 */
	Variable(char variable, int variablePower)
	{
		this.variablePower  = variablePower;
		this.variable = variable;
	}

	public char getVaribleName() {
		return variable;
	}
	public int getVariablePower() {
		return variablePower;
	}

}
