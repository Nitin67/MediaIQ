
public class EquilibriumIndex {

	static int getEquilibriumINdex(int a[]){
		int sum = 0;
		for(int i=0;i<a.length;i++){
			sum +=a[i]; 
		}
		int leftSum =0;
		for(int i=0;i<a.length;i++){
			sum = sum - a[i];
			if(leftSum == sum){
				return i;
			}
			leftSum +=a[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[]={-7, 1, 5, 2, -4, 3, 0};
		System.out.println(getEquilibriumINdex(a));
	}
}
