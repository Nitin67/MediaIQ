package com.tree;

public class KthSmallestElement {
	
	static int k=2;
	static int kthsmallestElement(tree root)
	{
		if(root!=null)
		{
		 int left= kthsmallestElement(root.left);
		 if(k>0)
			 k--;
		 if(left>0)
			 return left;
		 if(k==0)
			 return root.data;
		 
	
		return kthsmallestElement(root.right);
		}
		return -1;
			
	}
	public static void main(String []args)
	{
		tree t= new tree();
		t.data=20;
		t.left= new tree();
		t.right=new tree();
		t.left.data=17;
		t.right.data=25;
		t.left.left=new tree();
		t.left.right= new tree();
		t.right.left= new tree();
		t.right.right= new tree();
		t.left.left.data=12;
		t.left.right.data=18;
		t.right.left.data=22;
		t.right.right.data=26;
		System.out.println(kthsmallestElement(t)); 
	}

}
