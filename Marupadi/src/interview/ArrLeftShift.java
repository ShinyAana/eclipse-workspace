package interview;
import java.io.*;
import java.util.*;
public class ArrLeftShift
  {
    public static void main(String[] args)
    {
      Scanner in=new Scanner(System.in);
      System.out.println("Enter array  size");
      int n=in.nextInt();
      int[] arr=new int[n];
      System.out.println("Enter array  value");
      for(int i=0;i<n;i++)
        {
          arr[i]=in.nextInt();
        }
      System.out.println("Array elements before shift ");
        System.out.println(Arrays.toString(arr));
      int temp=arr[0],i=0;
      while(i<n-1)
        {
          arr[i]=arr[i+1];
          i=i+1;
        }
      arr[i]=temp;
       System.out.println("Array elements After left shift ");
       System.out.println(Arrays.toString(arr));
      }
  }
