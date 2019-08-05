package shapePkg;

import java.util.Date;

import screenPkg.Point;

/**
* This class defines function of regular polygon.
* @author Vinod
* 
*/
public class RegularPolygon implements Shape{

    private int noOfSides;
    private double lengthOfSide;
    Point originPointObj;
	private long timeStamp;
    
    public RegularPolygon(double noOfSides, double lengthOfSide, Date date, Point origin) {
        this.noOfSides = (int)noOfSides;
        this.lengthOfSide = lengthOfSide;
        this.originPointObj = origin;
        this.timeStamp = date.getTime();
    }
    
    @Override
    public double getArea()
    {
        double area = lengthOfSide*lengthOfSide *noOfSides / (4 * Math.tan(Math.toRadians(180 / noOfSides)));
        
        return area;
    }

    @Override
    public double getPermiter()
    {
        return noOfSides * lengthOfSide;
    }

    @Override
    public Point getOrigin()
    {
        return originPointObj;
    }

    @Override
    public boolean isPointEnclosed(Point givenPoint)
    {
        return false;
    }


    @Override
    public String getShapeType()
    {
        return "POLYGON";
    }
	
	@Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPointObj.x - 0) * (originPointObj.x - 0) + (originPointObj.y - 0) * (originPointObj.y - 0));
    }

	@Override
	public long getTime() {
		
		return timeStamp;
	}

}