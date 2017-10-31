import java.util.Scanner; 
import java.util.ArrayList; 
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols; 

public class TicketFinder {
	
	private ArrayList<Coordinate> locations; // models all the locations with the events in this world 
	private static final DecimalFormat formatter = new DecimalFormat("#0.00"); 
	
	public TicketFinder() {
		locations = new ArrayList<Coordinate>(); 
		
		// I could randomly generate locations, but they are manually made for manual testing
		addLocation(1, 2); 
		addLocation(1, 3); 
		addLocation(7, 4); 
		addLocation(4, 5); 
		addLocation(2, 6); 
		addLocation(8, 7); 
		addLocation(6, 8); 
		addLocation(4, 9); 
		addLocation(-1, 2); 
		addLocation(-2, 5); 
		
		// quick code to change the double point separator to '.'
		DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance(); 
		sym.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(sym);
	}
	
	/** 
	 * Adds a location to the world. 
	 * Ensures that the world is limited within -10 to 10 on both axes.
	 * @param x
	 * @param y
	 */
	public void addLocation(double x, double y) {
		if (-10 <= x && x <= 10 && -10 <= y && y <= 10) {
			locations.add(new Coordinate(x, y)); 
		} else {
			System.out.println("such location is out of this world, cannot create it");
		}
	}
	
	/**
	 * When a location is given by x, and y, lists the 5 closest 
	 * events, and the cheapest ticket price for each 
	 * Note 1: locations with no events are ignored 
	 * Note 2: locations with events, but no tickets available are ignored
	 * @param x
	 * @param y
	 */
	public void listEvents(double x, double y) {
		
		ArrayList<Double> bestFiveDistances = new ArrayList<Double>(); 
		ArrayList<Integer> bestFiveIndices = new ArrayList<Integer>();  
		for (int i = 0; i < 5; i++ ) {
			bestFiveDistances.add(i, Double.MAX_VALUE); 
		}
		
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).hasEventWithTicket()) {
				double distance = locations.get(i).distanceTo(x, y); 
				for (int j = 0; j < 5; j++) {
					if ( distance <	bestFiveDistances.get(j))  {
						
						bestFiveDistances.add(j, distance); 
						if (bestFiveDistances.size() > 5) bestFiveDistances.subList(5, 6).clear(); 
						
						bestFiveIndices.add(j, i); 
						if (bestFiveIndices.size() > 5) bestFiveIndices.subList(5, 6).clear(); 
										
						break; 
					}
				}
			}
		}	
		
		for (int i = 0; i < bestFiveIndices.size(); i++) {
			Coordinate goodLoc = locations.get(bestFiveIndices.get(i)); 
			System.out.println("Event " + goodLoc.eventId() + 
					" at (" + goodLoc.getX() + "," + goodLoc.getY() + ") - $"
					+ formatter.format(goodLoc.cheapestEventTicket()) + ", Distance " 
					+ formatter.format(goodLoc.distanceTo(x, y)));
		}
		
	}

	// Testing the whole thing
	public static void main(String[] args) {
		// Take input 
		Scanner in = new Scanner(System.in); 
		System.out.println("Please input Coordinates in format (x,y): "); 
		String coord = in.nextLine(); 
		
		String[] inputs = coord.split("\\s*,\\s*"); 
		
		for (String s : inputs) {
			 s = s.trim(); 
		}
		
		TicketFinder finder = new TicketFinder(); 
		
		// Convert input to double and use them as coordinate
		finder.listEvents(Double.parseDouble(inputs[0]), 
							Double.parseDouble(inputs[1])); 
	
		in.close(); 
	}
}
