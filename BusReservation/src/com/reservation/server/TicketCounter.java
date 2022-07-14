package com.reservation.server;

public class TicketCounter 
{
private int availableSeats=3;
public synchronized void bookTickets(String pname,int noOfSeats)
{
	if(availableSeats>=noOfSeats && availableSeats>0)
	{
		System.out.println("Hi " + pname + "... Your tickets booked successfully");
		availableSeats=noOfSeats-availableSeats;
	}
	else
	{
		System.out.println("Hi " + pname + "...seats not available");
		
	}
}
}
