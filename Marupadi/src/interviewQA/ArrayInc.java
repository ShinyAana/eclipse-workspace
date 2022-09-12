package interviewQA;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayInc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input=new Scanner(System.in);
System.out.println("Enter array size");
int n=input.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++)
{
	arr[i]=input.nextInt();
}
int[] res=new int[10];
//ArrayList<Integer> al=new ArrayList<>();
//boolean inc=false;
int temp=arr[n-1]+1;
//al.add(temp%10);
res[0]=temp%10;
int k=1;
for(int i=n-2;i>=0;i--)
{
if(temp>9)
{
	temp=arr[i]+1;
	//al.add(temp%10);
	res[k]=temp%10;
	k++;
}
else
	//al.add(arr[i]);
    res[k]=arr[i];
k++;
}
if(temp>9)
{
	res[k++]=1;
}
//System.out.println(al.size());
for(int i=k;i>=0;i--)
{
	System.out.print(res[i] + " ");
}
//System.out.println(al);

	}
}

