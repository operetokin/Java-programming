package shapes;

public class Rectangle extends Parallelogram {
	
	public Rectangle(double width, double height) {
		super(width, height);
	}
	
	Area getArea = (Rectangle) -> this.getWidth()*this.getHeight();
	
	public double perimeter() {
		return super.perimeter();
	}
	
	public String toString() {
		return String.format("Rectangle {w=" + this.getWidth() + ", h=" + this.getHeight() + "} perimeter = "+ this.perimeter() + " area = " + this.getArea.findArea(Rectangle));
	}
}

