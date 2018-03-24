package se.lexicon.model.multithdFlightBase;

import java.util.List;

import se.lexicon.model.Airplane1;

public class FlightControl {

	List<Airplane1> airplaneList;
	
	public FlightControl(List<Airplane1> airplaneList) {
		super();
		this.airplaneList = airplaneList;
	}

	Command command;
	
	public FlightControl(Command command) {
	super();
	this.command = command;
}
	
	public void Control() {

		Command command1 = new Command("process it", airplaneList.get(0));
		Command command2 = new Command("process it", airplaneList.get(1));
		Command command3 = new Command("process it", airplaneList.get(2));
		
	    
	    ControlWaiter controlWaiter = new ControlWaiter(command1);
	    new Thread(controlWaiter,"ControlWaiter").start();
	    
	    ControlWaiter controlWaiter1 = new ControlWaiter(command2);
	    new Thread(controlWaiter1, "controlWaiter1").start();
	    
	    ControlWaiter controlWaiter2 = new ControlWaiter(command3);
	    new Thread(controlWaiter2, "controlWaiter1").start();

	    System.out.println("All the threads are started");
	}

}
