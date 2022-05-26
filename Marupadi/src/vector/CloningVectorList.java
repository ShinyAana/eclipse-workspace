package vector;

import java.util.*;


public class CloningVectorList {

	public void cloneDetails()
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Vector<StudentPojoClass> cloneStudentList=(Vector<StudentPojoClass>) GetStudentDetails.studentList.clone();
		System.out.println("Student details from clone list ");
			
		
		for(StudentPojoClass i:cloneStudentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}

		
	}

}
