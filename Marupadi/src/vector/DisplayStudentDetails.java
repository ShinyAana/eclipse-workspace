package vector;

//import assignmentOnCollections.StudentPojoArray;

public class DisplayStudentDetails {

	public void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("The student details are ");


		for(StudentPojoClass i:GetStudentDetails.studentList)
		{
		//System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		System.out.println(i.toString());
		}
		

		
	}

}
