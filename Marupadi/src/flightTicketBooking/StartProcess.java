package flightTicketBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StartProcess 
{
protected static HashMap<Integer,Flight> flightDetails=new HashMap<>();
	public static void main(String[] args)
	{
		StartProcess processStart=new StartProcess();
		processStart.startProcess();
		
	}

	
	private void startProcess()
	{
		int flightNum=7650;
		for(int i=0;i<2;i++)
		{
			flightDetails.put(flightNum++, new Flight());
		}
		boolean isProcess=true;
		
		while(isProcess)
		{
		
	Scanner input=new Scanner(System.in);	
	System.out.println("Enter the choice \n1.Book Tickets \n2.Cancel Tickets \n3.Tickets Details \n4.Exit");
	int choice=input.nextInt();
	switch(choice)
	{
	case 1:
		System.out.println();
		System.out.println("Enter your name");
		String name=input.next();
		System.out.println("Enter the flight number 1.7650 \n2.7651");
		int fnum=input.nextInt();
		System.out.println("FlightNUmber= " + fnum + "    Total number of tickets " + flightDetails.get(fnum).numOfTickets + "    Price per Ticket " + flightDetails.get(fnum).price);

		System.out.println("Enter number of tickets");
		int tickets=input.nextInt();
		Flight flight=flightDetails.get(fnum);
		flight.numOfTickets=flight.numOfTickets-tickets;
		double amount=flightDetails.get(fnum).price;
		double amtPaid=tickets*amount;
		Passenger obj=new Passenger(name,tickets,amtPaid);
		ArrayList<Passenger> pd=flightDetails.get(fnum).passengerDetails;
		pd.add(obj);
		int index=pd.indexOf(obj);
		//System.out.println(index);
		System.out.println("Ticket booked successfully");
		System.out.println("FlightNUmber= " + fnum + "Total number of tickets " + flightDetails.get(fnum).numOfTickets + " Price per Ticket " + flightDetails.get(fnum).price);
		System.out.println("Passenger Details ");
		System.out.println("Passenger Id " + pd.get(index).pId + " \nPassenger Name " + pd.get(index).pName + " \nAmount Paid "+ pd.get(index).amtPaid);
		break;
	case 2:
		isProcess=false;
		

	}
	}
	}

}
