package shapePkg;

import java.util.Date;

import screenPkg.Point;

public interface Shape {
	
	static enum ShapeType { SQUARE, RECTANGLE, CIRCLE, TRIANGLE, POLYGON }
	
	public double getArea();
	public double getPermiter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point givenPoint);
	public long getTime();
	public String getShapeType();
	public double getOriginDistance();
	

}
