package dsa;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst=new BinarySearchTree(50);
		bst.insert(bst.root, 20);
		bst.insert(70);
		bst.insert(10);
		bst.insert(30);
		bst.insert(25);
		bst.inOrder(bst.root);
		if(bst.search(bst.root,70)==null)
		{
			System.out.println("Not found");
		}
		else
			System.out.println("Found");
		bst.delete(bst.root, 50);
		bst.inOrder(bst.root);
		
	}

}
