package oops;
//this is deadlock prevention code
public class DeadLockDemo
{
	 String s1="Hello";
	 String s2="World";
Thread t1=new Thread()
{
	public void run()
	{
		synchronized (s1) 
		{
			System.out.println(Thread.currentThread().getName() + " locked " +s1);
			
			try {
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		synchronized (s2) {
			System.out.println(Thread.currentThread().getName() + " locked " +s2);
			
		System.out.println(s1+s2);	
		}
		}
		
	}
};
Thread t2=new Thread()
{
	public void run()
	{
		synchronized (s1) {
				System.out.println(Thread.currentThread().getName() + " locked " +s1);
				
				
		synchronized (s2) {
			System.out.println(Thread.currentThread().getName() + " locked " +s2);
			
		System.out.println(s1+s2);	
		}
		}	
		
	}
};

	public static void main(String[] args)
	{
	DeadLockDemo obj=new DeadLockDemo();
	obj.t1.start();
	obj.t2.start();
	}

}
