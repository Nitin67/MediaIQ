package coding.dp;

public class MaxSumInArray {

	public static int maxSum(int a[]){
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < a.length; i++) {
			if(currentSum + a[i] > 0){
				currentSum = currentSum + a[i];
			}
			if(maxSum < currentSum){
				maxSum = currentSum;
			}
		}
		return maxSum;
		
	}
	public static void main(String[] args) {
		int a[] ={20, 20, -30, 50, 60};
		System.out.println(maxSum(a));
	}

}

//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/