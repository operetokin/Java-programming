package plateGenerator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlateGeneratorInterface extends Remote {
		public Car setLicensePlate(Car car) throws RemoteException;
}
