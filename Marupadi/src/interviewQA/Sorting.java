package interviewQA;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args)
	{
	int[] array= {-1,150,190,170,-1,-1,160,180};
	Sorting.sortArray(array);
	}

	private static void sortArray(int[] array) 
	{
	int j=1;
	while(j<array.length)
	{
		int i=0;
		while(i<array.length-j)
		{
			if(array[i]==-1)
			{
				i++;
				continue;
			}
			else
			{
				
		     if(array[i]>array[i+1])
			{
				int temp=array[i];
				array[i]=array[i+1];
				array[i+1]=temp;
			}
			}
			i++;
		}
		j++;
	}
	System.out.println(Arrays.toString(array));
	}

}
