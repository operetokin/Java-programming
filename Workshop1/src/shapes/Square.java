package shapes;

public class Square extends Rectangle {
	public double side;
	Area getArea = (Square) -> Math.pow(this.side,2);
	
	public Square(double side) {
		super(side, side);
		this.side = side; 
	}
	
	public void setSide(double side){
		this.side = side;
	}
	
	public double getSide() {
		return this.side;
	}

	public double perimeter() {
		return super.perimeter();
	}
	
	public String toString() {
		return String.format("Square {s=" + getSide() + "} perimeter = "+ this.perimeter() + " area = " + getArea.findArea(side));
	}
}
