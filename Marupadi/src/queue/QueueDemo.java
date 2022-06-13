package queue;
import java.util.LinkedList;
import java.util.Queue;
 
public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		 
        queue.add(100);
        queue.add(200);
 
        System.out.println("Peek = " + queue.peek());
        System.out.println("Queue size = " + queue.size());
 
        System.out.println("poll = " + queue.poll());
        System.out.println("Queue size = " + queue.size());
 
        System.out.println("remove = " + queue.remove());
        System.out.println("Queue size = " + queue.size());
 
        //calling the methods on empty queue, to test the null return value and exception throw
        System.out.println("Peek = " + queue.peek());
        System.out.println("poll = " + queue.poll());
        System.out.println("remove = " + queue.remove());
    }
} 
 
/*
 * Output: Peek = 100 Queue size = 2 poll = 100 Queue size = 1 remove = 200
 * Queue size = 0 Peek = null poll = null Exception in thread "main"
 * java.util.NoSuchElementException at
 * java.util.LinkedList.removeFirst(LinkedList.java:270) at
 * java.util.LinkedList.remove(LinkedList.java:685) at Test.main(Test.java:24)
 * 
 */
	
