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
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (command) {
            	GregorianCalendar gc = new GregorianCalendar();
            	gc.setTime(command.getAirplane().getArrivalTime());
            	gc.add(GregorianCalendar.MINUTE, 2);
				System.out.println(gc.getTime());
				
            	command.setCommand(name+" Notifier work done");
                //command.notify();
                 command.notifyAll();
			}
//            synchronized (command) {
//            	command.setCommand(name+" Notifier work done");
//                //command.notify();
//                 command.notifyAll();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 	}

}
