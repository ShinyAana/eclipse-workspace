package mentorSathishSan;
class Shape {
	   public void display() {
	      System.out.println("Inside shape");
	   }
	}
	class Rectangle extends Shape {
	   public void area() {
	      System.out.println("Inside area");
	   }
	}
	class Cube extends Rectangle {
	   public void volume() {
	      System.out.println("Inside volume");
	   }
	}
public class InheritanceDemo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		  Cube cube = new Cube();
	      cube.display();
	      cube.area();
	      cube.volume();
	   

	}

}
