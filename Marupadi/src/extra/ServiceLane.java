package extra;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class ServiceLane {
    public static void main(String[] args) 
    {
    	Scanner input=new Scanner(System.in);
    	
    
        List<List<Integer>> cases = new ArrayList<>();
        cases.add(new ArrayList<Integer>(Arrays.asList(0,3)));
        cases.add(new ArrayList<Integer>(Arrays.asList(4,6)));
        cases.add(new ArrayList<Integer>(Arrays.asList(6,7)));

        cases.add(new ArrayList<Integer>(Arrays.asList(3,5)));

        cases.add(new ArrayList<Integer>(Arrays.asList(0,7)));
        //System.out.println(cases.get(0).get(0));
        //System.out.println(cases.get(0).get(1));

       System.out.println("Enter n");
       int n=input.nextInt();
        List<Integer> result =serviceLane(n, cases);
        System.out.println(result);

		   }

	private static List<Integer> serviceLane(int n, List<List<Integer>> cases) {
		// TODO Auto-generated method stub
List<Integer> result=new ArrayList<>();
    	
    	Scanner input=new Scanner(System.in);
    	int[] width=new int[n];
    	System.out.println("Enter w values");
    	for(int i=0;i<n;i++)
    	{
    		width[i]=input.nextInt();
    	}
    	int start=0,end=0,min=3;
    	for(int i=0;i<cases.size();i++)
    	{
    		start=cases.get(i).get(0);
    		end=cases.get(i).get(1);
    		System.out.println(start + "  "+ end);
    		while(start<=end)
    		{
    			if(min>width[start])
    				min=width[start];
    			start++;
    		}
    		
    		result.add(min);
    		min=3;
    	}
    		
    	
		return result;

	}
}

