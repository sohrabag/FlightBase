package se.lexicon.model;

import java.util.Date;
import java.util.GregorianCalendar;

public class TicketImp implements Ticket {

	private int Id;
	private String flightNumber;
	private FlightClass flightClass;
	private int seatNumber;
	private String destination;
	private Date flightTime;
	private boolean foodOption;
	private FoodType foodType;
	private Airline1 airline;
	private int price;

	
	public TicketImp(int id, String flightNumber, FlightClass flightClass, int seatNumber, String destination,
			Date flightTime, boolean foodOption, FoodType foodType, Airline1 airline, int price) {
		super();
		Id = id;
		this.flightNumber = flightNumber;
		this.flightClass = flightClass;
		this.seatNumber = seatNumber;
		this.destination = destination;
		this.flightTime = flightTime;
		this.foodOption = foodOption;
		this.foodType = foodType;
		this.airline = airline;
		this.price = price;
	}
	
	@Override
	public int getId() {
		
		return this.Id;
	}

	@Override
	public String getFlightNumber() {
		
		return this.flightNumber;
	}

	@Override
	public FlightClass getFlightClass() {
		
		return this.flightClass;
	}

	@Override
	public int getSeatNumber() {
		
		return this.seatNumber;
	}

	@Override
	public String getDestination() {
		
		return this.destination;
	}

	@Override
	public Date getFlightTime() {
		
		return this.flightTime;
	}

	@Override
	public boolean getFoodOption() {
		
		return this.foodOption;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Ticket Information as follows: \n");
		sb.append("Flight Number is: " + flightNumber + "\n");
		sb.append("Date of Flight: " + this.flightTime + "\n");
		sb.append("Destination is: " + this.destination + "\n");
		sb.append("Flight with Airline: " + this.airline.getName() + "\n");
		sb.append("Ticket price is: " + this.price + "\n");
		sb.append("-------------------------------------------------\n");
		
		return sb.toString();
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodOption(boolean foodOption) {
		this.foodOption = foodOption;
	}

	@Override
	public Airline1 getAirline() {
		
		return this.airline;
	}

	public int getPrice() {
		return price;
	}
	
	
}
