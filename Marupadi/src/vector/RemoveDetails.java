package vector;

import java.util.Scanner;

//import assignmentOnCollections.StudentPojoArray;

public class RemoveDetails {

	public void removeDetails() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the roll number you want to remove details ");
		int indexRemove = input.nextInt();

		for (StudentPojoClass i : GetStudentDetails.studentList)
		{
			if (i.getRollNo() == indexRemove)
			{
				int r=GetStudentDetails.studentList.indexOf(i);
				GetStudentDetails.studentList.remove(i);
                break;
			}
				
		}
		System.out.println("Student Details after remove roll number ");
		
		  DisplayStudentDetails displayStudentDetails = new DisplayStudentDetails();
		   displayStudentDetails.displayDetails();
		
		  
		 

	}

}
