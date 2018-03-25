package se.lexicon.model.multithdFlightBase;

import java.util.List;

import se.lexicon.model.Airplane1;

public class FlightControl {

	List<Airplane1> airplaneList;
	
	public FlightControl(List<Airplane1> airplaneList) {
		super();
		this.airplaneList = airplaneList;
		System.out.println("Inside FlightControl constructor");
	}

	Command command;
//	
//	public FlightControl(Command command) {
//	super();
//	this.command = command;
//}
	
//	public static void main(String[] args) {
//		List<Airplane1> aList = new ArrayList<Airplane1>();
//		ReservationService1 reservationSvc = new ReservationServiceImp1();
//		FlightManager flightManger = new FlightManager(reservationSvc);
//		Airplane1 a1 = new AirplaneImp1(flightManger.generateFlightNumber());
//		aList.add(a1);
//		Airplane1 a2 = new AirplaneImp1(flightManger.generateFlightNumber());
//		aList.add(a2);
//		Airplane1 a3 = new AirplaneImp1(flightManger.generateFlightNumber());
//		aList.add(a3);
//		FlightControl flighControl= new FlightControl(aList);
//		flighControl.Control();
//	}
	
	public void Control() {

//		Command command1 = new Command("process it", airplaneList.get(0));
//		Command command2 = new Command("process it", airplaneList.get(1));
//		Command command3 = new Command("process it", airplaneList.get(2));
	    
//		Command command1 = new Command("process it...");
	    ControlWaiter controlWaiter1 = new ControlWaiter(airplaneList.get(0));
	    new Thread(controlWaiter1,"ControlWaiter1").start();
	    
	    ControlWaiter controlWaiter2 = new ControlWaiter(airplaneList.get(1));
	    new Thread(controlWaiter2, "controlWaiter2").start();
	    
	    ControlWaiter controlWaiter3 = new ControlWaiter(airplaneList.get(2));
	    new Thread(controlWaiter3, "controlWaiter3").start();

	    ControlNotifier controlNotifier1 = new ControlNotifier(airplaneList.get(0));
	    new Thread(controlNotifier1, "controlNotifier1").start();

	    ControlNotifier controlNotifier2 = new ControlNotifier(airplaneList.get(1));
	    new Thread(controlNotifier2, "controlNotifier2").start();
	    
	    ControlNotifier controlNotifier3 = new ControlNotifier(airplaneList.get(2));
	    new Thread(controlNotifier3, "controlNotifier3").start();
	    
	    System.out.println("All the threads are started");
	    
	}

}
