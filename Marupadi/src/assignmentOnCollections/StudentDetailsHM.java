package assignmentOnCollections;
import java.io.*;
import java.util.*;

public class StudentDetailsHM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		StudentDetailsHM objectHM=new StudentDetailsHM();
		HashMap<Integer,StudentPojoArray> studentHashmap=new HashMap<>();
		boolean isTrue=true;
		while(isTrue)
		{
		
		System.out.println("Enter the choice");
        System.out.println("1. Enter Student Details");
        System.out.println("2. Retrive specified student detail using admission number");
		System.out.println("3. Separate key value pair in Student Details");
		System.out.println("4. Set view of Student Details");
		System.out.println("5. Count number of entries in Student Details");
		System.out.println("6. Copy Student Details into another map");
		System.out.println("7. Remove all Student Details");
		System.out.println("8. Check Student Details hashmap is empty or not");
		
		
		System.out.println("9. Exit");
		byte choice=input.nextByte();
		
			switch(choice)
			{
			case 1:objectHM.getStudentDetails(studentHashmap);
			        break;
			        
			case 2:objectHM.retriveStudentDetails(studentHashmap);
				break;
			        
			case 3:objectHM.separateKeyValue(studentHashmap);
			        break;
			        
			case 4:objectHM.setViewStudentDetails(studentHashmap);
			       break;
			       
			case 5:objectHM.countEntries(studentHashmap);
			        break;
			        
			case 6:objectHM.makeAcopy(studentHashmap);
			       break;
			       
			case 7:objectHM.removeAllDetails(studentHashmap);
			       break;
			       
			case 8:objectHM.checkEmpty(studentHashmap);
			       break;
			        
			case 9:isTrue=false;
			        break;
			}
			
		}


	}

	
	private void retriveStudentDetails(HashMap<Integer, StudentPojoArray> studentHashmap) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
        System.out.println("Enter Admission number ");
         int adNo=in.nextInt();
         System.out.println(studentHashmap.get(adNo));

	}


	private void checkEmpty(HashMap<Integer, StudentPojoArray> studentHashmap) 
	{
		// TODO Auto-generated method stub
		if(studentHashmap.isEmpty()==true)
		{
			System.out.println("Hashmap has no entries ");
		}
		else
		{
			System.out.println("Hashmap has " + studentHashmap.size()+" entries ");
		}
		
	}

	private void removeAllDetails(HashMap<Integer, StudentPojoArray> studentHashmap)
	{
		// TODO Auto-generated method stub
		studentHashmap.clear();
		this.checkEmpty(studentHashmap);
		
	}

	private void makeAcopy(HashMap<Integer, StudentPojoArray> studentHashmap) {
		// TODO Auto-generated method stub
		HashMap<Integer,StudentPojoArray> studentHashmapCopy=new HashMap<>();
		
		studentHashmapCopy.putAll(studentHashmap);
		System.out.println("Copied hash map ");
		System.out.println(studentHashmapCopy);
		
	}

	private void countEntries(HashMap<Integer, StudentPojoArray> studentHashmap)
	{
		// TODO Auto-generated method stub
		int n=studentHashmap.size();
		System.out.println("Number of students in the list " + n);
		
	}

	private void setViewStudentDetails(HashMap<Integer, StudentPojoArray> studentHashmap)
	{
		// TODO Auto-generated method stub
		//Set s=studentHashmap.entrySet();
		//System.out.println(s);
		
		System.out.println("Student Details");
		System.out.println(studentHashmap.keySet());
		System.out.println(studentHashmap.values());
		
		
		
		
		
	}

	private void separateKeyValue(HashMap<Integer, StudentPojoArray> studentHashmap) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Iterator i=studentHashmap.entrySet().iterator();
		while(i.hasNext())
		{
			Map.Entry<Integer, StudentPojoArray> mapentry=(Map.Entry)i.next();
			Integer o1=mapentry.getKey();
			StudentPojoArray o1Details=mapentry.getValue();
			System.out.println(mapentry.getKey());
			System.out.println(mapentry.getValue());
			//o1Details.equals(i)
			System.out.println("Enter roll number to get grade");
			int r=in.nextInt();
			if(( o1Details).getRollNo()==r)
				System.out.println(( o1Details).getGrade());
			else
				System.out.println("Enter valid roll number");
		}
		
	}

	private void getStudentDetails(HashMap<Integer, StudentPojoArray> studentHashmap) 
	{
		// TODO Auto-generated method stub
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
	while(count>0)
			{
	StudentPojoArray student=new StudentPojoArray();
	System.out.println("Enter Admission number ");
	admissionNo=input.nextInt();

	byte existCheck=checkAlreadyExists(studentHashmap,admissionNo);
	if(existCheck==0)
	{
    
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

	studentHashmap.put(admissionNo, student);
	}
	else
		System.out.println("Admission number already exists ...Enter valid admission number");	
	count--;
			}
System.out.println("The Student Details are ");
System.out.println(studentHashmap);
		
		
	}


	private byte checkAlreadyExists(HashMap<Integer, StudentPojoArray> studentHashmap, int admissionNo) {
		// TODO Auto-generated method stub
		if(studentHashmap.containsKey(admissionNo))
			return -1;
		else
		    return 0;
	}

}
