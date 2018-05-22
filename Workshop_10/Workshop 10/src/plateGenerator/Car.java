package plateGenerator;

import java.io.Serializable;

public class Car implements Serializable
{
	private String model;
	private String make;
	private double mileage;
	private int licensePlate;
	
	public Car()
	{
		
	}
	
	public Car(String model, String make, double mileage)
	{
		this.model = model;
		this.make = make;
		this.mileage = mileage;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public int getLicensePlate() {
		return licensePlate;
	}
	
	public String toString()
	{
		return "Make: " + this.getMake() + "\n" + "Model: " + this.getModel() + "\n" + "Mileage: " + this.getMileage() + "\n";
	}

	public void setLicensePlate(int licensePlate) {
		this.licensePlate = licensePlate;
		// TODO Auto-generated method stub
		
	}
	

}
