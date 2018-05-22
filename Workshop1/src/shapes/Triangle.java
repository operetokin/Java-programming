package shapes;

public class Triangle implements Shapes {
	public double x;
	public double y;
	public double z;
	
	Area3 getArea = (a, b, c) -> Math.sqrt((a+b+c)/2*((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c));

	public Triangle(double x, double y, double z) throws TriangleException{
		if(x > 0 && y > 0 && z > 0 && x + y > z && x + z > y && z + y > x) {
					this.x = x;
					this.y = y;
					this.z = z;
				}
				else
					throw new TriangleException("Invalid side(s)!");
	}

	public double perimeter() {return x+y+z;}

	public double getx() {return x;}

	public double gety() {return y;}

	public double getz() {return z;}
	
	public String toString() {
		return String.format("Triangle {s1=" + this.getx() + ", s2=" + this.gety() + ", s3=" + this.getz() + "} perimeter = "+ this.perimeter() + " area = " + this.getArea.findArea(getx(), gety(), getz()));
	}
	
}
