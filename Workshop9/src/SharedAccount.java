/** This program tests multiple threads modifying a shared resource.*/
public class SharedAccount {
	public static void main(String[] args) {
		/*if (args.length == 0) {
			System.out.println("usage: java SharedResource <number of resources>");
			System.exit(0);
		}*/	

		double [] dollar_euro_pound1  = {1,2,3};
		double [] dollar_euro_pound2  = {0,0,0};
		double balance = 0.0;
		/*try {
			numberOfResources = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) { 
			System.out.println("String: <" + args[0] + "> must be an integer number.");
		}*/

		Container container = new Container();//The shared container containing a shared int
		
		ProduceResource p = new ProduceResource(container, balance, dollar_euro_pound1);
		ConsumeResource c = new ConsumeResource(container, balance, dollar_euro_pound2);
		
		p.start();
		c.start();
	}
}

/** Definition of a Thread class ProduceResource */
class ProduceResource extends Thread {
	private Container pHold;
	private double [] numberOfResources;
	private double newBalance1;
	
	public ProduceResource(Container c, double n, double [] array1) {
		super("Producer of Resource");
		pHold = c;
		newBalance1 = n;
		System.arraycopy(array1, 0, numberOfResources, 0, array1.length);
	}
	
	public void run() {
		for (int count = 0; count < numberOfResources.length; count++) {
			// sleep for a random interval
			try {
				Thread.sleep( (int) ( Math.random() * 3000 ) );
			} catch(InterruptedException e) {
				System.err.println(e.toString());
			}
			
			pHold.setSharedResource(numberOfResources[count]);
		}

	}
}

/** Definition of a Thread class ConsumeResource */
class ConsumeResource extends Thread {
	private Container cHold;
	private double [] numberOfResources;
	private double newBalance2;

	public ConsumeResource(Container c, double m, double [] array2) {
		super("Consumer of Resource");
		cHold = c;
		newBalance2 = m;
		System.arraycopy(array2, 0, numberOfResources, 0, array2.length);
	}
	
	public void run() {
		int val;
		for (int count = 0; count < numberOfResources.length; count++) {
			// sleep for a random interval
			try {
				Thread.sleep( (int) ( Math.random() * 3000 ) );
			} catch(InterruptedException e) {
				System.err.println(e.toString());
			}
			numberOfResources[count] = cHold.getSharedResource();
		} 

	}
}

/** Definition of a Container */
class Container {
	private double sharedDouble = 0.0;
	private boolean writeable = true;  // condition variable

	/** synchronized method for setting the resource:
	The code in the get method loops until the Producer has produced a new value. 
	Each time through the loop, the get method calls the wait method; 
	The wait method relinquishes the lock held by the Consumer on the Container
	(thereby allowing the Producer to get the lock and update the Container)
	and then waits for notification from the Producer.*/
	public synchronized void setSharedResource(double val) {
		while (!writeable) {  // not the producer's turn
			try { 
				System.out.println("Waiting for Consumer...");
				wait();  
			} catch ( InterruptedException e ) { 
				e.printStackTrace();
			}
		}

		System.err.println( Thread.currentThread().getName() +
				" generates Resource = " + val );
		sharedDouble = val;
		writeable = false;
		notify();  // tell a waiting thread to become ready
	}

	/** synchronized method for getting the resource:
	When the Producer puts something in the Container, 
    it notifies the Consumer by calling notifyAll. 
    The Consumer then comes out of the wait state, the loop exits, 
    and the get method returns the value in the Container. 
    The set method works in a similar fashion, waiting for the Consumer thread to consume 
    the current value before allowing the Producer to produce a new one.*/
	public synchronized double getSharedResource() {
		while (writeable) {   // not the consumer's turn
			try { 
				System.out.println("Waiting for Producer...");
				wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		
		writeable = true;
		notify();  // tell a waiting thread to become ready
		System.err.println( Thread.currentThread().getName() +
				" uses Resource = " + sharedDouble + "\n");
		return sharedDouble;
	}
}