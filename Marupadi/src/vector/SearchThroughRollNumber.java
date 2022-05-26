package vector;

import java.util.Scanner;


public class SearchThroughRollNumber {

	public void search() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the roll number you want to find details ");
		int searchRollNo=input.nextInt();
		for(StudentPojoClass i:GetStudentDetails.studentList)
		{
			if(searchRollNo==i.getRollNo())
			{
		System.out.println(i.toString());
		break;
		}


	}

}
}
