package oops;
class Table
{
    synchronized void printTable(int n)
	{
		for(int i=1;i<=5;i++)
		System.out.println(i*n);
	}
}
public class SynchronizedMultiThread {

	public static void main(String[] args) 
	{
		Table t=new Table();
		
		Thread t1=new Thread()
				{
			public void run()
			{
				try {
					
					Thread.sleep(5000);
					t.printTable(13);
					
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				};
				Thread t2=new Thread()
				{
			public void run()
			{
				t.printTable(10);;
			}
				};
				
				t1.start();
				t2.start();
	
	}

}
