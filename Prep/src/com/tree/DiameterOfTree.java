package com.tree;

class TreeNod{
	int data;
	TreeNod left;
	TreeNod right;
}


public class DiameterOfTree {

	TreeNod root=null;
	
	public TreeNod insertUtil(TreeNod temp,int data)
	{
		if(temp==null)
		{
			temp=new TreeNod();
			temp.data=data;
			temp.left=null;
			temp.right=null;
			return temp;
		}
		else if(temp.data<data)
			{
				temp.right=insertUtil(temp.right, data);
			}
		else
		{
			temp.left= insertUtil(temp.left, data);
		}
		
		return temp;
	}
	public void insert(int data)
	{
		
		root=insertUtil(root, data);
		
	}
	
	
	
	public static void main(String []args)
	{
		DiameterOfTree diameterOfTree=new DiameterOfTree();
		diameterOfTree.insert(6);
		diameterOfTree.insert(3);
		diameterOfTree.insert(9);
		diameterOfTree.insert(8);
		diameterOfTree.insert(7);
		diameterOfTree.insert(5);
		diameterOfTree.insert(2);
		System.out.println("ok");
	}
	
	
}

