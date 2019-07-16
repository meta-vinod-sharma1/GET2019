package areaPkg;
import java.util.*;

public class AreaMain {

	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		Rectangle rectangleObj = new Rectangle();
		Square squareObj = new Square();
		Circle circleObj = new Circle();
		Triangle triangleObj = new Triangle();
		Shape shapeObj;
		
		try{
			System.out.println("\n\t\t\tRectangel Area:");
			shapeObj = rectangleObj;
			shapeObj.setDimension();
			System.out.println("\t Area of Rectangle : " + shapeObj.getArea());
			
			System.out.println("\n\t\t\tSquare Area:");
			shapeObj = squareObj;
			shapeObj.setDimension();
			System.out.println("\t Area of Square : " + shapeObj.getArea());
			
			System.out.println("\n\t\t\tCircle Area:");
			shapeObj = circleObj;
			shapeObj.setDimension();
			System.out.println("\t Area of Circle : " + shapeObj.getArea());
			
			System.out.println("\n\t\t\tTriangle Area:");
			shapeObj = triangleObj;
			shapeObj.setDimension();
			System.out.println("\t Area of Triangle : " + shapeObj.getArea());

		}catch(InputMismatchException e){
			System.out.println("Please enter only numbers not characters");
		}catch(ArithmeticException e){
			System.out.println("Exception : " + e);
		}

	}

}
