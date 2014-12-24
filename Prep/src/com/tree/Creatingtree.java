package com.tree;

class nod
{
	char data;
	nod left;
	nod right;
}
class IntVal
{
int index;	
}
public class Creatingtree {

	public static nod createNod(char c)
	{
		nod n=new nod();
		n.data=c;
		n.left=null;
		n.right=null;
		return n;
	}
	public static void main(String []args)
	{
		
		String str="(A(B(D)(E(l)(m)))(C(F)(G))";
		char []strArray=str.toCharArray();
		System.out.println(strArray.length);
		IntVal ind=new IntVal();
		ind.index=0;
		nod root=createTreeFromArray(strArray,ind);
		System.out.println();
	}

	private static nod createTreeFromArray(char[] strArray,IntVal ind) {
		if(strArray.length==ind.index)
			return null;
		
		nod newNode=null;
		if(strArray[ind.index]=='(')
		{
			newNode=createNod(strArray[ind.index+1]);
			ind.index+=2;
			if(strArray[ind.index]==')' )
			{
				while( strArray.length-1>=ind.index && strArray[ind.index]==')' )
				ind.index+=1;
				return newNode;
			}
			newNode.left=createTreeFromArray(strArray, ind);
			newNode.right=createTreeFromArray(strArray, ind);
		}
		else if(strArray[ind.index]==')')
		{
			while( strArray.length-1>=ind.index && strArray[ind.index]==')' )
			ind.index++;
			return null;
		}
		return newNode;
	}
}
