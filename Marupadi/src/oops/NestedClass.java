package oops;

class Outer
{
	private int a=10;
	static int b=5;
	public void showOut()
	{
		Inner obj3=new Inner(); 
		obj3.show();
		Inner.smethod();
		System.out.println(obj3.a);
		System.out.println(Outer.Inner.b);
		System.out.println("Outer class show");
		System.out.println(a);
		System.out.println(b);
	}
	 class Inner
	{
		int a=20;
		static int b=15;
		static void smethod()
		{
			System.out.println("Static method in inner class");
		}
		
		void show()
		{
			
			  Outer out=new Outer(); 
			 // out.showOut(); throws stack overflow error
			System.out.println(out.a);
			System.out.println(Outer.b);
			System.out.println("Inner class show method");
			
		}
		
		
	}

}



public class NestedClass 
{
	
	public static void main(String[] args)
	{
		Outer obj=new Outer();
		obj.showOut();
		
		// TODO Auto-generated method stub
		Outer.Inner obj1=obj.new Inner();
		obj1.show();
		

	}
	

}
