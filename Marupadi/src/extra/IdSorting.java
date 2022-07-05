package extra;

import java.util.ArrayList;
import java.util.Scanner;

public class IdSorting {

	public static void main(String[] args) 
	{
		IdSorting obj=new IdSorting();
		obj.getStudentInfo();
	}

	private void getStudentInfo()
	{
	Scanner input=new Scanner(System.in);	
	System.out.println("Enter No. of students");
	int n=input.nextInt();
	ArrayList<Student> al=new ArrayList<>();
	System.out.println("Enter details of "+ n + " Students");
	for(int i=0;i<n;i++)
	{
		Student sobj=new Student();
		System.out.println("Enter Student name ");
		String name=input.next();
		System.out.println("Enter Student id ");
		int id=input.nextInt();
		sobj.setsName(name);
		sobj.setId(id);
	al.add(sobj);
	}
	IdSorting obj=new IdSorting();
	
	obj.idSorting(al);
	}

	private void idSorting(ArrayList<Student> al)
	{
		int[] idArr=new int[al.size()];
		int k=0;
		for(Student value:al)
		{
			idArr[k]=value.getId();
			k++;
		}
		for(int i=0;i<idArr.length;++i)
		{
			int j=i;
			while(j>0 && idArr[j-1]>idArr[j])
			{
				int temp=idArr[j-1];
				idArr[j-1]=idArr[j];
				idArr[j]=temp;
				
				j=j-1;
			}
			
		}
		System.out.println("Student id after sorting");
		for(int i:idArr)
		{
		System.out.print(i + " ");
		}
		
	}

}
