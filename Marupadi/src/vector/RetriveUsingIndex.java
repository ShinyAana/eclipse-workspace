package vector;

import java.util.Scanner;

public class RetriveUsingIndex {

	public void retriveDetails() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the index position you want to reteive details ");
		int indexRetrive=input.nextInt();
		System.out.println(GetStudentDetails.studentList.get(indexRetrive));

		
	}

}
