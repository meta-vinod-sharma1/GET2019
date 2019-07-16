package areaPkg;

public class Circle implements Shape{
	private double radius;
	public void setDimension(){
		System.out.println("Enter Radius of Circle :");
		this.radius = inputObj.nextDouble();
	}
	
	public double getArea(){
		return 2*pi*radius*radius;
	}

}
