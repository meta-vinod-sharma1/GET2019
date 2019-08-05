package screenPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shapePkg.Shape;


public class Screen {
List<Shape> shapesOnScreen = new ArrayList<Shape>();
	
	/**
	 * adds shape on screen
	 * @param shapeObject
	 * @return true if shape is added else false
	 */
	public boolean addShape(Shape shapeObject) {
	    
	    try
        {
            if(shapeObject == null) {
                throw new AssertionError("Object is null! Cannot add!");
            }
            
            if(shapeObject.getOrigin().x < 0 || shapeObject.getOrigin().y < 0 || shapeObject.getOrigin().x > Point.XMAX || shapeObject.getOrigin().y > Point.YMAX) {
                throw new AssertionError("Origin Point not in screen.");
            }
        
            shapesOnScreen.add(shapeObject);
           
            return true;
        }
        catch(AssertionError error)
        {
            return false;
        }

	}
	
	/**
	 * remove all occurrences of given shape type
	 * @param type is the Shape Type
	 * @return true if all shapes are deleted else false
	 */
	public boolean removeAllShapeOfType(Shape.ShapeType type) {
	    if(type == null ) {
	        return false;
	    }
	    
	    boolean flag = false;
		for(int i = 0; i < shapesOnScreen.size(); i++) {
			if(shapesOnScreen.get(i).getShapeType() == type.toString()) {
				shapesOnScreen.remove(i);
				i--;
				flag = true;
			}
		}
		
		try
        {
            if(!flag)
                throw new AssertionError("No object of the given type!");
        }
        catch(AssertionError error)
        {
            return false;
        }
        
        return flag;
	}
	
	
	/**
     * sorts the list of objects in ascending order according to area
     * @return sortedList
     */
    public List<Shape> sortByArea()
    {
        
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByArea = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByArea, ShapeSort.sortByArea);
        
        return sortedListByArea;
    }
    
    /**
     * sorts the list of objects in ascending order according to perimeter
     * @return sortedList
     */
    public List<Shape> sortByPerimeter()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByPerimeter = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByPerimeter, ShapeSort.sortByPerimeter);
        
        return sortedListByPerimeter;
    }
    
    /**
     * sorts the list of objects in ascending order according to Origin Distance
     * @return sortedList
     */
    public List<Shape> sortByOriginDistance()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByOriginDistance = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByOriginDistance, ShapeSort.sortByOriginDistance);
        
        return sortedListByOriginDistance;
    }
    
    /**
     * sorts the list of objects in ascending order according to Origin Distance
     * @return sortedList
     */
    public List<Shape> sortByTimestamp()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        return shapesOnScreen;
    }
    
    public void Display(List<Shape> displayList){
		for(int index=0 ; index< displayList.size(); index++){
			System.out.println(" Shape " + (index+1) + " : " + displayList.get(index).getShapeType());
		}
    }


}
