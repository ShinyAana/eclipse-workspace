package dsa;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
		list.insertAtBeginning(2);
		list.insertAtPos(1, 4);
		list.insertAtPos(2, 7);
		list.insertAtPos(3, 9);
		list.display();
		System.out.println();
		list.displayRev();
		System.out.println();
		for(int a:list)
		{
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println(list.size());
		System.out.println(list.search(7));
		System.out.println(list.get(1));
		
	}

}
