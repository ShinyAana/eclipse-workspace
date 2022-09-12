package dsa;
class LinkedList1 {
    Node head; // head of list
 
    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    void detectLoop()
    {
        Node slow_p = head, fast_p = head;
        int flag = 0;
        while (fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }
    public void detectAndRemoveLoop()
    {
      if (head == null || head.next == null)
        System.out.println("List is empty");
      Node slow = head, fast = head;
      slow = slow.next;
      fast = fast.next.next;
      while (slow!=null&&fast != null && fast.next != null)
      {
        if (slow == fast)
          break;
        slow = slow.next;
        fast = fast.next.next;
      }
      if (slow != fast)
        System.out.println("No loop found");
      slow = head;
      while (slow != fast)
      {
        slow = slow.next;
        fast = fast.next;
      }
      slow.next=null;
    //  System.out.println("Loop start from " + prev.data);
    }
     

}
    public class FloydCycle {
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList1 llist = new LinkedList1();
 
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
        llist.detectLoop();
        
        llist.detectAndRemoveLoop();
        llist.detectLoop();
        
    }
}


