package learn;


public class BinarySearch {
	public static void main(String[] args) {
		int a[]= {1,4,6,9,12,56,89,114,566};
		int target=56;
		 boolean check =binarySearh(a,target,0,a.length-1);
		 System.out.println(check);
		
	}
	
	private static boolean binarySearh(int[] a, int target, int start, int end)
	{
		
		if(start<=end)
		{
			int mid=(start+end)/2;
			if(a[mid]>target)
			{
				return binarySearh(a, target, start, mid-1);
			}
			else  if (a[mid]<target)
			{
				return binarySearh(a, target, mid+1, end);
			}
			else if(a[mid]==target)
			{
				return true;
			}
			
		}
		return false;
		
		
	}
	

}
