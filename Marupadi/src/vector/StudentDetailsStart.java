package vector;

import java.util.Scanner;

public class StudentDetailsStart {
	public static void main(String[] args)
	{
	//private void flowManager()
	//{
		Scanner input=new Scanner(System.in);
		boolean isTrue=true;
		
		while(isTrue)
		{
       
		System.out.println("Enter the choice ");
		System.out.println("1. Enter Student details");
		System.out.println("2. Append details at first position ");
		System.out.println("3. Display student details ");
		
		System.out.println("4. Retrive the student detail with index ");
		System.out.println("5. Romove student detail ");
		System.out.println("6. Search student detail through roll number ");
		System.out.println("7. Update student details ");
		System.out.println("8. Sorting student details ");
		System.out.println("9. Copy student details into another list ");
		System.out.println("10. Shuffle student details ");
		System.out.println("11. Reverse Student Details ");
		System.out.println("12. Extract a portion of Student Details ");

		System.out.println("13. Swap two  Student Details ");
		System.out.println("14. Delete  Student Details ");
		System.out.println("15. Check Student Details list is empty or not ");
		System.out.println("16. Join two array lists");
		
		System.out.println("17. Quit student details ");
		
		
		byte chooseAChoice=input.nextByte();
		switch(chooseAChoice)
       {
       case 1:new GetStudentDetails().studentDetails();
		      break;
		      
		      
       case 2:char choice;
       System.out.println("Do you want to append a student detail in first position ---press 'Y' or 'N' ");
      choice=input.next().charAt(0);
      if(choice=='Y')
{
	new AppendDetails().appendDetailsFirstIndex();
}
      else
	System.out.println("End of execution");
break;
       case 3:new DisplayStudentDetails().displayDetails();
              break;

       case 4:new RetriveUsingIndex().retriveDetails();
              break;
              
       case 5: new RemoveDetails().removeDetails();
               break;
               
       case 6:new SearchThroughRollNumber().search();
              break;
              
       case 7:new UpdateStudentList().update();
              break;
              
       case 8:new SortingStudents().sortingDetails();
              break;
              
       case 9: new CloningVectorList().cloneDetails();
               break;
               
       case 10: new ShuffleVectorList().shuffleDetails();
               break;
               
       case 11:new ReverseStudentDetails().reverseDetails();
               break;
               
       case 12:new ExtractPortionOfVector().extractDetails();
               break;
               
       case 13:new SwapTwoDetails().swapDetails();
               break;
               
       case 14:new DeleteAllDetails().deleteDetails();
                 break;
                 
       case 15:new CheckListIsEmpty().checkIsEmpty();
               break;
               
       case 16:new JoinVectorList().joinvector();
                break;
          
       case 17:isTrue=false;
       break;
       default:System.out.println("Enter the valid choice ");
    	   
       }
	}

	}
	

}
