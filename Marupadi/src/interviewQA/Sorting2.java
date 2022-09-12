package interviewQA;

import java.util.Arrays;

public class Sorting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {-1,150,190,170,-1,-1,160,180};
		Sorting2.sortArray(array);
		

	}

	private static void sortArray(int[] array) {
		// TODO Auto-generated method stub
		int length=array.length;
		for(int i=0;i<length;i++)
		{
			if(array[i]==-1)
			{
			continue;	
			}
			int temp=i;
			for(int j=i+1;j<length;j++)
			{
					if(array[temp]>array[j] && array[j]!=-1)
					{
						temp=j;
					}
				
			}
			int temp1=array[temp];
			array[temp]=array[i];
			array[i]=temp1;
			System.out.println(array[temp] + " " + array[i]);
		}
		System.out.println(Arrays.toString(array));
		
	}

}
