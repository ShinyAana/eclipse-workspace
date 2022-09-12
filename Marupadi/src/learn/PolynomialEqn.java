package learn;

import java.util.Arrays;
import java.util.Scanner;

public class PolynomialEqn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter array1 size");
		int n1=input.nextInt();
		int[] arr=new int[n1];
		System.out.println("Enter array1 values");
		for(int i=0;i<n1;i++)
		{
			arr[i]=input.nextInt();
		}
		System.out.println("Enter array2 size");
		int n2=input.nextInt();
		int[] arr2=new int[n2];
		System.out.println("Enter array2 values");
		for(int i=0;i<n2;i++)
		{
			arr2[i]=input.nextInt();
		}
		int res=n1+n2-1;
		int[] resArr=new int[res];
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<n2;j++)
			{
				resArr[i+j]=arr[i]*arr2[j];
			}
		}
		System.out.println(Arrays.toString(resArr));
		
	}

}
