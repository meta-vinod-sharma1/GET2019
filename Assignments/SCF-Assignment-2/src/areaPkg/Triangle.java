package areaPkg;

public class Triangle implements Shape {
	private double base;
	private double height;
	public void setDimension(){
		System.out.println("Enter base of Triangle :");
		this.base = inputObj.nextDouble();
		System.out.println("Enter height of Triangle :");
		this.height = inputObj.nextDouble();
	}
	
	public double getArea(){
		return base*height/2;
	}
}
