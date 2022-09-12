package trainBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




public class TrainBooking {
static ArrayList<Train> trainlist=new ArrayList<Train>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadTrains();
		getUserMenu();

	}

	private static void getUserMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Please Enter the option to perform:");
			System.out.println(
					"1.Booking\n2.Cancellation\n3.Print available seats\n4.Show meal ordered SeatNumber\n5.Flight Summary\n6.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				booking();
				break;
			case 2:
				printTicket();
			}
		} while (choice != 6);

		
	}

	private static void printTicket() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter booking id ");
		BookingRepository br=BookingRepository.getInstance();
		int bookId=sc.nextInt();
		BookingDetails res=br.get(bookId);
		System.out.println("Train Number " + res.getTrainNum());
		System.out.println("No of tickets " + res.getNoOfPassengers());
		System.out.println("Seat Type " + res.getSeatType());
		System.out.println("Seat Number " + res.getSeatNo());
		System.out.println("Total Fare "+res.getTotalTicketCost());
		
	}

	private static void booking() {
		// TODO Auto-generated method stubq
		Scanner sc=new Scanner(System.in);
		System.out.println("Available trains are ");
		printTrains();
		System.out.println("Enter train number");
		int trainnum=sc.nextInt();
		sc.nextLine();
		Train train=new Train();
		train=findAvailability(trainnum);
		if(train!=null)
		{
			System.out.println("Select class...sleeper coach/AC Coach");
			String coach=sc.nextLine();
			System.out.println("Available seats are");
			getNoOfSeats(coach,train);
			System.out.println("Enter number of tickets");
			int noOftickets=sc.nextInt();
			System.out.println("Enter your prefered berth choice L/M/U");
			String berthPreference=sc.next();
			String allotedBerth=allotBerth(coach,berthPreference,noOftickets,train);
			if(allotedBerth!=null)
			{
				BookingRepository bRepo = BookingRepository.getInstance();
				BookingDetails booking = new BookingDetails();
				booking.setTrainNum(trainnum);
				booking.setNoOfPassengers(noOftickets);
				booking.setSeatType(allotedBerth);
				booking.setTicketStatus(true);
				booking.setSeatNo(getSeatNumber(coach,allotedBerth,noOftickets,train));
				int baseFare = 0;
				if (coach.equals("Sleeper Coach")) {
					baseFare = 200;
				} else if (coach.equals("AC Coach")) {
					baseFare = 250;
				}
				
				float totalCost, seniorFare = 0;
				totalCost = noOftickets * baseFare;
				System.out.println("Total Cost is:" + totalCost);
				train.setTotalfare(train.getTotalfare() + totalCost);
				booking.setTotalTicketCost(totalCost);
				System.out.println("Ticket Booked Successfully");
				System.out.println("Booking id:" + bRepo.add(booking));

				
			}
			else
			{
				System.out.println("booking tickets exeeds the availability");
			}
			
		}
		
		
	}

	
	private static ArrayList<Integer> getSeatNumber(String coach, String allotedBerth, int noOftickets, Train train) {
		// TODO Auto-generated method stub
		ArrayList<Integer> seatNo = new ArrayList<Integer>();
		int count=0;
		for(Map.Entry<String, List<Seats>> entry:	train.getSeatMap().entrySet())
		{
			if(entry.getKey().equals(coach))
			{
				for(Seats seat:entry.getValue())
				{
				if(seat.getSeatType().equals(allotedBerth))
				{
					if(seat.isAvailable())
					{
						seat.setAvailable(false);
						seatNo.add(seat.getSeatNum());
						count+=1;
					}
					if(count==noOftickets)
					{
						break;
					}
				}
				
				}
			}
		}
		return seatNo;
	}

	private static String allotBerth(String coach, String berthPreference, int noOftickets, Train train) {
		// TODO Auto-generated method stub
			int updateLowerBerthCount;
			int updateMiddleBerthCount;
			int updateUpperBerthCount;
			int updateRACCount;
			int updateWaitingListCount;
			
		for(Map.Entry<String, List<Seats>> entry:	train.getSeatMap().entrySet())
		{
			if(entry.getKey().equals(coach))
			{
				for(Seats seat:entry.getValue())
				{
					if(seat.getWaitingList()!=0)
					{
					if(berthPreference.equals("L") && seat.getLowerBerthCount()>=noOftickets)
					{
					updateLowerBerthCount=seat.allotlowerBerth(noOftickets);
					seat.setLowerBerthCount(updateLowerBerthCount);
					return "L";
		
					}
					else if(berthPreference.equals("M") && seat.getMiddleBerthCount()>=noOftickets)
					{
						updateMiddleBerthCount=seat.allotmiddleBerth(noOftickets);
						seat.setMiddleBerthCount(updateMiddleBerthCount);
						return "M";
											
					}
					else if(berthPreference.equals("U") && seat.getUpperBerthCount()>=noOftickets)
					{
						updateUpperBerthCount=seat.allotupperBerth(noOftickets);
						seat.setUpperBerthCount(updateUpperBerthCount);
						return "U";
											
					}
					else if(seat.getLowerBerthCount()>=noOftickets || seat.getMiddleBerthCount()>=noOftickets||seat.getUpperBerthCount()>=noOftickets)
					{	
						if(seat.getLowerBerthCount()>=noOftickets)
						{
						updateLowerBerthCount=seat.allotlowerBerth(noOftickets);
						seat.setLowerBerthCount(updateLowerBerthCount);
						return "L";
						}
						else if(seat.getMiddleBerthCount()>=noOftickets)
						{
							updateMiddleBerthCount=seat.allotmiddleBerth(noOftickets);
							seat.setMiddleBerthCount(updateMiddleBerthCount);
							return "M";					
						}
						else if(seat.getUpperBerthCount()>=noOftickets)
						{
							updateUpperBerthCount=seat.allotupperBerth(noOftickets);
							seat.setUpperBerthCount(updateUpperBerthCount);
							return "U";					
						}
			
					}
					else
					{
						if(seat.getRacCount()>=noOftickets)
						{
							updateRACCount=seat.allotRAC(noOftickets);
							seat.setRacCount(updateRACCount);
							return "RAC";
						}
						else if(seat.getWaitingList()>=noOftickets)
						{
							updateWaitingListCount=seat.allotWL(noOftickets);
							seat.setWaitingList(updateWaitingListCount);
							return "WL";
						}
					}
				}
			}
		}
				
		}
		
		return null;
	}

	private static void getNoOfSeats(String coach, Train train) {
		// TODO Auto-generated method stub
		for(Map.Entry<String, List<Seats>> mapEntry: train.getSeatMap().entrySet())
		{
			if(mapEntry.getKey().equals(coach))
			{
				for(Seats seat:mapEntry.getValue())
				{
					System.out.println("Number of lower berth "+seat.getLowerBerthCount());
					System.out.println("Number of middle berth "+seat.getMiddleBerthCount());
					System.out.println("Number of upper berth "+seat.getUpperBerthCount());
					System.out.println("Number of RAC "+seat.getRacCount());
					System.out.println("Number of WaitingList "+seat.getWaitingList());
					break;
				}
			}
		}
	}

	private static Train findAvailability(int trainnum) {
		// TODO Auto-generated method stub
		for(Train train:trainlist)
		{
			if(train.getTrainId()==trainnum)
			{
				return train;
			}
		}
		return null;
	}

	private static void printTrains() {
		// TODO Auto-generated method stub
		for(Train tr:trainlist)
		{
			System.out.print(tr.getTrainId() + " ");
		}
		System.out.println();
		
	}

	private static void loadTrains() {
		// TODO Auto-generated method stub
		trainlist.add(new Train(101,loadSeat()));
		trainlist.add(new Train(102,loadSeat()));
		trainlist.add(new Train(103,loadSeat()));
		
		
		
	}

	private static HashMap<String, List<Seats>> loadSeat() 
	{
		List<Seats> seatList = new ArrayList<Seats>();
		List<Seats> acseatList = new ArrayList<Seats>();
		
		HashMap<String, List<Seats>> seatMap = new HashMap<String, List<Seats>>();
		 int lowerBerthCount=21;
		 int middleBerthCount=21;
		 int upperBerthCount=21;
		 int racCount=18;
		 int waitingList=10;
		 int seatNo=1;
		 float Sleeperfare=180;
		 float acCoachfare=250;
			/*
			 * Seats obj=new Seats(); obj.setLowerBerthCount(lowerBerthCount);
			 * obj.setMiddleBerthCount(middleBerthCount);
			 * obj.setUpperBerthCount(upperBerthCount); obj.setRacCount(racCount);
			 * obj.setWaitingList(waitingList);
			 */
		 for (int i = 0; i < lowerBerthCount; i++) {
				seatList.add(new Seats("L", seatNo, true,Sleeperfare));
				seatNo++;
			}
		 for (int i = 0; i < middleBerthCount; i++) {
				seatList.add(new Seats("M", seatNo, true,Sleeperfare));
				seatNo++;
			}
		 for (int i = 0; i < upperBerthCount; i++) {
				seatList.add(new Seats("U", seatNo, true,Sleeperfare));
				seatNo++;
			}
		 for (int i = 0; i < racCount; i++) {
				seatList.add(new Seats("RAC", seatNo, true,Sleeperfare));
				seatNo++;
			}
		 for (int i = 0; i < waitingList; i++) {
				seatList.add(new Seats("WL", seatNo, true,Sleeperfare));
				seatNo++;
			}
		
		 seatMap.put("Sleeper Coach", seatList);
		 for (int i = 0; i < lowerBerthCount; i++) {
			 acseatList.add(new Seats("L", seatNo, true,acCoachfare));
				seatNo++;
			}
		 for (int i = 0; i < middleBerthCount; i++) {
			 acseatList.add(new Seats("M", seatNo, true,acCoachfare));
				seatNo++;
			}
		 for (int i = 0; i < upperBerthCount; i++) {
			 acseatList.add(new Seats("U", seatNo, true,acCoachfare));
				seatNo++;
			}
		 for (int i = 0; i < racCount; i++) {
			 acseatList.add(new Seats("RAC", seatNo, true,acCoachfare));
				seatNo++;
			}
		 for (int i = 0; i < waitingList; i++) {
			 acseatList.add(new Seats("WL", seatNo, true,acCoachfare));
				seatNo++;
			}
		 seatMap.put("AC Coach", acseatList);
	
		return seatMap;
	}

}
