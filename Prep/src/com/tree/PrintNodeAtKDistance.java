package com.tree;

class node{
	
	int data;
	node left;
	node right;
	
	

}
class IntClass{
	private int value;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public IntClass(int val) {
		this.value=val;
		// TODO Auto-generated constructor stub
	}
}
public class PrintNodeAtKDistance {
	
	
	public void getMinMax(node root,IntClass min,IntClass max,int hd)
	{
	
		if(root==null)
			return;
		if(min.getValue()>hd)
		{
			min.setValue(hd);
		}
		if(max.getValue()<hd)
			max.setValue(hd);
		
		getMinMax(root.left, min, max, hd-1);
		getMinMax(root.right, min, max, hd+1);
	}
	
	public void printnodeatkdist(node root,int k)
	{
		
		IntClass min=new IntClass(0);
		IntClass max=new IntClass(0);
		
		getMinMax(root, min, max, 0);
		for(int i=min.getValue();i<=max.getValue();i++)
		{
			printvalatlevel(root,i);
			System.out.println();
		}
		System.out.println(min.getValue() + "  " + max.getValue());
	}
	
	
	public void printvalatlevel(node root,int val)
	{
		if(root==null)
			return;
		if(val==0)
			System.out.print(root.data + " ");
		printvalatlevel(root.left, val+1);
		printvalatlevel(root.right, val-1);
	}
	
	public node addNode(int data)
	{
		node temp=new node();
		temp.data=data;
		temp.left=null;
		temp.right=null;
		return temp;
	}
	public static void main(String []args)
	{
		PrintNodeAtKDistance kDistance=new PrintNodeAtKDistance();
		node root=kDistance.addNode(20);
		root.left=kDistance.addNode(8);
		root.right=kDistance.addNode(22);
		root.left.left=kDistance.addNode(4);
		root.left.right=kDistance.addNode(12);
		root.left.right.left=kDistance.addNode(10);
		root.left.right.right=kDistance.addNode(14);
		kDistance.printnodeatkdist(root, 2);
	}

}
