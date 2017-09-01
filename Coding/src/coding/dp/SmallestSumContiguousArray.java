package coding.dp;

public class SmallestSumContiguousArray {
	
	public static int getSmallestContiguousSum(int a[]){
		int minSum=Integer.MAX_VALUE;
		int currentSum= 0;
		
		for (int i = 0; i < a.length; i++) {
			
			int min = a[i];
			if((currentSum + a[i]) > 0){
				currentSum = 0;
			}else{
				currentSum = currentSum + a[i];
				min = currentSum;
			}
			if(minSum > min){
				minSum = min;
			}
		}
		return minSum;
	}
	
	public static void main(String[] args) {
		int arr[] = {3, -4, 2, -3, -1, 7, -5};
		System.out.println(getSmallestContiguousSum(arr));
	}
}
