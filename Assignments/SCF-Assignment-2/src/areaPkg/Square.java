package areaPkg;

public class Square implements Shape {
	
	private double length;
	
	public void setDimension(){
		System.out.println("Enter length of Square :");
		this.length = inputObj.nextDouble();
	}
	
	public double getArea(){
		return length*length;
	}

}
