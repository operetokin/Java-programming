package shapes;

public class Parallelogram implements Shapes {
	
	private double width;
	private double length;
	double area;
	
	public Parallelogram(double width, double height) {
		this.width = width;
		this.length = height;
		//System.out.println("Parallelogram constructor was called");
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return length;
	}

	public void setHeight(double height) {
		this.length = height;
	}
	
	@Override
	public double perimeter() {
		return (getWidth() + getHeight()) * 2;
	}

	@Override
	public String toString() {
		return String.format("Parallelogram {w=" + this.getWidth() + ", h=" + this.getHeight() + "} perimeter = "+ this.perimeter());
	}
}
