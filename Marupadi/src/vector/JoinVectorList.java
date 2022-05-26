package vector;

import java.util.*;


public class JoinVectorList {

	public void joinvector() 
	{
		// TODO Auto-generated method stub
		Vector<StudentPojoClass> studentList2=new Vector<StudentPojoClass>();
		GetStudentDetails obj=new GetStudentDetails();
		obj.studentDetails();
		
		System.out.println("Enter second list of students you want to give  ");
		
		
		Scanner input=new Scanner(System.in);
		int rollNo;
		String studentName;
		char std;
		int tamilMark;
		int englishMark;
		int mathsMark;
		int scienceMark;
		int socialMark;
		int totalMark;
	//	char grade;
		int count;
		System.out.println("Enter number of students you want to give details ");
		count=input.nextInt();

		while(count>0)
		{
StudentPojoClass student=new StudentPojoClass();
System.out.println("Enter roll number ");
rollNo=input.nextInt();
input.nextLine();
System.out.println("Enter your name ");
studentName=input.nextLine();
System.out.println("Enter your class ");
std=input.next().charAt(0);
System.out.println("Enter tamil mark ");
tamilMark=input.nextInt();
System.out.println("Enter english mark ");
englishMark=input.nextInt();
System.out.println("Enter maths mark ");
mathsMark=input.nextInt();
System.out.println("Enter science mark ");
scienceMark=input.nextInt();
System.out.println("Enter social mark ");
socialMark=input.nextInt();
totalMark=tamilMark+englishMark+mathsMark+scienceMark+socialMark;
student.setRollNo(rollNo);
student.setStudentName(studentName);
student.setStd(std);
student.setTamilMark(tamilMark);
student.setEnglishMark(englishMark);
student.setMathsMark(mathsMark);
student.setScienceMark(scienceMark);
student.setSocialMark(socialMark);
student.setTotalMark(totalMark);


studentList2.add(student);
count--;
		}

		GetStudentDetails.studentList.addAll(studentList2);
		
		System.out.println("Fina; result after adding two list ");
		DisplayStudentDetails object=new DisplayStudentDetails();
		object.displayDetails();
		
	}

}
