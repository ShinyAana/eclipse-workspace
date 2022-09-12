package interviewQA;

import java.util.Map;

class Sample1
{
	String name;
	int id;
	public Sample1(String name, int id)
	{
		this.name=name;
		this.id=id;
	}
	public void print(Sample3 a)
	{
		a.poly(this);
	}

}
class Sample2 extends Sample1
{
	 String address;
	
	
	public Sample2(String name, int id,String address)
	{
		super(name, id);
		this.address=address;
		// TODO Auto-generated constructor stub
	}

	public void print(Sample3 a)
	{
		a.poly(this);
	}

	
}
class Sample3
{
	public void poly(Sample1 a)
	{
		System.out.println("Id: " + a.id);
		System.out.println("Name :" + a.name);
	
			}
	public void poly(Sample2 b)
	{
		System.out.println("Id: " + b.id);
		System.out.println("Name :" + b.name);
		System.out.println("Address :" + b.address);
	}

}
public class Sample 
{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample1 object=new Sample2("Sample2 object calling",111,"Sample2 address");
		Sample1 object1=new Sample1("Sample1 program",121);
		//Sample.poly(object);
		//Sample.poly(object1);
		Sample.execute(object);
		Sample.execute(object1);
		
	}
	public static void execute(Sample1 a)
	{
		Sample3 object3=new Sample3();
		a.print(object3);
		//object3.poly(a);
		//object3.poly(object1);
		
	}
	public static void poly(Sample1 a)
	{
		System.out.println("Id: " + a.id);
		System.out.println("Name :" + a.name);
	}
	public static void poly(Sample2 b)
	{
		System.out.println("Id: " + b.id);
		System.out.println("Name :" + b.name);
		System.out.println("Address :" + b.address);
	}



}
