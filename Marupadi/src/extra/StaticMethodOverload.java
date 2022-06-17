package extra;
class SuperClass {
	   public static void display() {
	      System.out.println("SuperClass.display()");
	   }

	   //Method overloading of static method
	   public static void display(int a) {
	      System.out.println("SuperClass.display(int): " + a);
	   }
	}

	class SubClass extends SuperClass {
	   //Not method overriding but hiding
	   public static void display() {
	      System.out.println("SubClass.display()");
	   }
	}

	public class StaticMethodOverload {
	   public static void main(String[] args) {
	      SuperClass object = new SubClass();

	      //SuperClass display method is called
	      //although object is of SubClass.
	      object.display();        
	      object.display(1);    
	   }
	}
