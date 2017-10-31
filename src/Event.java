import java.util.ArrayList; 

public class Event {
	private static int countIds; 		// this is used to assign unique id automatically 
	private int id; 
	private ArrayList<Double> tickets; // tickets are represented by its price

	public Event() {
	
		this.id = countIds++; 
		this.tickets = new ArrayList<Double>(); 
		
		/*
		 * up to 5 tickets will be added by default when an event is 
		 * created, a default ticket costs up 20 - 70 USD. 
		 */
		int numTickets = (int)(Math.random() * 6); 
		for (int i = 0; i < numTickets; i++) {
			addTicket(Math.random() * 50 + 20); 
			//System.out.println("ticket added");
		}
		
			//System.out.println("event created with id: " + id);
	}
	
	/** 
	 * @return id of the specific event 
	 */
	public int getId() {
		return this.id; 
	}
	
	/**
	 * @return true if there is available ticket for this event
	 */
	public boolean ticketsAvailable() {
		if (!tickets.isEmpty()) return true; 
		return false; 
	}
	
	/** 
	 * Adds a ticket to the event by defining its price
	 */
	public void addTicket(double price) {
		if (price == 0) {
			System.out.println("nothing is for free");
			return; 
		}
		tickets.add(price); 
	}
	
	/**
	 * Returns the cheapest ticket price for this event
	 */
	public double cheapestTicket() {
		double minPrice = Double.MAX_VALUE; 
		
		if (!tickets.isEmpty()) {
			for (int i = 0; i < tickets.size(); i++) {
				if (tickets.get(i) < minPrice) minPrice = tickets.get(i);  
			}
			return minPrice; 
		}
		
		return -1; // -1 means no tickets
	}
	
	// method for testing only
	private void printPrices() {
		for (Double d : tickets) {
			System.out.println("Price: " + d);
		}
	}
	
	/*
	 * Run this class main method to test that cheapestTicket works 
	 * properly
	 */
	public static void main(String[] args) {
		Event concert = new Event();
		concert.printPrices();	
		System.out.println(concert.cheapestTicket());
	}
	
}
