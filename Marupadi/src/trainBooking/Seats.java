package trainBooking;

public class Seats {
String SeatType;
int seatNum;
boolean isAvailable;
float fare;
int lowerBerthCount=21;
 int middleBerthCount=21;
 int upperBerthCount=21;
 int racCount=18;
 int waitingList=10;
public Seats()
{
	
}
public int allotlowerBerth(int nooftickets)
{
	if(this.lowerBerthCount>=nooftickets)
	{
		this.lowerBerthCount-=nooftickets;
		return this.lowerBerthCount;
	}
	return -1;
}
public int allotmiddleBerth(int nooftickets)
{
	if(this.middleBerthCount>=nooftickets)
	{
		this.middleBerthCount-=nooftickets;
		return this.middleBerthCount;
	}
	return -1;
}
public int allotupperBerth(int nooftickets)
{
	if(this.upperBerthCount>=nooftickets)
	{
		this.upperBerthCount-=nooftickets;
		return this.upperBerthCount;
	}
	return -1;
}
public int allotRAC(int nooftickets)
{
	if(this.racCount>=nooftickets)
	{
		this.racCount-=nooftickets;
		return this.racCount;
	}
	return -1;
}
public int allotWL(int nooftickets)
{
	if(this.waitingList>=nooftickets)
	{
		this.waitingList-=nooftickets;
		return this.waitingList;
	}
	return -1;
}

public String getSeatType() {
	return SeatType;
}



public void setSeatType(String seatType) {
	SeatType = seatType;
}



public int getSeatNum() {
	return seatNum;
}



public void setSeatNum(int seatNum) {
	this.seatNum = seatNum;
}



public boolean isAvailable() {
	return isAvailable;
}



public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}



public float getFare() {
	return fare;
}



public void setFare(float fare) {
	this.fare = fare;
}



public int getLowerBerthCount() {
	return lowerBerthCount;
}



public void setLowerBerthCount(int lowerBerthCount) {
	this.lowerBerthCount = lowerBerthCount;
}



public int getMiddleBerthCount() {
	return middleBerthCount;
}



public void setMiddleBerthCount(int middleBerthCount) {
	this.middleBerthCount = middleBerthCount;
}



public int getUpperBerthCount() {
	return upperBerthCount;
}



public void setUpperBerthCount(int upperBerthCount) {
	this.upperBerthCount = upperBerthCount;
}



public int getRacCount() {
	return racCount;
}



public void setRacCount(int racCount) {
	this.racCount = racCount;
}



public int getWaitingList() {
	return waitingList;
}



public void setWaitingList(int waitingList) {
	this.waitingList = waitingList;
}



public Seats(String seatType, int seatNum, boolean isAvailable, float fare) {
	super();
	SeatType = seatType;
	this.seatNum = seatNum;
	this.isAvailable = isAvailable;
	this.fare = fare;
}


}
