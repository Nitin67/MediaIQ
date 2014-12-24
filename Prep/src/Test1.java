import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Test1 {

	public static int [] construct(int ar[])
	{
		int x=(int)Math.ceil(Math.log(ar.length)/Math.log(2) );
		int max_size=2*(int)Math.pow(2, x)-1;
		int st[]=new int[max_size];
		constructUtil(ar,0,ar.length-1,st,0);
		return st;
	}
	private static int constructUtil(int[] ar, int i, int j, int[] st, int k) {
		if(i==j)
		{
			st[k]=ar[i];
			return st[k];
		}
	
		int mid=i+(j-i)/2;
		st[k]= constructUtil(ar, i, mid, st, 2*k+1)+constructUtil(ar, mid+1, j, st, 2*k+2);
		return st[k];
	}
	public static void main(String []args)
	{
		Stack<Integer> s=new Stack<Integer>();
		s.empty();
		List<Stack<Integer>> list = new ArrayList<Stack<Integer>>();
		int ar[]={1,3,5,7,9,11};
		System.out.println(construct(ar));
		
	}
}
