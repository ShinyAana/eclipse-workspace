package dsa;

public class BinaryTreeMain {

	public static void main(String[] args)
	{
	BinaryTree tree=new BinaryTree(10);
	tree.insertLeft(tree.root,5);
	tree.insertRight(tree.root,15);
	tree.insertRight(tree.root.right,8);
	tree.insertLeft(tree.root.left,12);
	tree.insertLeft(tree.root.left,3);
	
	
	BinaryTree.preOrder(tree.root);
	System.out.println();
	BinaryTree.inOrder(tree.root);
	
	System.out.println();
	BinaryTree.postOrder(tree.root);
	
	}

}
