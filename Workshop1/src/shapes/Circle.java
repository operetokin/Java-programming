package shapes;

public class Circle implements Shapes  {
	double radius;
	Area getArea = (Circle) -> Math.PI * Math.pow(this.radius,2); //use lambda with (...)
	
	public Circle(double radius) {
		this.radius = radius;
		//System.out.println("Circle constructor was called");
	}

	public double perimeter() {
		return 2*Math.PI*this.radius;
	}
	
	
	
	public double getRadius() {return this.radius;}
	
	public String toString() {
		return String.format("Circle {r=" + getRadius() + "} perimeter = " + perimeter() + " area = " + this.getArea.findArea(radius));
	}
}
