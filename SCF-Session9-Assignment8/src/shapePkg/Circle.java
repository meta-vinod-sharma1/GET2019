package shapePkg;

import java.sql.Date;

import screenPkg.Point;

public class Circle implements Shape{
	
	public final double PI = 3.14;
	private double radius;
	private Point originPointObj ;
	private long timeStamp;

	public Circle(double radius, Point originPointObj, long timeStamp) {
		this.radius = radius;
		this.originPointObj = originPointObj;
		this.timeStamp = timeStamp;
	}

	@Override
	public double getArea() {
		
		return PI*radius*radius;
	}

	@Override
	public double getPermiter() {
		
		return 2*PI*radius;
	}

	@Override
	public Point getOrigin() {
		return originPointObj;
		
		
	}
	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		boolean flag = false;
		if(getDistance(originPointObj, givenPoint) < radius){
			flag = true;
		}
		return flag;
	}

	@Override
	public long getTime() {
		return timeStamp;
	}

	@Override
	public String getShapeType() {
		return "CIRCLE";
	}
	
	@Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPointObj.x - 0) * (originPointObj.x - 0) + (originPointObj.y - 0) * (originPointObj.y - 0));
    }
	
	/**
     * 
     * @param center
     * @param givenPoint
     * @return distance between center and given point
     */
    private double getDistance(Point center, Point givenPoint) {
    	//distance = square root of ((x2-x1)^2 + (y2-y1)^2)
    	return Math.sqrt((center.x - givenPoint.x) * (center.x - givenPoint.x) + (center.y - givenPoint.y) * (center.y - givenPoint.y));
    }

}
