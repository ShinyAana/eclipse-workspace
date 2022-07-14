package interview;

import java.util.Arrays;
import java.util.Scanner;

public class ComputeMaxValue {

	public static void main(String[] args)
	{
		ComputeMaxValue obj=new ComputeMaxValue();
		obj.computeMax();
	}

	private void computeMax()
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter array size");
	int n=input.nextInt();
	int[] arr=new int[n];
	int[] result=new int[n];
	System.out.println("Enter array elements");
	for(int i=0;i<n;i++)
	{
		arr[i]=input.nextInt();
	}
	int num=0,addValue=0,multiValue=0;
	
	for(int i=0;i<n;i++)
	{
		num=arr[i];
		addValue=add(num);
		multiValue=multi(num);
		if(addValue>multiValue)
		{
			result[i]=addValue;
		}
		else
		{
			result[i]=multiValue;
		}
		
	}
	System.out.println(Arrays.toString(result));
	}

	private int multi(int num)
	{
	int addnum=0,temp=0;
	while(num>0)
	{
		temp=num%10;
		addnum=addnum+temp;
		num=num/10;
	}
		
		return addnum;
	}

	private int add(int num)
	{
		int multiNum=1,temp=0;
		while(num>0)
		{
			temp=num%10;
			multiNum=multiNum*temp;
			num=num/10;
		}
		
		return multiNum;
	}

}
