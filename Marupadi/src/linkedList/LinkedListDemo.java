package linkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> ll=new LinkedList<>();
		LinkedList<String> ll2=new LinkedList<>();
		LinkedList<Integer> ll3=new LinkedList<>();
		ArrayList<String> al=new ArrayList<>();
		ll3.add(11);
		ll3.add(12);
		ll3.add(33);
		al.add("asd");
		al.add("wef");
		al.add("ert");
		ll.add("Priya");
		ll.add("Subha");
		ll.add("Aanyaa");
		ll.add(1, "Selvarani");
		System.out.println(ll);
		ll.addAll(al);
		System.out.println(ll);
		ll.addAll(2, al);
		System.out.println(ll);
		ll.addFirst(null);
		ll.addLast(null);
		System.out.println(ll);
		ll2=(LinkedList)ll.clone();
		System.out.println(ll2);
		//ll.clear();
		//System.out.println(ll);
ll.offer("gr");
System.out.println(ll);
ll.offerFirst("aaa");
System.out.println(ll);
ll.offerLast("zzz");
System.out.println(ll);
System.out.println(ll.peek());

System.out.println(ll.peekFirst());

System.out.println(ll.peekLast());

System.out.println(ll.poll());

System.out.println(ll);

System.out.println(ll.pollFirst());
System.out.println(ll);


System.out.println(ll.pollLast());
System.out.println(ll);
System.out.println(ll.get(3));
System.out.println(ll.getFirst());
System.out.println(ll.getLast());
System.out.println(ll);

//System.out.println(ll3.sort(null));


System.out.println(ll3.toString());
System.out.println(ll.size());
System.out.println(ll.set(0,"Nilavoli"));
System.out.println(ll);
		
	}

}
