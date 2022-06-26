package queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQComp {

	public static void main(String[] args)
	{
		Queue<Integer> testIntegersPQ = new PriorityQueue<>(new CustomIntegerComparator());
		testIntegersPQ.add(11);
        testIntegersPQ.add(5);
        testIntegersPQ.add(-1);
        testIntegersPQ.add(12);
        testIntegersPQ.add(6);

        System.out.println("Integers stored in reverse order of priority in a Priority Queue\n");
        while (!testIntegersPQ.isEmpty()) {
            System.out.println(testIntegersPQ.poll());
        }
	}

}
