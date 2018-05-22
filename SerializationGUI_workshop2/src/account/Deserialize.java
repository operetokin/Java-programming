package account;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Deserialize 
{
	static Account accountToDeserialize = null;
	public static Account deserialize(String fileName)
	{
		try
		{
			FileInputStream fos = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fos);
			accountToDeserialize = (Account)ois.readObject();
			System.out.println("first name: " + accountToDeserialize.getFirstName());
			System.out.println("last name: " + accountToDeserialize.getLastName());
			System.out.println("Account Number: " + accountToDeserialize.getAccountNumber());
			System.out.println("Balance: " + accountToDeserialize.getBalance());
			ois.close();
		}
		catch (Throwable e) {
			System.err.println(e);
		}
		return accountToDeserialize;
	}
}
