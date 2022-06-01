package oops;
interface In1
{
	void stand();
    final int a = 10;
    void walk();
    void rat();
    void eat();
    default void display()
    {
        System.out.println("Interface 1 hello");
    }
}
  interface In2
  {
	  static int b=45;
	  void walk();
	  default void walkdefault()
	  {
		  System.out.println("in 2 default hello");
		    
	  }
	  static void walkStatic()
	  {
		  System.out.println("Interface 2 static hello");
		    
	  }
  }
public class InterfaceDemo implements In1,In2 {
static void walkStatic()
	{
		System.out.println("walk static in parent class ");
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceDemo obj=new InterfaceDemo();
		obj.display();
		System.out.println(a);
		System.out.println(b);
		In2.walkStatic();
		obj.walkdefault();
		obj.walk();
		walkStatic();
	    
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("hello walk");
	    
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub
		System.out.println("hello in stand");
	    	
	}

	@Override
	public void rat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	
	
}
