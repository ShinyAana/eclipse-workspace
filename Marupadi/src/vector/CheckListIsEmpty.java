package vector;

public class CheckListIsEmpty {

	public void checkIsEmpty() {
		// TODO Auto-generated method stub
		if(GetStudentDetails.studentList.isEmpty())
		{
			System.out.println("Student details list has no fields");
		}
		else
		{
			DisplayStudentDetails object=new DisplayStudentDetails();
			object.displayDetails();
			
		
		
	}

}
}
