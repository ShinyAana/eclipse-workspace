package vector;

import java.util.Collections;


public class ShuffleVectorList {

	public void shuffleDetails() {
		// TODO Auto-generated method stub
		System.out.println("Student List before shuffle ");
		DisplayStudentDetails object=new DisplayStudentDetails();
		object.displayDetails();
		Collections.shuffle(GetStudentDetails.studentList);
			
		System.out.println("Student List after shuffle ");
		
		object.displayDetails();
	}

}
