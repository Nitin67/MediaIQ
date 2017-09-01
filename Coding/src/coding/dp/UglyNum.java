package coding.dp;

import java.util.PriorityQueue;

public class UglyNum {

	public static int uglyNum(int n){
		PriorityQueue<Integer> integers= new PriorityQueue<>();
		if(n<=6)
			return n;
		integers.add(1);
		int num = 0;
		while(n>0){
			num = integers.poll();
			n--;
			if(!integers.contains(num * 2))
				integers.add(num * 2);
			if(!integers.contains(num * 3))
				integers.add(num * 3);
			if(!integers.contains(num * 5))
				integers.add(num * 5);
		}
		return num;
	}
	
	public static void main(String[] args) {
	
		System.out.println(uglyNum(11));
//		System.out.println(uglyNumberByDP(11));
	}
}
