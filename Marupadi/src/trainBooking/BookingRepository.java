package trainBooking;

import java.util.ArrayList;


public class BookingRepository {
	public static BookingRepository bRepo=null;
	ArrayList<BookingDetails> bookingList=new ArrayList<BookingDetails>();
	private BookingRepository()
	{

	}
	public static BookingRepository getInstance()
	{
		if(bRepo==null)
		{
			bRepo=new BookingRepository();
		}
		return bRepo;
	}
	public int add(BookingDetails booking) {
		
		int bookingId=bookingList.size()+1;	
		booking.setBookingId(bookingId);
		bookingList.add(booking);
		return bookingId;

	}
	public BookingDetails get(int bookingId)
	{
		for(BookingDetails bClass:bookingList)
		{
			if(bClass.bookingId==bookingId)
			{
				return bClass;
			}
		}
		return null;
	}
	public void delete(BookingDetails bClass) {
		bookingList.remove(bookingList.indexOf(bClass));
		
	}
	

}
