package learn;

import java.util.ArrayList;

public class SubArraySum2 {

	public static void main(String[] args)
	{
	int[] arr= {1,4,20,3,10,5};
	int l=0,r=0,curSum=0,sum=33;
	ArrayList<Integer> al=new ArrayList<>();
	int n=arr.length;
	while(l<=r)
	{
		if(curSum==sum)
		{
			al.add(l);
			al.add(r-1);
			break;
		}
		else if(curSum<sum)
		{
			curSum+=arr[r++];
		}
		else
		{
			curSum-=arr[l++];
		}
	}
	System.out.println(al);
	//System.out.println(arr[al.get(0)] + " " + arr[al.get(1)] + " " + arr[al.get(2)]);
	}

}
