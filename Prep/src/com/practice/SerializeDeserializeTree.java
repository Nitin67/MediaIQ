package com.practice;
class Tree
{
	int data;
	Tree left;
	Tree right;
	public Tree(int data) {
		this.data=data;
	}
}

public class SerializeDeserializeTree {

	public static String serialize(Tree root)
	{
		if(root ==null)
			return "#";
		return   root.data +"|" +serialize(root.left)+"|" + serialize(root.right);
	}
	
	public static Tree deserialize(String str)
	{
		String []strArray=str.split("(\\|+)");
		return createTreeRecursive(strArray);
	}
	static int index=0;
	public static Tree createTreeRecursive(String []array)
	{
		
		if(index>=array.length || array[index].compareTo("#")==0 )
		{
			index++;
			return null;
		}
		int data=Integer.parseInt(array[index]);
		index++;
		Tree t=new Tree(data);
		t.left=createTreeRecursive(array);
		
		t.right=createTreeRecursive(array);
		return t;
	
	}
	public static void main(String []args)
	{
		Tree root=new Tree(1);	
		root.left=new Tree(2);
		root.right=new Tree(3);
		root.left.right=new Tree(4);
		System.out.println(serialize(root));
		Tree r= deserialize(serialize(root));
	}
}