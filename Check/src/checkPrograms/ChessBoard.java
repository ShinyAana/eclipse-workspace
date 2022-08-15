package checkPrograms;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ChessBoard {
	public enum DaysOfWeek {
		MONDAY("M"),
		TUESDAY("T"),
		WEDNESDAY("W"),
		THURSDAY("TH"),
		FRIDAY("F"),
		SATURDAY("SA"),
		SUNDAY("S");
		public final String dofweek;
		DaysOfWeek(String dayName) {
			this.dofweek=dayName;
		}
		public String getDayCode()
		{
			return dofweek;
		}
		/*
		 * public static void main(String[] args) { for(DaysOfWeek
		 * dow:DaysOfWeek.values()) { System.out.println(dow.getDayCode()); } }
		 */
	}

	public ChessBoard() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		BigInteger bigi=new BigInteger("0");
		BigInteger exp;
		for(int i=0;i<64;i++)
		{
			exp=BigDecimal.valueOf(Math.pow(2, i)).toBigInteger();
			bigi=bigi.add(exp);
		}
		System.out.println(bigi);
		for(DaysOfWeek dow:DaysOfWeek.values())
		{ 
			System.out.println(dow.getDayCode());
			}
		
	}

}
