package com.tree;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	


}

public class IsTreeAVL {
	
	public static int isTreeAvl(TreeNode root)
	{
		if(root==null)
			return 0;
		int leftHeight=isTreeAvl(root.left);
		if(leftHeight==-1)
			return leftHeight;
		int rightHeight=isTreeAvl(root.right);
		if(rightHeight==-1)
			return rightHeight;
		if(Math.abs(rightHeight-leftHeight)>1)
			return -1;
		return Math.max(leftHeight, rightHeight) +1;
		
	}
	public static void main(String []args)
	{
		TreeNode root =null;
		 root= insert(root,12);
		 root=insert(root,13);
		 root=insert(root,16);
		 root=insert(root,9);
		 root=insert(root,2);
		 root=insert(root,1);
		 int balanceFactor=isTreeAvl(root);
		 if(balanceFactor==-1)
			 System.out.println("Tree is not AVL");
		 else
			 System.out.println("Tree is AVL");
		
	}
	public static TreeNode insert(TreeNode root,int data)
	{	
		if(root==null)
		{
			root=new TreeNode();
			root.data=data;
			root.left=null;
			root.right=null;
		}
		else if(root.data>data)
		{
			root.left=insert(root.left,data);
		}
		else
		{
			root.right= insert(root.right,data);
		}
		return root;
	}

}
