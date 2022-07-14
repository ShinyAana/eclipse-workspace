package com.reservation.server;

public class TicketBookingThread extends Thread
{
private TicketCounter tcObj;
private String passengerName;
private int noOfTickets;

public TicketBookingThread(TicketCounter tcObj,String passengerName,int noOfTickets)
{
	this.tcObj=tcObj;
	this.passengerName=passengerName;
	this.noOfTickets=noOfTickets;
}
public void run()
{
	tcObj.bookTickets(passengerName, noOfTickets);
}
}
