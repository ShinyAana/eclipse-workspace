package dsa;

import java.util.Iterator;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.insertAtBeginning(6);
		list.insertAtPos(1, 7);
		list.insertAtBeginning(5);
		list.insertAtPos(3, 8);
		list.display();
		System.out.println();
		for(int a:list)
		{
			System.out.print(a + " ");
		}
		System.out.println();
		Iterator<Integer> it=list.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		int a=list.search(7);
		System.out.println(a);
		int size=list.size();
		System.out.println();
		System.out.println(size);
		int b=list.get(3);
		//System.out.println();
		System.out.println(b);
		//list.head.next.next.next.next=list.head;

	}

}
