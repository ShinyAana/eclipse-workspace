package learn;

public class Eliminate3rd {

}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EliminatePeople {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the Number of People in a group");
		int N=input.nextInt();
		System.out.println("Enter the Value of X ");
		int x=input.nextInt();
		getOrderOfElimination(N, x);
		
	}
	public static void getOrderOfElimination(int n, int x){
		Scanner input=new Scanner(System.in);
        int[] array = new int[n];
        List<Integer> result = new ArrayList<Integer>();
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++)
            array[i] = input.nextInt();
         while(n >= x){
             
             result.add(array[x-1]);
             array = rotateArray(array,x);
             n = array.length;
         }
         for(int printResult:result) {
        	 System.out.print(printResult+" ");
         }
         
        
    }
    
    public static int[] rotateArray(int[] array, int x){
        
        int[] res = new int[array.length-1];
        int pos = 0;
        for(int i = x;i<array.length;i++)
            res[pos++] = array[i];
        for(int i=0;i<x-1;i++)
            res[pos++] = array[i];
        return res;
    }

}