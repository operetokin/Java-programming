package account;
import java.util.Scanner;
import java.io.*;

public class Serialize
{
	
	public static void serialize(Account newAccount, String fileName, int accountNumber, String firstName, String lastName, double balance)
	{
		
		newAccount.setFirstName(firstName);
		newAccount.setLastName(lastName);
		newAccount.setAccountNumber(accountNumber);
		newAccount.setBalance(balance);
		
//	Scanner scan = new Scanner(System.in);
//	System.out.print("Enter first name: ");
//	newAccount.setFirstName(scan.nextLine());
//	System.out.print("Enter last name: ");
//	newAccount.setLastName(scan.nextLine());
//	System.out.print("Enter account number: ");
//	newAccount.setAccountNumber(scan.nextInt());
//	System.out.print("Enter balance: ");
//	newAccount.setBalance(scan.nextDouble());
	
	try
	{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(newAccount);
		oos.flush();
		fos.close();
		System.out.println("Successfully Serialized");
		
	}
	catch (Throwable e) {
		System.err.println(e);
	}
	}
}
