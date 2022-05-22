package pojoClass;
import java.io.*;
import java.util.*;
public class EmployeePojo {
	int EmpId;
	String Name;
	int Age;
	String PhoneNo;
	public EmployeePojo(int EmpId ,String Name,int Age,String PhoneNo)
	{
		this.EmpId=EmpId;
		this.Name=Name;
		this.Age =Age;
		this.PhoneNo=PhoneNo;
	}
	
	public static void main(String[] args) {
		ArrayList<EmployeePojo> emplist=new ArrayList<EmployeePojo>();
		EmployeePojo emp1=new EmployeePojo(123,"Subha",32,"8967893452");

		EmployeePojo emp2=new EmployeePojo(124,"Rani",31,"7867893452");

		EmployeePojo emp3=new EmployeePojo(125,"Shiny",29,"6767893452");
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Employee id ");
		int id=in.nextInt();
		boolean flag=false;
		for(EmployeePojo e:emplist)
		{
			if(e.EmpId==id)
			{	
			System.out.println(e.EmpId + " " + e.Name + " " + e.Age + " " + e.PhoneNo);
			flag=!flag;
			break;
			}
			
	}
		if(flag==false)
		System.out.println("Not an Employee ");

		in.close();

}
}
