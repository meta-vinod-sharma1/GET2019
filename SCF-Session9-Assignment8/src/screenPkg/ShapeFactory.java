package screenPkg;

import java.util.ArrayList;
import java.util.Date;

import shapePkg.Circle;
import shapePkg.Rectangle;
import shapePkg.RegularPolygon;
import shapePkg.Shape;
import shapePkg.Square;
import shapePkg.Triangle;
/**
* This class creates object for various shape class.
* @author Mahendar Singh
* 
*/
public class ShapeFactory
{

    /**
     * creates shape of given type with given values
     * @param shape
     * @param originPoint
     * @param parameters
     * @return object of shape type
     */
    public static Shape createShape(Shape.ShapeType shape, Point originPoint, ArrayList<Double> parameters) {
        
    	Date date = new Date();
    	long timeStamp = date.getTime();
    	Shape shapeObject = null;
    	
        switch(shape) {
        case SQUARE:
        	shapeObject = new Square(parameters.get(0), timeStamp, originPoint);
        	break;
        
        case RECTANGLE:
        	shapeObject = new Rectangle(parameters.get(0),parameters.get(1), timeStamp, originPoint);
        	break;
        	
        case CIRCLE:
        	shapeObject = new Circle(parameters.get(0),  originPoint, timeStamp);
        	break;
        	
        case TRIANGLE:
        	shapeObject = new Triangle(parameters.get(0), parameters.get(1), originPoint, timeStamp);
        	break;
        	
        case POLYGON:
            shapeObject = new RegularPolygon(parameters.get(0), parameters.get(1), date, originPoint);
            break;
            
        default:
            System.out.println("Wrong shape passed");
            break;
        }
        
        return shapeObject;
    }
}