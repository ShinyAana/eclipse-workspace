package vector;

import java.util.*;

public class ExtractPortionOfVector {

	public void extractDetails() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the starting and ending index posion of student details you want to extract  ");
		
		int startIndex=input.nextInt();
		int endIndex=input.nextInt();
		Vector<StudentPojoClass> sublist=new Vector<StudentPojoClass>();
		sublist=(Vector<StudentPojoClass>) GetStudentDetails.studentList.subList(startIndex, endIndex+1);
		System.out.println("The sublist details are ");	
		
		for(StudentPojoClass i:sublist)
				System.out.println(i.toString());

	}

}
