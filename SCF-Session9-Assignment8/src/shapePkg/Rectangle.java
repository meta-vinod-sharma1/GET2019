package shapePkg;

import java.util.Date;

import screenPkg.Point;

public class Rectangle implements Shape{

	private double width;
	private double height;
	private Point originPointObj;
	private long timeStamp;

	public Rectangle(double width, double length, long timeStamp, Point originPointObj) {
		this.width = width;
		this.height = length;
		this.originPointObj = originPointObj;
		this.timeStamp = timeStamp;
	}

	@Override
	public double getArea() {
		
		return width*height;
	}

	@Override
	public double getPermiter() {
		
		return 2*(width + height);
	}

	@Override
	public Point getOrigin() {
		return originPointObj;
		
	}

	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		boolean flag = false;
		if(givenPoint.x < (originPointObj.x + width)  && givenPoint.y < (originPointObj.y + height)){
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
		return "RECTANGLE";
	}
	
	@Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPointObj.x - 0) * (originPointObj.x - 0) + (originPointObj.y - 0) * (originPointObj.y - 0));
    }


}
