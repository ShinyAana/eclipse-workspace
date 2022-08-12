package flightTicketBooking;

public class Passenger
{
 int pId;
static int pid=1;
 String pName;
//private int flightNum;
 int ticketCount;
 double amtPaid;
public Passenger(String pName,int ticketCount,double amtPaid)
{
	this.pId=pid++;
	this.pName=pName;
	//this.flightNum=flightNum;
	this.ticketCount=ticketCount;
	this.amtPaid=amtPaid;
}
public double calculateAmt(int tCount,double amount)
{
	double totalAmt=this.ticketCount*amount;
	return totalAmt;
}
}
