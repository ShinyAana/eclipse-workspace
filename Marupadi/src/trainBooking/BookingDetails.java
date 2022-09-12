package trainBooking;

import java.util.ArrayList;

public class BookingDetails {
	int bookingId;
	int trainNum;
	int noOfPassengers;
	String seatType;
	float totalTicketCost;
	ArrayList<Integer> seatNo;
	boolean ticketStatus;
	public boolean isTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	//boolean isMeal=false;
	//boolean isSenior=false;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public float getTotalTicketCost() {
		return totalTicketCost;
	}
	public void setTotalTicketCost(float totalTicketCost) {
		this.totalTicketCost = totalTicketCost;
	}
	public ArrayList<Integer> getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(ArrayList<Integer> seatNo) {
		this.seatNo = seatNo;
	}

}
