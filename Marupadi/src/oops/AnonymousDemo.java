package oops;
class A
{
	public void display()
	{
		System.out.println("Class A display");
	}
}
interface In2
{
	
}
public class AnonymousDemo {
	 
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	A obj=new A()
		{
	public void display()
	{
		super.display();
		System.out.println("Anonymous demo display");
		
	}
		};

		obj.display();

	}

}
