package oops;
public class SynchronizedDemo2 extends Thread
{
	StringBuffer sb;
	SynchronizedDemo2(StringBuffer sb) 
	{
	    this.sb = sb;   
	}

public void run()
{
    synchronized(sb) 
    {
        for(int i=1;i<=10;i++){
            System.out.println(i+" : "+sb.charAt(0));
        }
        sb.setCharAt(0, (char) (sb.charAt(0)+1));
    }
}

public static void main(String [] args) throws InterruptedException
{
    StringBuffer sb = new StringBuffer("A");
    Thread t1=new SynchronizedDemo2(sb);
    Thread t2=new SynchronizedDemo2(sb);
    Thread t3=new SynchronizedDemo2(sb);

    t1.start();

    t2.start();

    t3.start();

    Thread.sleep(1000);

    System.out.println("----ProGraM ENDS----");
}
}



