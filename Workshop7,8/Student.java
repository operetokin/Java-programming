
public class Student {
	String firstName;
	String lastName;
	double grade;
	String department;
	
	public Student(String firstName, String lastName, double grade, String department){
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setGrade(double grade){
		this.grade = grade;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public String getName() {
		return (this.firstName + ' ' + this.lastName); 
	}
	
	public String toString() {
		return String.format("%-10s%-10s%-10.2f%s",this.getFirstName(),this.getLastName(),this.getGrade(),this.getDepartment());
	}
	
	public Boolean isEquals(Student one, Student two) {
		return one.equals(two);
	}
}
