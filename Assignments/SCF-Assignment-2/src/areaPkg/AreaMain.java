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
		int choice = 0;
		try{
			do{
				System.out.println("Enter Your choice");
				System.out.println("1.Rectangel Area\n2.Square Area\n3.Circle Area\n4.Triangle Area\n5.Exit");
				choice= inputObj.nextInt();
				switch(choice){
				case 1:
					shapeObj = rectangleObj;
					shapeObj.setDimension();
					System.out.println("\t Area of Rectangle : " + shapeObj.getArea());
					break;
				case 2:
					shapeObj = squareObj;
					shapeObj.setDimension();
					System.out.println("\t Area of Square : " + shapeObj.getArea());
					break;
				case 3:
					shapeObj = circleObj;
					shapeObj.setDimension();
					System.out.println("\t Area of Circle : " + shapeObj.getArea());
					break;
				case 4:
					shapeObj = triangleObj;
					shapeObj.setDimension();
					System.out.println("\t Area of Triangle : " + shapeObj.getArea());
					break;
				case 5:
					break;
				default :
					System.out.println(" Invali Choice !!");
				}
			}while(choice!=5);
		
		}catch(InputMismatchException e){
			System.out.println("Please enter only Integer Values !! Try Again");
			main(args);
		}catch(ArithmeticException e){
			System.out.println("Exception : " + e);
		}

	}

}
