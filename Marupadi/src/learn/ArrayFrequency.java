package learn;

import java.util.Arrays;

public class ArrayFrequency {

	public static void main(String[] args)
	{
	int[] arr= {2,2,3,4,3,3,3,4,5,6,2,5,5,5,5,5};
	int count=0,visited=-1,n=arr.length,k=0;
	int[] freq=new int[arr.length];
	for(int i=0;i<n;i++)
	{
		count=1;
		for(int j=i+1;j<n;j++)
		{
			if(arr[i]==arr[j])
			{
				count++;
				freq[j]=visited;
			}
		}
		if(freq[i]!=visited)
		{
			freq[i]=count;
			//k++;
		}
	}
	//System.out.println(Arrays.toString(freq));

	//System.out.println(Arrays.toString(arr));

	
	
	  for(int i=0;i<n;i++) 
	  {
		  for(int j=i+1;j<n;j++)
		  {
			  if(freq[i]!=-1 && freq[i]<freq[j]) 
			  {
				  int temp=freq[i]; 
				  freq[i]=freq[j];
				  freq[j]=temp;
	  
	  int temp1=arr[i]; 
	  arr[i]=arr[j];
	  arr[j]=temp;
	  } } }
	  for(int i=0;i<n;i++)
		{
			if(freq[i]!=visited)
			{
				for(int j=0;j<freq[i];j++)
				{
					System.out.print(arr[i] + " ");
				}
			}
		//System.out.println(arr[i] + " ---> " + freq[i]);
		}
		
	  
	  
	 	}
	

}
