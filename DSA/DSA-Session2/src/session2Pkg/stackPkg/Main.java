package session2Pkg.stackPkg;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is Main Class which give you options to evaluate an Expression
 * @author Vinod
 * @date 01/08/2019
 */
public class Main {
	private static String VIEW = "--------------------------------------------------------------------------------------------";
	public static void main(String[] args){
		Scanner inputObj= new Scanner(System.in);	
		ExpressionEvalute evaluateObj = new ExpressionEvalute();
		String expression = null;
		int choice =0;
		do{
			try{
				System.out.println("Enter Your Choice\n1.Evaluate Expression\n2.Get Postfix Expression\n3.Exit");
				choice = inputObj.nextInt();
				System.out.println(VIEW);
				switch(choice){
					case 1:
						System.out.println("Enter Expression");
						inputObj.nextLine();
						expression = inputObj.nextLine();
						String postfixExpression = evaluateObj.infixToPostfix(expression);
						System.out.println(VIEW);
						if(postfixExpression == null){
							System.out.println("Invalid Expression");
						}else{
							evaluateObj.postfixEvalute(postfixExpression);
						}
						break;
					case 2 :
						System.out.println("Post fix Expression : " + evaluateObj.infixToPostfix(expression) );
						break;
					case 3:
						break;
						default :
							System.out.println("Invalid Choice");
				}
				System.out.println(VIEW);
			}catch(InputMismatchException e){
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println(VIEW);
				inputObj.nextLine();
			}
			
		}while(choice != 3);
	}
}
