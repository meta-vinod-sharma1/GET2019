package areaPkg;

public class Rectangle implements Shape{
	private double width;
	private double height;
	
	public void setDimension(){
		System.out.println("Enter width of rectangle :");
		this.width = inputObj.nextDouble();
		System.out.println("Enter height of rectangle :");
		this.height = inputObj.nextDouble();
	}
	public double getArea(){
		return width*height ;
	}

}
