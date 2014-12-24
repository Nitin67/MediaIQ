package com.tree;

public class KthDistanceNode {
	
	static void printkthdistancenode(tree t,int k,int data,boolean visited)
	{
		printkthdistancenode(t.left, k, data, visited);
		if(t.data==data)

		printkthdistancenode(t.right, k, data, visited);
		
	}
	public static void main(String []args)
	{
		tree t= new tree();
		t.data=20;
		t.left= new tree();
		t.right=new tree();
		t.left.data=17;
		t.right.data=16;
		t.left.left=new tree();
		t.left.right= new tree();
		t.right.left= new tree();
		t.right.right= new tree();
		t.left.left.data=12;
		t.left.right.data=13;
		t.right.left.data=14;
		t.right.right.data=15;
	}

}
