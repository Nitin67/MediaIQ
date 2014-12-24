package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LCA {
	
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
		tree t1=lowestCommonAncestor(t, 14, 15);
		System.out.println(t1.data);
		System.out.println(determineLevel(t,t.left.right));
		
	}
	
	public static int determineLevel(tree root,tree t)
	{
		
		if(t==null || root==null)
			return -1;
		if(root==t)
			return 0;
		else
		{
			Queue<tree> queue=new LinkedList<tree>();
			queue.add(root);
			queue.add(null);
			int count =0 ;
			while(!queue.isEmpty())
			{
				if(queue.peek()==t)
				{
					return count;
				}
				else
				{
					tree tr=queue.peek();
					queue.remove();
					if(tr!=null)
					{
						
						if(tr.left!=null)
						queue.add(tr.left);
						if(tr.right!=null)
						queue.add(tr.right);
					}
					else
					{
						if(!queue.isEmpty())
						{
							queue.add(null);
							count++;
						}
						
					}
				}
					
				
			}
		}
		return -1;
	}
	
	
	
	public static tree lowestCommonAncestor(tree t,int a,int b)
	{
		if(t==null)
			return t;
		if(t.data==a || t.data==b)
		return t;
		else
		{
			tree leftNode=lowestCommonAncestor(t.left, a, b);
			tree rightNode=lowestCommonAncestor(t.right, a, b);
			if(leftNode!=null && rightNode!=null)
				return t;
			else if(leftNode!=null)
				return leftNode;
			else if(rightNode!=null)
				return rightNode;
		}
		return null;
	}

}
class tree{
	int data;
	tree left;
	tree right;
}