import java.io.File;

public class Account implements java.io.Serializable {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	public static File file = new File("ws2_accounts.txt");
	
	public Account() {
		this.account = 0;
		this.firstName = "Unknown";
		this.lastName = "Unknown";
		this.balance = 0.0;
	}
	
	public Account(int account, String firstName, String lastName, double balance){
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	int getAccount(){
		return this.account;
	}
	
	String getFirstName() {
		return this.firstName;
	}
	
	String getLastName() {
		return this.lastName;
	}
	
	double getBalance() {
		return this.balance;
	}
	
	void setBalance(double balance){
		this.balance = balance;
	}
	
	public String toString() {
		return "Account:" + getAccount() + "\nFirst name: " + getFirstName() 
		+ "\nLast name: " + getLastName() + "\nBalance: " + getBalance();
	}
	
}
