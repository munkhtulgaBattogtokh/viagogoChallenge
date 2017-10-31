
public class Coordinate {
	private double x; 
	private double y; 
	private Event event; // is either null, or an actual event 
	
	public Coordinate(double x, double y) {
		this.x = x; 
		this.y = y; 
		
		/* 
		 *  around 70% of the time, a coordinate will have a randomly 
		 *  generated event
		 */
		if ((int)(Math.random() * 100) > 30) event = new Event(); 
		//System.out.println("inside Coordinate (" + x + "," + y + ")\n"); 
	}

	/**
	 * @param x
	 * @param y
	 * @return distance to a location specified by parameters x, and y
	 */
	public double distanceTo(double x, double y) {
		return Math.abs(this.x - x) + Math.abs(this.y - y); 
	}
	
	/** 
	 * @return cheapest ticket price for the event at this location, 
	 * if one exists 
	 */
	public double cheapestEventTicket() {
		if (event != null) {
			return event.cheapestTicket(); 
		}
		
		return -2; // -2 means no event 
	}
	
	/**
	 * @return true if this location has an event with tickets available
	 */
	public boolean hasEventWithTicket() {
		if (event != null && event.ticketsAvailable()) return true;
		return false; 
	}
	
	/**
	 * @return id of the event at this location, if one exists
	 */
	public int eventId() {
		if (event != null) 
			return event.getId(); 
		return -1; 
	}
	
	public double getX() {
		return x; 
	}
	
	public double getY() {
		return y; 
	}
	
	/*
	 * run this class' main method to test that cheapestEventTicket
	 * works properly
	 */
	public static void main(String[] args) {
		Coordinate c = new Coordinate(1, 2); 
		System.out.println(c.cheapestEventTicket());  
	}
}
