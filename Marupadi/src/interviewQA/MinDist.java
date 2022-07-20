package interviewQA;

public class MinDist {

	public static void main(String[] args) 
	{
	int[] arr= {7,1,3,4,1,7};
	for(int i=0;i<arr.length;i++)
	{
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]==arr[j])
			{
				System.out.println("Min dist between " + arr[i] + " is " + (j-i));
				break;
			}
		}
	}
	}

}
