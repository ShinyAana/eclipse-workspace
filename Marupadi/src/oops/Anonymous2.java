package oops;
class B
{
	public void display()
	{
		System.out.println("Class A display");
	}
}

public class Anonymous2 
{
	static B obj=new B()
	{
		public void display()
		{
			//super.display();
			System.out.println("Anonymous demo display");
			
		}
	};


		public static void main(String[] args)
		{
			// TODO Auto-generated method stub
		obj.display();
		
		}


	}

}
