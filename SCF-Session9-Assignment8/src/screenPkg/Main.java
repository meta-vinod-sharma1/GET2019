package screenPkg;
import java.util.InputMismatchException;
import java.util.Scanner;

import shapePkg.Shape;

/**
 * This class used to operate IntSet class and it's methods it contains Menu class also
 * @author Vinod
 * @date 28/07/2019
 */
public class Main {
	
	public static void main(String[] args){
		Screen screenObj = new Screen();
		Shape shapeObj = null;
		Menu menuObj = new Menu();
		Input input = new Input();
		Scanner inputObj = new Scanner(System.in);
		int choice = 0;
		do{
			menuObj.shapeMenu();
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					menuObj.addMenu();
					int select = inputObj.nextInt();
					shapeObj = input.addInput(select);
					System.out.println("--------------------------------------------------------");
					if(screenObj.addShape(shapeObj) == true){
						System.out.println("Your shape is added Successfully ");
					}else{
						System.out.println("Failed");
					}
					System.out.println("--------------------------------------------------------");
					break;
				case 2:
					System.out.println("--------------------------------------------------------");
					if(screenObj.shapesOnScreen.size() == 0){
						System.out.println("No Shapes Yet");
					}else{
						System.out.println("Please Enter which Shape you want to delete");
						screenObj.Display(screenObj.shapesOnScreen);
						select = inputObj.nextInt();
						if(select > screenObj.shapesOnScreen.size()){
							System.out.println("Wrong Input");
						}else{
							screenObj.shapesOnScreen.remove(select-1);
							System.out.println("Removed Succsesfully");
						}
					}
					System.out.println("--------------------------------------------------------");
					break;
				case 3:
					System.out.println("--------------------------------------------------------");
					screenObj.Display(screenObj.shapesOnScreen);
					System.out.println("--------------------------------------------------------");
					break;
				case 4:
					System.out.println("--------------------------------------------------------");
					menuObj.sortMenu();
					select = inputObj.nextInt();
					if(select == 1){
						System.out.println("Before Short");
						screenObj.Display(screenObj.shapesOnScreen);
						System.out.println("After Short");
						screenObj.Display(screenObj.sortByArea());
					}else if(select == 2){
						System.out.println("Before Short");
						screenObj.Display(screenObj.shapesOnScreen);
						System.out.println("After Short");
						screenObj.Display(screenObj.sortByPerimeter());
					}else if(select == 3){
						System.out.println("Before Short");
						screenObj.Display(screenObj.shapesOnScreen);
						System.out.println("After Short");
						screenObj.Display(screenObj.sortByTimestamp());
					}else if(select == 4){
						System.out.println("Before Short");
						screenObj.Display(screenObj.shapesOnScreen);
						System.out.println("After Short");
						screenObj.Display(screenObj.sortByOriginDistance());
					}
					System.out.println("--------------------------------------------------------");
					break;
				case 5:
					System.out.println("--------------------------------------------------------");
					menuObj.addMenu();
					select = inputObj.nextInt();
					if(select ==1){
						if(screenObj.removeAllShapeOfType(Shape.ShapeType.SQUARE)){
							System.out.println("Removed Successfully");
						}
						else{
							System.out.println("Failed");
						}
						
					}else if(select == 2){
						if(screenObj.removeAllShapeOfType(Shape.ShapeType.RECTANGLE)){
							System.out.println("Removed Successfully");
						}else{
							System.out.println("Failed");
						}
					}else if(select == 3){
						if(screenObj.removeAllShapeOfType(Shape.ShapeType.CIRCLE)){
							System.out.println("Removed Successfully");
						}else{
							System.out.println("Failed");
						}
					}else if(select == 4){
						if(screenObj.removeAllShapeOfType(Shape.ShapeType.TRIANGLE)){
							System.out.println("Removed Successfully");
						}else{
							System.out.println("Failed");
						}
					}else if(select == 5){
						if(screenObj.removeAllShapeOfType(Shape.ShapeType.POLYGON)){
							System.out.println("Removed Successfully");
						}else{
							System.out.println("Failed");
						}
					}
					System.out.println("--------------------------------------------------------");
					break;
				case 6:
					break;
					default :
						System.out.println("--------------------------------------------------------");
						System.out.println("Invalid Chocie");
						System.out.println("--------------------------------------------------------");
				}		
				
			}catch(AssertionError e){
				System.out.println("Assertion Error : " + e);
				
			}catch(InputMismatchException e){
	
				System.out.println("--------------------------------------------------------");
				System.out.println("Warning : Please enter only integer value !! Try Again");
				System.out.println("--------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(choice!=6);

	}

}
