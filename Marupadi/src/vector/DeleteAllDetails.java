package vector;

public class DeleteAllDetails {

	public void deleteDetails() 
	{
		// TODO Auto-generated method stub
		GetStudentDetails.studentList.clear();
		System.out.println("Student Details are deleted ");
		DisplayStudentDetails object=new DisplayStudentDetails();
		object.displayDetails();
		
		
	}

}
