package mentorSathishSan;
import java.io.*;
import java.util.*;
public class TwoSumTarget {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		HashMap<Integer,Integer> resultIndices=new HashMap<Integer,Integer>();
		ArrayList<Integer> inputList=new ArrayList<Integer>();
		System.out.println("Enter size of an Array ");
		int arraySize=input.nextInt();
		System.out.println("Enter any 5 array elements ");
		for(int i=0;i<arraySize;i++)
		{
			int j=input.nextInt();
			inputList.add(j);
		}
		Collections.sort(inputList);
		System.out.println("Sorted Array is  ");
		for(Integer i:inputList)
		System.out.println(i + " ");
		int targetLimit=inputList.get(arraySize-1)+inputList.get(arraySize-2);
		System.out.println("Enter target value upto the limit " + targetLimit);
		int targetValue=input.nextInt();
		for(int index=0;index<inputList.size();index++)
		{
			//int firstIndex=inputList.get(index);
			int difference=targetValue-inputList.get(index);
			int secondIndex=inputList.indexOf(difference);
			if(secondIndex!=-1 && secondIndex!=index)
			{
				resultIndices.put(index,secondIndex);
				break;
			}
			//inputList.remove(index);
			//inputList.remove(secondIndex);
				
			
		}
		System.out.println("Resultant indices ");
		System.out.println(resultIndices);
	}

}
