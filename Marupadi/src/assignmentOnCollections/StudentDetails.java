package assignmentOnCollections;
import java.io.*;
import java.util.*;

public class StudentDetails {

	public static void main(String[] args)
	{
		StudentDetails object=new StudentDetails();
		ArrayList<StudentPojoArray> studentList=new ArrayList<StudentPojoArray>();
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
		System.out.println("17. Trim array list to it's size");
		System.out.println("18. Display array lists with index value");
		System.out.println("19. Compare two array lists");
		
		
		System.out.println("20. Quit student details ");
		
		
		byte chooseAChoice=input.nextByte();
		switch(chooseAChoice)
       {
       case 1:object.getStudentDetails(studentList);
		      break;
		      
		      
       case 2:char choice;
       System.out.println("Do you want to append a student detail in first position ---press 'Y' or 'N' ");
      choice=input.next().charAt(0);
      if(choice=='Y')
{
	appendDetailsFirstIndex(studentList);
}
      else
	System.out.println("End of execution");
break;
       case 3:object.displayStudentDetails(studentList);
              break;

       case 4:retriveUsingIndex(studentList);
              break;
              
       case 5: removeDetails(studentList);
               break;
               
       case 6:searchThroughRollNumber(studentList);
              break;
              
       case 7:updateStudentList(studentList);
              break;
              
       case 8:sortingStudents(studentList);
              break;
              
       case 9: cloningArrayList(studentList);
               break;
               
       case 10: shuffleArrayList(studentList);
               break;
               
       case 11:object.reverseStudentDetails(studentList);
               break;
               
       case 12:object.extractPortion(studentList);
               break;
               
       case 13:object.swapTwoDetails(studentList);
               break;
               
       case 14:object.deleteAllDetails(studentList);
                 break;
                 
       case 15:object.checkIsEmpty(studentList);
               break;
               
       case 16:object.joinArrayList(studentList);
                break;
                
       case 17:object.trimArrayList(studentList);
                break;
          
       case 18:object.displayWithIndex(studentList);
       break;

       case 19:object.compareArrayLists(studentList);
       break;

       case 20:isTrue=false;
       break;
       default:System.out.println("Enter the valid choice ");
    	   
       }
	}
	}



	private void compareArrayLists(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
		ArrayList<StudentPojoArray> studentList2=new ArrayList<StudentPojoArray>();
		System.out.println("Enter first array list elements ");
 	   
		this.getStudentDetails(studentList);
		System.out.println("Enter second array list elements ");
	 	   
		this.getStudentDetails(studentList2);
		boolean compare=studentList.equals(studentList2);
		if(compare==true)
			System.out.println("Array list elements are equal ");
		else
			System.out.println("Array list elements are not equal ");
	 	   
		
		
	}



	private void displayWithIndex(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
		for(int i=0;i<studentList.size();i++)
System.out.println("Index :" + i +"\nValue : " + studentList.get(i));
		
	}



	private void trimArrayList(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
		studentList.trimToSize();
		System.out.println("Array list trimed to size");
		
		
	}



	public void joinArrayList(ArrayList<StudentPojoArray> studentList)
{
		// TODO Auto-generated method stub
	ArrayList<StudentPojoArray> studentList2=new ArrayList<StudentPojoArray>();
	this.getStudentDetails(studentList);
	this.getStudentDetails(studentList2);
	studentList.addAll(studentList2);
	this.displayStudentDetails(studentList);
	
		
	}



public void checkIsEmpty(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	if(studentList.isEmpty())
	{
		System.out.println("Student details list has no fields");
	}
	else
	{
		this.deleteAllDetails(studentList);
	}
		
	}



public void deleteAllDetails(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	studentList.clear();
	System.out.println("Student Details are deleted ");
	this.displayStudentDetails(studentList);
		
	}



public void swapTwoDetails(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
    Scanner input=new Scanner(System.in);
	System.out.println("Enter the index positios you want to swap");
	int firstIndex=input.nextInt();
	int secondIndex=input.nextInt();
	//int firstNum=studentList.indexOf(firstNum);
	//int secondNum=studentList.indexOf(secondNum);
	
	Collections.swap(studentList, firstIndex, secondIndex);
	this.displayStudentDetails(studentList);
	
		
	}



public void extractPortion(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the starting and ending index posion of student details you want to extract  ");
	
	int startIndex=input.nextInt();
	int endIndex=input.nextInt();
	ArrayList<StudentPojoArray> sublist=new ArrayList<StudentPojoArray>();
	sublist=(ArrayList<StudentPojoArray>) studentList.subList(startIndex, endIndex+1);
		this.displayStudentDetails(sublist);
	}



public void displayStudentDetails(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	System.out.println("The student details are ");


	for(StudentPojoArray i:studentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}


		
	}



void reverseStudentDetails(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	ArrayList<StudentPojoArray> reverseList=new ArrayList<>();
	for(int i=studentList.size()-1;i>=0;i--)
	{
		reverseList.add(studentList.get(i));
	}
	
	
	System.out.println("Student Details after reverse ");
	this.displayStudentDetails(reverseList);
	
		
	}






private static void shuffleArrayList(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	System.out.println("Student List before shuffle ");
	for(StudentPojoArray i:studentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}
    
	Collections.shuffle(studentList);
		
	System.out.println("Student List after shuffle ");
	for(StudentPojoArray i:studentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}
    	
}



private static void cloningArrayList(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	ArrayList<StudentPojoArray> cloneStudentList=(ArrayList<StudentPojoArray>) studentList.clone();
	System.out.println("Student details from clone list ");
		
	
	for(StudentPojoArray i:cloneStudentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}
    
	}



private static void sortingStudents(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
//Comparator comp=new rollNoComparator();
	Collections.sort(studentList,new rollNoComparator());
	Collections.sort(studentList, new rollNoComp());
	System.out.println("The student details are ");


	for(StudentPojoArray i:studentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}


	
}



private static void updateStudentList(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	for(StudentPojoArray i:studentList)
	{
	System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
	}
        Scanner input=new Scanner(System.in);
		System.out.println("Enter the index position you want to update ");
		int indexValue=input.nextInt();
		System.out.println("Enter the student details to update ");

		StudentPojoArray student=new StudentPojoArray();
		System.out.println("Enter roll number ");
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
		
		studentList.set(indexValue, student);
		
		System.out.println("Display details after update ");

		for(StudentPojoArray i:studentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}

		
	}



private static void searchThroughRollNumber(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the roll number you want to find details ");
	int searchRollNo=input.nextInt();
	for(StudentPojoArray i:studentList)
	{
		if(searchRollNo==i.getRollNo())
		{
	System.out.println(i.toString());
	break;
	}

		
	}



}
	private void getStudentDetails(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
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
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of students you want to give details ");
		count=input.nextInt();

		while(count>0)
		{
StudentPojoArray student=new StudentPojoArray();
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


for(StudentPojoArray i:studentList)
{
System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
}

		
	}
	private static void appendDetailsFirstIndex(ArrayList<StudentPojoArray> studentList) {
		// TODO Auto-generated method stub
		System.out.println("Enter the student details to append it in 1st position ");

		StudentPojoArray student=new StudentPojoArray();
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
		studentList.add(0, student);
		System.out.println("Display details after append ");

		for(StudentPojoArray i:studentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}
		}

		
	
	private static void retriveUsingIndex(ArrayList<StudentPojoArray> studentList)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the index position you want to reteive details ");
		int indexRetrive=input.nextInt();
		System.out.println(studentList.get(indexRetrive));

		
	}
	public static void removeDetails(ArrayList<StudentPojoArray> studentList)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the roll number you want to remove details ");
		int indexRemove=input.nextInt();
		for(StudentPojoArray i:studentList)
		{
		if(i.getRollNo()==indexRemove)
		{
			int r=studentList.indexOf(i);
			studentList.remove(r);
			break;
		}
		}
		System.out.println("Details after remove ");
		for(StudentPojoArray i:studentList)
		{
		System.out.println("Student Roll number: " + i.getRollNo() + "\nName :" + i.getStudentName() + "\nClass :" + i.getStd() + "\nTamil Mark :" + i.getTamilMark() + "\nEnglish Mark :" + i.getEnglishMark() +"\nMaths Mark :"+i.getMathsMark()+ "\nScience Mark :"+i.getScienceMark()+"\nSocial Mark :"+i.getSocialMark()+"\nTotal Marks :" + i.getTotalMark());
		}

	}
	//input.close();

}