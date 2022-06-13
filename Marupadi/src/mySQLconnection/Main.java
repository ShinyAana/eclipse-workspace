package mySQLconnection;
import java.util.Scanner;


public class Main {
public static void main(String[] args) {
	MySQLConnectionDemo mySQLCon=new MySQLConnectionDemo();
	Student s=new Student();
	Scanner sc=new Scanner(System.in);
	int sId;
	System.out.println("Enter the Details");
	System.out.print("Student id           :");
	sId=sc.nextInt();
	sc.nextLine();
	System.out.print("Student Name         :");
	String sName=sc.nextLine();
	System.out.print("Student Age          :");
	int sAge=sc.nextInt();
	sc.nextLine();
	System.out.print("Student Mail Id      :");
	String sMail=sc.next();
	System.out.print("Student Phone Number :");
	long sPhNum=sc.nextLong();
	s.setsId(sId);
	s.setsName(sName);
	s.setsAge(sAge);
	s.setEmailId(sMail);
	s.setPhNumber(sPhNum);
	mySQLCon.executeInsertStatment(s);
	System.out.println("SID\t\tName\t\tAge\t\tEmail Id\tPhone Number");
	mySQLCon.executeSelectStatment();
	mySQLCon.close();
}
}
