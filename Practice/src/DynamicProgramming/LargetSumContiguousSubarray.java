package DynamicProgramming;

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
	
	public static int getLargestProduct(int[] nums) {
		if(nums.length > 0) {
			if(nums.length ==1 && nums[0] == 0)
				return 0;
			int maxSum = 1;
			boolean zeroPresent = false;
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] != 0)
					maxSum *= nums[i];
				else
					zeroPresent = true;
			}
			
			if(zeroPresent)
				maxSum = Integer.max(maxSum, 0);
			
			if(maxSum >= 0)
				return maxSum;
			int currMax = maxSum;	
			for(int i = nums.length - 2; i >= 0; i--) {
				if(nums[i+1] != 0){
				    currMax = currMax/nums[i+1];
					maxSum = Integer.max(maxSum, maxSum/nums[i+1]);
				}
			}
			return maxSum;
			
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
//		int[] a = {-2, -3, -1, -2, -3};
		int[] a = {-4,-3,-2};
		System.out.println(getLargestProduct(a));
	}

}
