package shapePkg;

import java.sql.Date;

import screenPkg.Point;

public class Triangle implements Shape{

	private double height;
	private Point originPointObj;
	private double base;
	private double side2;
	private double side3;
	private long timeStamp;

	public Triangle(double base, double height, Point originPointObj, long timeStamp) {
		this.height = height;
		this.base = base;
		this.side2 = side2;
		this.side3 = side3;
		this.originPointObj = originPointObj;
		this.timeStamp = timeStamp;
	}

	@Override
	public double getArea() {
		
		return base*height/2;
	}

	@Override
	public double getPermiter() {
		
		return base + height + Math.sqrt(base*base + height * height);
	}

	@Override
	public Point getOrigin() {
		return originPointObj;
	}

	@Override
	public boolean isPointEnclosed(Point givenPoint) {

		return false;
	}

	@Override
	public long getTime() {
		return timeStamp;
	}

	@Override
	public String getShapeType() {
		return "TRIANGLE";
	}
	
	@Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPointObj.x - 0) * (originPointObj.x - 0) + (originPointObj.y - 0) * (originPointObj.y - 0));
    }

}
