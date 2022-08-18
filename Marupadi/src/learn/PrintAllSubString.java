package learn;

public class PrintAllSubString 
{

	public static void main(String[] args) 
	{
		
	String str="abc";
	char[] ch=str.toCharArray();
	int len=ch.length;
	for(int i=0;i<str.length();i++)
	{
		for(int j=i+1;j<=str.length();j++)
		{
			System.out.println(str.substring(i, j));
		}
	}
		
	}

}
