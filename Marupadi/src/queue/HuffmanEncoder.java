package queue;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;

class HuffManNode{
	int item;     
	char ch; 
	HuffManNode right;  
	HuffManNode left;    
}

public class HuffmanEncoder implements Comparator<HuffManNode> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 4;   
		char[] chArr = {'b','c','a','d'};  
		int[] charFreq = {1,6,5,3};  
		PriorityQueue<HuffManNode> q = new PriorityQueue<HuffManNode>(len,new HuffmanEncoder()); 
 
		for(int i=0;i<len;i++)    
		{   
			HuffManNode hmf = new HuffManNode();  
			hmf.ch = chArr[i]; 
			hmf.item = charFreq[i]; 
			hmf.left = null;
			hmf.right = null;
			q.add(hmf);
		} 
		HuffManNode root = null; 
		while(q.size() > 1) 
		{ 
			HuffManNode x = q.peek();
			q.poll();
			HuffManNode y = q.peek();
			q.poll();  
			
			HuffManNode freq = new HuffManNode();
			freq.item = x.item + y.item;
			freq.ch = '-';
			freq.left = x; 
			freq.right = y;
			root = freq;
			
			q.add(freq);
			
		}
		System.out.println(" Char | Huffman code "); 
    System.out.println("--------------------");
    printCode(root, "");
	}

	private static void printCode(HuffManNode root, String str) {
		// TODO Auto-generated method stub
		if(root.left == null && root.right == null && Character.isLetter(root.ch))
		{
			System.out.println(root.ch+" | "+str);
			return;
		}
		printCode(root.left, str+"0");
		printCode(root.right, str+"1");
	}

	@Override
	public int compare(HuffManNode x, HuffManNode y) {
		// TODO Auto-generated method stub
		return x.item - y.item;
	}

}
/*create a priority queue Q consisting of each unique character.
sort then in ascending order of their frequencies.
for all the unique characters:
    create a newNode
    extract minimum value from Q and assign it to leftChild of newNode
    extract minimum value from Q and assign it to rightChild of newNode
    calculate the sum of these two minimum values and assign it to the value of newNode
    insert this newNode into the tree
return rootNode*/


	
