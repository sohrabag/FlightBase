package se.lexicon.model.multithdFlightBase;

import java.util.GregorianCalendar;
import java.util.List;

import se.lexicon.model.Airplane1;

public class ControlWaiter implements Runnable {

    private Command command;
    
    public ControlWaiter(Command command) {
		super();
		this.command = command;
	}

	@Override
	public void run() {
       String name = Thread.currentThread().getName();

       synchronized (command) {
		    try{
		    	GregorianCalendar gc = new GregorianCalendar();
		        System.out.println(name+" waiting to get notified at time: "+ gc.getTime());
		        System.out.println("Airplane taking off" + "\n");
		        System.out.println("Flight : " +  command.getAirplane().getFlightNumber() + 
		        		" Destination : " + command.getAirplane().getDestination() + 
		        		" DepartureTime : " + command.getAirplane().getDepartureTime() + "\n");
		        command.wait();
//		        command.getAirplane().wait();
		    }catch(InterruptedException e){
		        e.printStackTrace();
		    }
		    //process the message now
		    System.out.println(name+" processed: "+command.getCommand());
		    }
		}

}
