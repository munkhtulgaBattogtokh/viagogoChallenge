# How to run the program
### Method 1: 
	* clone the git repository to eclipse
	* import this project from Git to package explorer, or navigator view
	* open src/TicketFinder.java in text editor
	* click run button
### Method 2: 
	* download the src folder to local storage
	* using terminal, navigate to downloaded src folder
	* then type: javac TicketFinder.java
	* then type: java TicketFinder 
# Program summary: 
* Random seed data is generated: 
	* to allocate random number of tickets, of random prices to an event 
	* to decide randomly whether a location will have an event
* "World limit" (-10 to 10) was ensured by public method _addLocation_ in _TicketFinder_; that is, assuming one interacts with the program's world through its public interface. 
* _Coordinate_ can hold maximum one _Event_ object 
* Each event is automatically allocated unique id at construction thanks to a static member _countIds_ of the Event class. 
* Each event has 0 or more tickets. It is allocated up to 5 tickets of price between 20-70 USD at construction. One could add more tickets, but such functionality was not considered central. 
* Each ticket has non-zero price thanks to the _addTicket_ method in Event class, which gives an error message if ticket costing 0 is attempted. 
* _Coordinate::distanceTo_ method returns Manhattan distance from the object, to a given position specified by x, and y values. 

# Assumptions: 
* Distance precision is double 
* User inputs in format " x , y " (more precisely "\s*x\s*,\s*y\s*")
* For the purpose of demonstrating functionality, locations, events, and tickets are generated arbitrarily.  
* User inputs a location within the "world limit"
* An event is worth listing only if it has a ticket available for it
* You have Eclipse installed
* You have Java installed 

# If multiple events at same location?
Say, at the closest location, there were 5 events. As far as our program is concerned, only these events at the same location will be listed. Then, I might for example want to offer the user variety of location-choices by limiting the number of events per location to 3, and then doing that for the 5 locations, or simply listing all events at each location for the 5 locations etc. 

In conclusion, I would change my program depending on what kind of opportunities I'd like to present to the user, and implement the necessary extensions.  

# If world size was much larger? 
I first implemented the functionality, and then ensured the constraints. Therefore, the constraints are in my case there only due to the requirements. I believe the code should work equally well with world of a larger size. 

I tried my best to for example keep the complexity of the _listEvents_ method to O(n). Although there are nested loops in the method, the inner loop always has maximum 5 iterations, which makes the complexity 5n ( O(n) ). Moreover, I have encapsulated the methods so that they are more readable, and adaptable. 

But, if there are to be unexpected problems if I tried expanding my test cases, I'm most concerned with the data structures. Say, if locations' set is (1, 1), (1, 2), (1, 3), ... (1, 20), (10000, -10000), and input is (0, 0), one might consider sorting these locations, and doing the algorithm on only some heuristically chosen locations. 

# Testing my code 
I have provided a main method within each of the 3 classes so you can do a unit test of the individual classes. 

Also, you will notice print statements that are commented out inside the constructors of Coordinate, and Event. I used these, and the number of locations inside the TicketFinder constructor to check that everything was working as it should. So you can do the same by de-commenting, and manipulating the number of locations to do some manual check. 

# ENJOY MY CODE! 
