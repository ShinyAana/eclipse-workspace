import java.util.Scanner;

public class SwitchCondition {
	private static int cont(int ch)
	{
		if(ch>0&&ch<10)
			return 0;
		else if(ch>=10 && ch<20)
			return 1;
		else if(ch>=20&&ch<30)
			return 2;
		else
			return 3;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int ch=in.nextInt();
		switch(cont(ch))
		{
		case 0:
			System.out.println("Less than 10");
			break;
		case 1:
			System.out.println("Less than 20");
			break;
		case 2:
			System.out.println("Less than 30");
			break;
		default:
			System.out.println("Condition false");
			
		}
		
	}

}
