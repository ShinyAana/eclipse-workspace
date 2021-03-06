package hashMap;
import java.io.*;
import java.util.*;

import assignmentOnCollections.StudentPojoArray;

public class GradingSystem {

	public static void main(String[] args)
	{
	  Scanner input=new Scanner(System.in);
	  HashMap<String,String> hm=new HashMap<>();
	  hm.put( "90 and Above","A");
	  hm.put("80 to 89", "B");
	  hm.put("60 to 79", "C");
	  hm.put("35 to 59", "D");
	  hm.put("Below 35", "F");
	  
	  
	  int rollNo;
		String studentName;
		char std;
		int tamilMark;
		int englishMark;
		int mathsMark;
		int scienceMark;
		int socialMark;
		int totalMark;
		int average;
		String grade="";
		int admissionNo;
		int count;
		System.out.println("Enter number of students you want to give details ");
		count=input.nextInt();
HashMap<Integer,StudentPojoArray> studentHM=new HashMap<>();
		while(count>0)
		{
StudentPojoArray student=new StudentPojoArray();
System.out.println("Enter Admission number ");
admissionNo=input.nextInt();

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
average=totalMark/5;
if(average>=90)
	grade=hm.get("90 and Above");
else if(average>=80 && average<=89)
	grade=hm.get("80 to 89");
else if(average>=60 && average<=79)
	grade=hm.get("60 to 79");
else if(average>=35 && average<=59)
	grade=hm.get("35 to 59");
else if(average<35)
	grade=hm.get("Below 35");

student.setRollNo(rollNo);
student.setStudentName(studentName);
student.setStd(std);
student.setTamilMark(tamilMark);
student.setEnglishMark(englishMark);
student.setMathsMark(mathsMark);
student.setScienceMark(scienceMark);
student.setSocialMark(socialMark);
student.setTotalMark(totalMark);
student.setGrade(grade);

studentHM.put(admissionNo, student);
count--;
		}
		
System.out.println("The student details are "); 
	  System.out.println(studentHM);
	}

}
