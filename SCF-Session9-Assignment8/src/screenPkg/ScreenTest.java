package screenPkg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import shapePkg.Shape;

public class ScreenTest {
	
	Screen screenObject = new Screen();

	/**
     * test case for testing the various methods in Rectangle class
     */
    @SuppressWarnings("serial")
    @Test
    public void rectangleTest()
    {
        Shape rectangle = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        
        assertEquals(8.0, rectangle.getArea(), 0.01);
        assertEquals(12.0, rectangle.getPermiter(), 0.01);
        assertTrue(rectangle.isPointEnclosed(new Point(2, 2)));
        assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
   //   assertEquals(true, rectangle.isPointEnclosed(new Point(5, 5)));   // Negative Case
    }

    /**
     * test case for testing the various methods in Square class
     */
    @SuppressWarnings("serial")
    @Test
    public void squareTest()
    {
        Shape square = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        
        assertEquals(16.0, square.getArea(), 0.01);
        assertEquals(16.0, square.getPermiter(), 0.01);
        assertEquals(true,square.isPointEnclosed(new Point(2, 3)));
        assertFalse(square.isPointEnclosed(new Point(5, 5)));
      
    }
    
    
    /**
     * test case for testing the various methods in Triangle class
     */
    @Test
    public void triangleTest()
    {
        Shape triangle = ShapeFactory.createShape(Shape.ShapeType.TRIANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(3.0);}});
        assertEquals(6.0, triangle.getArea(), 0.001);
        assertEquals(12.0, triangle.getPermiter(), 0.001);
      //  assertTrue(triangle.isPointEnclosed(new Point(2, 1)));
      //  assertFalse(triangle.isPointEnclosed(new Point(5, 5)));
    }

    /**
     * test case for testing the various methods in Circle class
     */
    @Test
    public void circleTest()
    {
        Shape circle = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        //System.out.println(circle.getArea());
        assertEquals(50.24, circle.getArea(),0.001);
        assertEquals(25.12, circle.getPermiter(), 0.001);
        assertTrue(circle.isPointEnclosed(new Point(2, 1)));
        assertFalse(circle.isPointEnclosed(new Point(10, 5)));
    }

    @Test
    public void addShapeTest() {
        
        Shape shape1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertTrue(screenObject.addShape(shape1));
        
        Shape shape2 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(120, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertFalse(screenObject.addShape(shape2));
 
    }
    
    /**
     * test case to sort the shapes on screen according to area
     */
    @Test
    public void sortByAreaTest() {
        
        Shape shape1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        List<Shape> sortedShapeByArea = screenObject.sortByArea();
        assertEquals(sortedShapeByArea, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to Perimeter
     */
 
    @Test
    public void sortByPerimeterTest() {

        Shape shape1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        List<Shape> sortedShapeByPerimeter = screenObject.sortByPerimeter();
        assertEquals(sortedShapeByPerimeter, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    public void sortByTimeStampTest() {

        Shape shape1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screenObject.addShape(shape3);
        
        List<Shape> sortedShapeByTimestamp = screenObject.sortByTimestamp();
        assertEquals(sortedShapeByTimestamp, new ArrayList<Shape>(){{add(shape1); add(shape2); add(shape3);}}); 
    }

}
