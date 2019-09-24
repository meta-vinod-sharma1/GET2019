package shapePkg;

import java.sql.Date;

import screenPkg.Point;

public class Triangle implements Shape{

	private double side1;
    private double side2;
    private double side3;
    private double height;
    private long timeStamp;
    private Point originPoint;
    
    public Triangle(double side1, double side2, double side3, double height, long timeStamp, Point originPoint)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
        this.timeStamp = timeStamp;
        this.originPoint = originPoint;
    }

    @Override
    public double getArea() {
        return (side1 * height) / 2;
    }

    @Override
    public double getPermiter() {
        return (side1 + side2 + side3);
    }

	@Override
    public Point getOrigin() {
        return originPoint;
    }

	@Override
	public boolean isPointEnclosed(Point givenPoint) {

	    boolean enclosed = false;
        double base = Math.sqrt(Math.pow(side3, 2) - Math.pow(height, 2));
        Point b = new Point(originPoint.x + side1, originPoint.y);
        Point c = new Point(originPoint.x + base, originPoint.y + height);
                
        if(Math.abs(getArea() - ((getAreaByVertices(givenPoint, originPoint, b)) + getAreaByVertices(givenPoint, b, c) + getAreaByVertices(givenPoint, originPoint, c))) <= 0.001)
            enclosed = true;        
        
        return enclosed;
        
	}

	@Override
	public double getOriginDistance() {		
		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
	}
	
	@Override
    public long getTime() {
    	return timeStamp;
    }
	@Override
	public String getShapeType() {
		return "TRIANGLE";
	}
	
	/**
	 * 
	 * @param a is points of vertex A.
	 * @param b is points of vertex B.
	 * @param c is points of vertex C.
	 * @return area of triangle ABC with given points a, b, c.
	 */
	private double getAreaByVertices(Point a, Point b, Point c)
    {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    } 
}
