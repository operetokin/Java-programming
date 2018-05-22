package plateGeneratorClient;

import java.rmi.Naming; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import plateGenerator.Car;
import plateGenerator.PlateGeneratorInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 


public class plateGeneratorClient {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Car carToRegister = new Car();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Make: ");
		carToRegister.setMake(scan.nextLine());
		System.out.print("Enter Model: ");
		carToRegister.setModel(scan.nextLine());
		System.out.print("Enter Mileage: ");
		carToRegister.setMileage(scan.nextDouble());
		System.out.println("Unregistered Car Info:");
		System.out.println(carToRegister.toString());
		System.out.println("Sending an object to a server to assign a license plate...");
		
		scan.close();
		
		try {
				Registry registry = LocateRegistry.getRegistry(2020);
				PlateGeneratorInterface plateGenerator = (PlateGeneratorInterface) registry.lookup("CarRegistration");
				carToRegister = plateGenerator.setLicensePlate(carToRegister);
				System.out.println("Registered Car Info: ");
				System.out.println(carToRegister.toString() + "License Plate: " + carToRegister.getLicensePlate());
				
			
		}
			catch (RemoteException re) { 
				System.out.println(); 	
				System.out.println( 								"RemoteException"); 
				System.out.println(re); 
			} 
			catch (NotBoundException nbe) { 
				System.out.println();
				System.out.println( "NotBoundException"); 
				System.out.println(nbe); 
			} 
			catch (java.lang.ArithmeticException ae) { 
				System.out.println(); 
				System.out.println( "java.lang.ArithmeticException"); 
				System.out.println(ae); 
			}
			
			} 


	}

