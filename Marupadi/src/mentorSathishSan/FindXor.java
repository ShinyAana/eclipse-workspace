package mentorSathishSan;
import java.io.*;
import java.util.*;
public class FindXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the size of an array ");
	int arraySize=input.nextInt();
	System.out.println("Enter the size of an array ");
	
	int[] array=new int[arraySize];
	for(int i=0;i<arraySize;i++)
	{
		array[i]=input.nextInt();
	}
	int xor,maximum=0;
	for(int i=0;i<arraySize;i++)
	{
		for(int j=i+1;j<arraySize;j++)
		{
			xor=array[i]^array[j];
			if(maximum<xor)
				maximum=xor;
		}
	}
	System.out.println("XOR value " + maximum);
	

	}

}
