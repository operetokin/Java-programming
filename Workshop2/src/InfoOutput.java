import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class InfoOutput extends Account {
	
	public static void Output(){
	Account testobjs[] = new Account[100];
	
	File file = new File("ws2_accounts.txt");

	try {

		FileInputStream fis = new FileInputStream(file);

		ObjectInputStream ois = new ObjectInputStream(fis);

		int i = 0;
		
		 do{
		    testobjs[i] = (Account) ois.readObject();
		        if(testobjs[i] != null){
		        	System.out.println("\nDeserialization--Object #" + (i+1) + ":\n");
					System.out.println(testobjs[i].toString());
					i++;
		        } 
		 }
		 while (testobjs[i-1] != null);  
		
		 ois.close();
		 fis.close();
		 
	} catch (Throwable s) {
		System.err.println(s.getMessage());
	} 
	
	} 
	public static void main(String[] args) {	Output();	}
	
}

