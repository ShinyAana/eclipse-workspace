package dsa;

import dsa.BinaryTree.Node;

public class BinarySearchTree {
Node root;
	class Node
	{
		int key;
		Node left,right;
		public Node(int val)
		{
			key=val;
			left=right=null;
		}
	}
public BinarySearchTree(int val)
{
	root=new Node(val);
}
public BinarySearchTree()
{
	root=null;
}
public void insert(int val)
{
	insert(root,val);
}
public Node insert(Node root,int val)
{
	if(root==null)
		return new Node(val);
	if(val<root.key)
		root.left=insert(root.left,val);
	else if(val>root.key)
		root.right=insert(root.right,val);
	return root;
}
public Node search(Node root,int val)
{
	if(root==null || root.key==val)
		return root;
	if(val<root.key)
		return search(root.left,val);
	return search(root.right,val);
}
public Node getParentNode(Node node, int val) {
    if(node == null) {
      return null;
    }
    
    Node getParent = null;
    
    while(node != null) {
      if(val < node.key) {
        getParent = node;
        node = node.left;
      } else if (val > node.key) {
        getParent = node;
        node = node.right;
      } else {
        break;
      }
    }

    return getParent;
  }
public Node getSiblingNode(Node node, int val) {
    if(node == null || node.key == val) {
      return null;
    }
    
    Node parentNode = null;
    
    while(node != null) {
      if(val < node.key) {
        parentNode = node;
        node = node.left;
      } else if(val > node.key) {
        parentNode = node;
        node = node.right;
      } else {
        break;
      }
    }
    
    if(parentNode.left != null && val == parentNode.left.key) {
      return parentNode.right;
    }
    
    if(parentNode.right != null && val == parentNode.right.key) {
      return parentNode.left;
    }
    
    return null;
  }  

public  void inOrder(Node root)
{
	if(root!=null)
	{
	inOrder(root.left);
	System.out.print(root.key + " ");
	inOrder(root.right);
	}
	
}
public Node delete(Node root,int val)
{
	if(root==null)
		return root;
	if(val>root.key)
		root.right=delete(root.right,val);
	else if(val<root.key)
		root.left=delete(root.left,val);
	else
	{
		if(root.left==null)
			return root.right;
		else if(root.right==null)
			return root.left;
		root.key=min(root.right);
		root.right=delete(root.right,root.key);
	}
	return root;
	}
public void delete(int val)
{
	root=delete(root,val);
}
public int min(Node root) {
	int minValue=root.key;
	while(root.left!=null)
	{
	  minValue=root.left.key;
	  root=root.left;
	}
	return minValue;

}
public int getMax(Node node) {
    if(node == null) {
      System.out.println("Tree is EMpty");
      return -1;
    }
    
    while(node.right != null) {
      node = node.right;
    }
    
    return node.key;
  }

}

