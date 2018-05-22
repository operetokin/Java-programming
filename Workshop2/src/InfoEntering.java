import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class InfoEntering extends Account {
	public static Account[] testobjs = new Account[100];
	public int i = 0;
	public static int number = 0;
	
	public static void Recording() {
		int acc = 0;
		String fName = "0";
		String lName = "0";
		double bal = 0;
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of accounts:\n");
		number = Integer.valueOf(scanner.nextLine());
		
		for(int i = 0; i < number; i++) {
			System.out.println("Enter account number for account object:\n");
			acc = Integer.valueOf(scanner.nextLine());
			
			System.out.println("first name:\n");
			fName=scanner.nextLine();
			
			System.out.println("last name:\n");
			lName=scanner.nextLine();
			
			System.out.println("balance:\n");
			bal = Double.valueOf(scanner.nextLine());
			
			testobjs[i] = new Account(acc,fName,lName,bal);
		}
		
		try {

			FileOutputStream fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for(int i = 0; i < number; i++) {
				
				oos.writeObject(testobjs[i]);
				System.out.println("\nSerialized object number " + (i+1) + ":\n");
				System.out.println(testobjs[i].toString());
			}
			
			oos.flush();
			fos.close();
			
		} catch (Throwable e) {
			System.err.println(e);
		}
		
	}
//public static void main(String[] args) {	Recording();	}
}

