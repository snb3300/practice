
public class LargetSumContiguousSubarray {

	public static int getLargestSum(int[] a) {
		int maxSum = Integer.MIN_VALUE; 
		if (a.length > 0) {
			maxSum = a[0];
			int currSum = maxSum;
			
			for(int i = 1; i < a.length; i++) {
				currSum = Integer.max(a[i], currSum + a[i]);
				maxSum = Integer.max(currSum, maxSum);
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
//		int[] a = {-2, -3, -1, -2, -3};
		System.out.println(getLargestSum(a));
	}

}
