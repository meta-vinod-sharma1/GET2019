package shapePkg;

import java.sql.Date;

import screenPkg.Point;

public class Square implements Shape{

	private double length;
	private Point originPointObj;
	private long timeStamp;

	public Square(double length, long timeStamp, Point originPoint) {
		this.length = length;
		this.originPointObj = originPoint;
		this.timeStamp = timeStamp;
		
	}

	@Override
	public double getArea() {
		
		return length*length;
	}

	@Override
	public double getPermiter() {
		
		return 4*length;
	}

	@Override
	public Point getOrigin() {
		
		return originPointObj;
		
	}

	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		boolean flag = false;
		if(givenPoint.x < (originPointObj.x + length) && givenPoint.y < (originPointObj.y + length)){
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
		return "SQUARE";
	}
	
	@Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPointObj.x - 0) * (originPointObj.x - 0) + (originPointObj.y - 0) * (originPointObj.y - 0));
    }
	
	

}
