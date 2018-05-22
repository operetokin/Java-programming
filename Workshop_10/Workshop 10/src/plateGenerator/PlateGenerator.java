package plateGenerator;

import java.rmi.RemoteException;


public class PlateGenerator extends java.rmi.server.UnicastRemoteObject implements PlateGeneratorInterface {


	PlateGenerator() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car setLicensePlate(Car car) throws RemoteException {
		// TODO Auto-generated method stub
		car.setLicensePlate(car.hashCode());
		return car;

	}

}
