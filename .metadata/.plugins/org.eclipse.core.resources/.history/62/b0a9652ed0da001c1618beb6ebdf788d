package vector;

import java.util.Scanner;

import assignmentOnCollections.StudentPojoArray;

public class AppendDetails {

	public void appendDetailsFirstIndex() {
		// TODO Auto-generated method stub
		System.out.println("Enter the student details to append it in 1st position ");

		StudentPojoClass student=new StudentPojoClass();
		System.out.println("Enter roll number ");
		//Scanner input = null;
		Scanner input=new Scanner(System.in);
		int rollNo = input.nextInt();
		input.nextLine();
		System.out.println("Enter your name ");
		String studentName = input.nextLine();
		System.out.println("Enter your class ");
		char std = input.next().charAt(0);
		System.out.println("Enter tamil mark ");
		int tamilMark = input.nextInt();
		System.out.println("Enter english mark ");
		int englishMark = input.nextInt();
		System.out.println("Enter maths mark ");
		int mathsMark = input.nextInt();
		System.out.println("Enter science mark ");
		int scienceMark = input.nextInt();
		System.out.println("Enter social mark ");
		int socialMark = input.nextInt();
		int totalMark = tamilMark+englishMark+mathsMark+scienceMark+socialMark;
		student.setRollNo(rollNo);
		student.setStudentName(studentName);
		student.setStd(std);
		student.setTamilMark(tamilMark);
		student.setEnglishMark(englishMark);
		student.setMathsMark(mathsMark);
		student.setScienceMark(scienceMark);
		student.setSocialMark(socialMark);
		student.setTotalMark(totalMark);
		GetStudentDetails.studentList.add(0, student);
		System.out.println("Display details after append ");

		for(StudentPojoClass i:GetStudentDetails.studentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}

		
	}

}
