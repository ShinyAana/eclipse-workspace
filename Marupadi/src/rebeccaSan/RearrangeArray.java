package rebeccaSan;

import java.util.Arrays;

public class RearrangeArray {

	public static void main(String[] args)
	{
		int[] array= {1,2,3,4,5,6,7,8,9};
	System.out.println("Array elements are" + Arrays.toString(array));
	rearrangeArrayElements(array);
	System.out.println("Array elements after rearrange are" + Arrays.toString(array));
	
	}

	private static void rearrangeArrayElements(int[] array)
	{
		// TODO Auto-generated method stub
		for(int i=1;i<array.length;i+=2)
		{
			if(array[i-1]>array[i])
				swapElements(array,i-1,i);
			if(i+1<array.length && array[i+1]>array[i])
				swapElements(array,i+1,i);
		}
		
	}

	private static void swapElements(int[] array, int i, int j) 
	{
	int temp=array[i];
	array[i]=array[j];
	array[j]=temp;
	}

}
