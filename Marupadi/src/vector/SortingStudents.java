package vector;

import java.util.Collections;

//import assignmentOnCollections.StudentPojoArray;
import assignmentOnCollections.rollNoComparator;

public class SortingStudents {

	public void sortingDetails()
	{
		// TODO Auto-generated method stub
		Collections.sort(GetStudentDetails.studentList,new rollNoComparator());
		System.out.println("The student details are ");


		for(StudentPojoClass i:GetStudentDetails.studentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}


		
	}

}
