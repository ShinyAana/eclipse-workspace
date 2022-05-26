package vector;

import java.util.Vector;


public class ReverseStudentDetails {

	public void reverseDetails() {
		// TODO Auto-generated method stub
		Vector<StudentPojoClass> reverseList=new Vector<>();
		for(int i=GetStudentDetails.studentList.size()-1;i>=0;i--)
		{
			reverseList.add(GetStudentDetails.studentList.get(i));
		}
		
		
		System.out.println("Student Details after reverse ");
		DisplayStudentDetails object=new DisplayStudentDetails();
		object.displayDetails();
		
		
		
	}

}
