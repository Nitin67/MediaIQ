package com.tree;

class AVLTreeNode{
	int data;
	int height;
	AVLTreeNode left;
	AVLTreeNode right;
	public AVLTreeNode(int data) {
		this.data=data;
		this.height=0;
	}
}
public class AVLTree {
	

	 public static void main(String []args)
	 {
		 AVLTree avlTree= new AVLTree();
		 AVLTreeNode root=null;
		 root= insert(root,12);
		 root=insert(root,13);
		 root=insert(root,16);
		 root=insert(root,9);
		 root=insert(root,2);
	 }
	 public static AVLTreeNode insert(AVLTreeNode root,int data)
	 {
	
		 if(root==null){
			 root= new AVLTreeNode(data);
		 }
		 else if(data < root.data)
		 {
			 root.left=insert(root.left,data);
			 if(Math.abs(height(root.left)-height(root.right))>1)
			 {
			 if(data<root.left.data)
			 {
				 root=leftRotate(root);
			 }
			 else
				 root=doubleLeftRotate(root);
			 }
		 }
		 else
		 {
			 root.right=insert(root.right,data);
			 if(Math.abs(height(root.left)-height(root.right))>1)
			 {
				 if(data>=root.right.data)
				 {
					 root=rightRotate(root);
				 }
				 else
				 {
					 root=doubleRightRotate(root);
				 }
			 }
		 }
		 
		 root.height=height(root);
		 return root;
		 
	 }
	 public static AVLTreeNode leftRotate(AVLTreeNode node)
	 {
		 AVLTreeNode left=node.left;
		 node.left=left.right;
		 left.right=node;
		 left.height=height(left);
		 node.height=height(node);
		 return left;
	 }
	 private static int height(AVLTreeNode root) {
		if(root==null)
		 return 0;
		else
		{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
	public static AVLTreeNode rightRotate(AVLTreeNode node)
	 {
		 AVLTreeNode right=node.right;
		 node.right=right.left;
		 right.left=node;
		 right.height=height(right);
		 node.height=height(node);
		 return right;
	 }
	 public static AVLTreeNode doubleLeftRotate(AVLTreeNode node)
	 {
		 node.left=rightRotate(node.left);
		 return leftRotate(node);
	 }
	 public static AVLTreeNode doubleRightRotate(AVLTreeNode node)
	 {
		 node.right=leftRotate(node.right);
		 return rightRotate(node);
	 }

}
