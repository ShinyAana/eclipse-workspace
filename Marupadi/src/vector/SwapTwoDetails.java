package vector;

import java.util.Collections;
import java.util.Scanner;

public class SwapTwoDetails {

	public void swapDetails() {
		// TODO Auto-generated method stub
		 Scanner input=new Scanner(System.in);
			System.out.println("Enter the index positios you want to swap");
			int firstIndex=input.nextInt();
			int secondIndex=input.nextInt();
			//int firstNum=studentList.indexOf(firstNum);
			//int secondNum=studentList.indexOf(secondNum);
			
			Collections.swap(GetStudentDetails.studentList, firstIndex, secondIndex);
			
			DisplayStudentDetails object=new DisplayStudentDetails();
			object.displayDetails();
			
		
	}

}
