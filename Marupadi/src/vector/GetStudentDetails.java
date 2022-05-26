package vector;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

//import assignmentOnCollections.StudentPojoArray;

public class GetStudentDetails {
	protected static Vector<StudentPojoClass> studentList=new Vector<StudentPojoClass>();
	
	public void studentDetails() {
		// TODO Auto-generated method stub
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


studentList.add(student);
count--;
		}
		
System.out.println("The student details are ");


for(StudentPojoClass i:studentList)
{
System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
}

		
	}
}