package vector;

import java.util.Scanner;


public class UpdateStudentList {

	public void update() 
	{
	
		Scanner input=new Scanner(System.in);
		System.out.println("Enter roll number to be update ");
		int roll=input.nextInt();
		input.nextLine();
		System.out.println("Enter name");
		String nameUpdate=input.nextLine();
		
		System.out.println("Display details after update ");

		for(StudentPojoClass i:GetStudentDetails.studentList)
		{
			if(roll==i.getRollNo())
			{
				i.setStudentName(nameUpdate);
			
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}
		}
		
			

		
	}

}
