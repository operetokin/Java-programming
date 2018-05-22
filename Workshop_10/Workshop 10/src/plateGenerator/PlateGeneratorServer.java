package plateGenerator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PlateGeneratorServer {
	public PlateGeneratorServer()
	{
		try
		{
			PlateGeneratorInterface server = new PlateGenerator();
			Registry registry = LocateRegistry.createRegistry(2020);
			registry.rebind("CarRegistration", server);
			System.out.println("Server is running...");
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
			
	}
	
	public static void main(String args[])
	{
		new PlateGeneratorServer();
	}
}
