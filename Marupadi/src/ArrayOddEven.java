import java.io.*;
import java.util.*;


	public class ArrayOddEven {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the size of an array");
			int len = sc.nextInt();
			
			int evenIndex,oddIndex;
			int[] arr = new int[len];
			int[] resultArr = new int[len];
			System.out.println("Enter the array elements");
			for(int i=0;i<len;i++)
			{
				arr[i]=sc.nextInt();
			}
			sc.close();
			evenIndex = len/2;
			if(len%2 == 0)
				oddIndex = len/2;
			else
				oddIndex = len/2 +1;
				
			Arrays.sort(arr);
			/*for(int i=0;i<len;i++)
				System.out.println(arr[i]);*/ //1 1 2 4 5 6 8 8 
			int evenIn=0,oddIn=1;
			for(int i=evenIndex-1;i>=0;i--)
			{
				resultArr[evenIn] = arr[i];
				evenIn +=2;
			}
			for(int i=oddIndex;i<len;i++)
			{
				resultArr[oddIn] = arr[i];
				oddIn +=2;
			}
			for(int i=0;i<len;i++)
			{
				System.out.print(resultArr[i]+"  ");
			}
		}
	}