package session2Pkg.stackPkg;

import java.util.HashMap;
/**
 * This class have methods which can be used for convert infix expression to postfix expression and Postfix expression evaluation 
 * @author Vinod
 * @date 01/08/2019
 */
public class ExpressionEvalute {
	
	//HashMap which contains Operators as Key and precedence as Value
	static  HashMap<String, Integer> map = new HashMap<>(); 
	//Static block 
	static {
		map.put("(",-8 );
		map.put(")",-8 );
		map.put("!",7 );
		map.put("*", 6);
		map.put("/",6 );
		map.put("+", 5);
		map.put("-",5 );
		map.put(">", 4);
		map.put(">=",4 );
		map.put("<", 4);
		map.put("<=",4 );
		map.put("&&", 3);
		map.put("||",2 );	
	} 
	
	/**
	 * This method used to convert an infix expression to postfix expression
	 * @param expression Expression which be converted infix to postfix
	 * @return String of Postfix expression
	 */
	public String infixToPostfix(String expression){
		String postfixString = "";
		Stack stackObj = new StackOperate();

		String[] arrOfExpression = expression.split(" ");

		for(int index=0; index< arrOfExpression.length; index++){

			// if arr[index] is not operand then it goes into this if
			if(map.containsKey(arrOfExpression[index])){
				if(arrOfExpression[index].equals("(")){
					stackObj.push(arrOfExpression[index]);  
				}else if(arrOfExpression[index].equals(")")){
					while(!stackObj.isEmpty() && !stackObj.peek().equals("(")){
						postfixString += stackObj.pop() + " ";
					}
					if(!stackObj.isEmpty() && !stackObj.peek().equals("(")){
						return null;
					}
					stackObj.pop();
				}else{ // if arr[index] contains operator
					while(!stackObj.isEmpty() && map.get(arrOfExpression[index]) <= map.get(stackObj.peek())){
						if(stackObj.peek().equals("(")){
							return null;
						}
						postfixString += stackObj.pop() + " ";
					}
					stackObj.push(arrOfExpression[index]);	
				}
			}else{ // if operand is coming we will add directly
				postfixString += arrOfExpression[index] + " ";
			}
		}
		
		while(!stackObj.isEmpty()){
			if(stackObj.peek().equals("(")){
				return null;
			}
			postfixString += stackObj.pop() + " ";
		}
		return postfixString;
	}
	
	/**
	 * This method used to evaluate postfix Expression
	 * @param expression postfix expression which have to evaluate
	 */
	public void postfixEvalute(String expression){
		Stack stackObj = new StackOperate();
		int resultOperands;
		boolean flag = false;
		String[] arr = expression.split(" ");

		for(int index=0; index< arr.length; index++){
			if(map.containsKey(arr[index])){
				if(arr[index].equals("<") || arr[index].equals(">") || arr[index].equals("<=") || arr[index].equals(">=")){
					flag = true;
				}
				int operand2 = Integer.parseInt(stackObj.pop());
				int operand1 = Integer.parseInt(stackObj.pop());
				resultOperands = evaluate(operand1, operand2, arr[index]);
				stackObj.push(Integer.toString(resultOperands));


			}else{
				stackObj.push(arr[index]);
			}
		}
		if(flag == true){
			if(stackObj.peek().equals("1")){
				System.out.println(" Your Output : True" );
			}else{
				System.out.println(" Your Output : False" );
			}
		}else{
			System.out.println(" Your Output : " + stackObj.peek());
		}

		stackObj.pop();
	}

	/**
	 * This method used to compute two values with Operator
	 * @param operand1 
	 * @param operand2
	 * @param operator
	 * @return return evaluated value 
	 */
	private int evaluate(int operand1, int operand2, String operator) {
		switch (operator) {
		case "+":
			return operand1 + operand2;

		case "-":
			return operand1 - operand2;

		case "*":
			return operand1 * operand2;

		case "/":
			return operand1 / operand2;

		case ">":
			return (operand1 > operand2 ) ? 1 : 0;

		case "<":
			return (operand1 < operand2 ) ? 1 : 0;

		case ">=":
			return (operand1 >= operand2 ) ? 1 : 0;

		case "<=":
			return (operand1 <= operand2 ) ? 1 : 0;
		}
		return Integer.MIN_VALUE;
	}
}
