package se.lexicon.model.multithdFlightBase;

import se.lexicon.model.Airplane1;
import se.lexicon.model.AirplaneImp1;

public class ControlNotifier implements Runnable {

//    private Command command;
	private Airplane1 airplane;
   
//public ControlNotifier(Command command) {
//		super();
//		this.command = command;
//	}
	public ControlNotifier(Airplane1 airplane) {
	super();
	this.airplane = airplane;
}

	@Override
	public void run() {
        String name = Thread.currentThread().getName();
        
        System.out.println(name+" Notifier started");
        try {
			Thread.sleep(1000);


//			System.out.println(gc1.getTime());
	            synchronized (airplane) {
//	            	command.setCommand(name+" Notifier work done");
	    	        System.out.println("Flight : " +  airplane.getFlightNumber() + 
	    	        		" Destination : " + airplane.getDestination() + 
	    	        		" Arrival Time : " + airplane.getArrivalTime() + "\n");
	                //command.notify();
	                // command.notifyAll();
	    	        airplane.notifyAll();
	                 }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        

        System.out.println("Airplane Landing " + "\n");

        System.out.println();
 	}

}
