package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {9,7,5,14,2,3,6,10};
		int len = arr.length;
		quickSorting(arr,0,len-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSorting(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l < r)
		{
			int pivot = arr[l];
			int i=l;int j=r;
			while(i<j)
			{
				i++;
				while(i<=r && arr[i]<pivot)
					i++;
				while(j>=1 && arr[j]>pivot)
					j--;
				if(i<j && i<=r)
					swapOf(arr,i,j);
			}
			swapOf(arr,l,j);
			quickSorting(arr, l, j-1);
			quickSorting(arr, j+1, r);
		}
	}

	private static void swapOf(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}