package com.housing;


class Tree
{
	int data;
	Tree left;
	Tree right;
}


public class TreeToDLL {
	Tree root=null;
	Tree prev=null;
	public Tree addNodeUtil(Tree node,int data)
	{
		if(node==null){
		Tree tree=new Tree();
		tree.data=data;
		tree.left=null;
		tree.right=null;
		return tree;
		}
		else if(data>node.data){
			node.right=addNodeUtil(node.right, data);
		}
		else
		{
			node.left=addNodeUtil(node.left, data);
		}
			return node;
	}
	public void addNode(int data)
	{
		
		root=addNodeUtil(root,data);
		
	}
	public void treeTodll()
	{
		
		treeTodllUtil(root);
		while(root.left!=null)
			root=root.left;
		
	}
	
	private void treeTodllUtil(Tree root2) {
		
		if(root2!=null){
		if(root2.left!=null)
			treeTodllUtil(root2.left);
		if(prev!=null){
			prev.right=root2;
			root2.left=prev;
			prev=root2;
		}
		else
			prev=root2;
		
		if(root2.right!=null)
			treeTodllUtil(root2.right);
		}
	}
	public void display()
	{
		Tree temp=root;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.right;
		}
	}
	public static void main(String []args)
	{
		TreeToDLL dll= new TreeToDLL();
		dll.addNode(5);
		dll.addNode(3);
		dll.addNode(7);
		dll.addNode(4);
		dll.addNode(8);
		dll.addNode(6);
		dll.addNode(2);
		dll.treeTodll();
		dll.display();
		
	}
	
}
