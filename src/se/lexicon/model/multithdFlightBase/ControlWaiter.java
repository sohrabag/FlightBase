package se.lexicon.model.multithdFlightBase;

import se.lexicon.model.Airplane1;

public class ControlWaiter implements Runnable {

//    private Command command;
	private Airplane1 airplane;
    
    public ControlWaiter(Airplane1 airplane) {
		super();
		this.airplane = airplane;
	}

	@Override
	public void run() {
       String name = Thread.currentThread().getName();

       synchronized (airplane) {
		    try{
		        System.out.println(name+" waiting to get notified at time: "+ airplane.getDepartureTime());
		        System.out.println("Airplane taking off" + "\n");
		        System.out.println("Flight : " +  airplane.getFlightNumber() + 
		        		" Destination : " + airplane.getDestination() + 
		        		" DepartureTime : " + airplane.getDepartureTime() + "\n");
		        
		        airplane.wait();
		    }catch(InterruptedException e){
		        e.printStackTrace();
		    }
		    //process the message now
		    System.out.println(name+" processed: "+ airplane.getFlightNumber());
		    }
		}

}
