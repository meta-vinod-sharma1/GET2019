package screenPkg;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import shapePkg.Shape;

public class Input {
	Scanner inputObj = new Scanner(System.in);


	public Shape addInput(int choice){
		try{
			if(choice == 1){
				System.out.println("Please enter length of Square");
				double length = inputObj.nextInt();
				System.out.println("Please Enter Points for Origin");
				System.out.println("Xaxis : ");
				int x = inputObj.nextInt();
				System.out.println("Yaxis");
				int y = inputObj.nextInt();
				return ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(x, y), new ArrayList<Double>(){{add( length);}});
				
			}else if(choice == 2){
				System.out.println("Please enter width of Rectangle");
				double width = inputObj.nextInt();
				System.out.println("Please enter Height of Rectangle ");
				double height = inputObj.nextInt();
				System.out.println("Please Enter Points for Origin");
				System.out.println("Xaxis : ");
				int x = inputObj.nextInt();
				System.out.println("Yaxis");
				int y = inputObj.nextInt();
				return ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(x, y), new ArrayList<Double>(){{add(width); add(height);}});
				
			}else if(choice == 3){
				System.out.println("Please enter radius of Circle");
				double radius = inputObj.nextInt();
				System.out.println("Please Enter Points for Origin");
				System.out.println("Xaxis : ");
				int x = inputObj.nextInt();
				System.out.println("Yaxis");
				int y = inputObj.nextInt();
				return ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(x, y), new ArrayList<Double>(){{add(radius);}});
			}else if(choice == 4){
				System.out.println("Please enter base");
				double base = inputObj.nextDouble();
				System.out.println("Please enter height");
				double height = inputObj.nextDouble();
				System.out.println("Please Enter Points for Origin");
				System.out.println("Xaxis : ");
				int x = inputObj.nextInt();
				System.out.println("Yaxis");
				int y = inputObj.nextInt();
				return ShapeFactory.createShape(Shape.ShapeType.TRIANGLE, new Point(x, y), new ArrayList<Double>(){{ add(base); add(height);}});
			}else if(choice == 5){
				System.out.println("Please enter No of Sides of Polygon");
				double noOfsides = inputObj.nextInt();
				System.out.println("Please enter length of Side ");
				double length = inputObj.nextInt();
				System.out.println("Please Enter Points for Origin");
				System.out.println("Xaxis : ");
				int x = inputObj.nextInt();
				System.out.println("Yaxis");
				int y = inputObj.nextInt();
				return ShapeFactory.createShape(Shape.ShapeType.POLYGON, new Point(x, y), new ArrayList<Double>(){{add(noOfsides); add(length);}});
			}
			
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			addInput(choice);
		}
		return null;
	}

}
