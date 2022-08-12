package flightTicketBooking;

import java.util.ArrayList;

public class Flight {
 int flightId;
static int fid=0;
int numOfTickets;
double price;
ArrayList<Passenger> passengerDetails;
public Flight()
{
	this.flightId=fid++;
	this.numOfTickets=50;
	this.price=5000;
	this.passengerDetails=new ArrayList<Passenger>();
	
	
}
}
