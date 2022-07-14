package com.reservation.client;

import com.reservation.server.TicketBookingThread;
import com.reservation.server.TicketCounter;

public class ApplicationStart {

	public static void main(String[] args)
	{
		ApplicationStart obj=new ApplicationStart();
		obj.startBooking();
	}

	private void startBooking()
	{
	TicketCounter obj=new TicketCounter();
	TicketBookingThread t1=new TicketBookingThread(obj,"Sara",2);
	TicketBookingThread t2=new TicketBookingThread(obj,"Raji",2);
	t1.start();
	t2.start();
	}

}
