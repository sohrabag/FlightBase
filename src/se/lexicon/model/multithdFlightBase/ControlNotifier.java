package se.lexicon.model.multithdFlightBase;

import java.util.GregorianCalendar;

import se.lexicon.model.Airplane1;

public class ControlNotifier implements Runnable {

    private Command command;
   
public ControlNotifier(Command command) {
		super();
		this.command = command;
	}

	@Override
	public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" Notifier started");
        try {
			Thread.sleep(120000);
			GregorianCalendar gc1 = new GregorianCalendar();
			gc1.setTime(command.getAirplane().getDepartureTime());
			gc1.add(GregorianCalendar.MINUTE, 2);
			command.getAirplane().setArrivalTime(gc1.getTime());
//			System.out.println(gc1.getTime());
	            synchronized (command) {
	            	command.setCommand(name+" Notifier work done");
	                //command.notify();
	                 command.notifyAll();
	//                 command.getAirplane().notifyAll();
				}
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        
        System.out.println("Flight : " +  command.getAirplane().getFlightNumber() + 
        		" Destination : " + command.getAirplane().getDestination() + 
        		" DepartureTime : " + command.getAirplane().getArrivalTime() + "\n");
        System.out.println("Airplane Landing " + "\n");

        System.out.println();
 	}

}
