package oops;

/*class Book implements Runnable {
	public void run() {
		for (int i = 1; i < 5; i++) {
			System.out.println("Updating DB");
			
			 try 
			 {
				 Thread.sleep(3000);
				 } 
			 catch (InterruptedException e)
			 {
				 e.printStackTrace(); }
			 
			}
	}
}
*/
class Num extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++)
		{
			System.out.println(i);
		}
	}
}

public class MultithreadingDemo {

	public static void main(String[] args) throws InterruptedException {
		//Book b = new Book();//this is same as Runnable b=new Book();
		//Here we won't inherit the interface..but we are using run()..one among the use case of anonymous class
		
		/*
		 * Runnable b=new Runnable() { public void run() {
		 * System.out.println("Book class converted to anonymous class"); } };
		 * 
		 */
		//Lambda exp
		
		Runnable b=()->
		{
			for(int i=1;i<5;i++)
			{
		System.out.println(" priority Book class converted to anonymous class");
			}
	
		};
     Num n = new Num();
		
		Thread tobj=new Thread(b);
		//tobj.setName("book");
		//System.out.println(tobj.getName());
		
		
		n.start();
		n.join();
		tobj.start();
		tobj.join();
		//tobj.setPriority(Thread.MAX_PRIORITY);
		if(tobj.isAlive())
		{
			System.out.println("book thread is alive");
		}
		
		
		//tobj.join();
		//n.join();
		if(!tobj.isAlive())
		{
			System.out.println("book thread is not alive");
		}
		
		System.out.println("Main Thread");

		// b.updateDB();
		// n.printNum();
	}

}
