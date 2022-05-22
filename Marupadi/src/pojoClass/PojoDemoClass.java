package pojoClass;
import java.io.*;
import java.util.*;
public class PojoDemoClass {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("Subha");
		emp.setRollNo(234565437l);
		emp.setAddress("56, North Street");
		emp.setAge(34);
		emp.setDesignation("Developer");
		emp.setEmail("abc@gmail.com");
		emp.setPhoneNo("8456723145");

		Employee emp2=new Employee();
		emp2.setName("Aanyaa");
		emp2.setRollNo(774565437l);
		emp2.setAddress("56, North Street");
		emp2.setAge(32);
		emp2.setDesignation("Developer");
		emp2.setEmail("der@gmail.com");
		emp2.setPhoneNo("9456723145");
		
ArrayList<Employee> EmpList=new ArrayList<Employee>();
EmpList.add(emp);
EmpList.add(emp2);
//System.out.println(emp.toString());
//System.out.println(emp2.toString());
for(Employee i:EmpList)
	System.out.println(i.toString());
Scanner in=new Scanner(System.in);
System.out.println("Enter Employee name ");
String name=in.nextLine();

for(Employee i:EmpList)
{
	if(i.getName().equals(name))
	System.out.println(i.toString());
}
in.close();

	}

}
