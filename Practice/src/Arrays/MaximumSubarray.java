package Arrays;

public class MaximumSubarray {
	
	public static int maxSubArray(int[] nums) {
        int max = 0;
        if(nums.length == 1)
            max = nums[0];
        if(nums.length > 1) {
            int currMax = nums[0];
            int j = 1;
            while(j < nums.length) {
                currMax = Integer.max(nums[j], currMax + nums[j]);
                max = Integer.max(currMax, max);
                j += 1;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, -1};
		System.out.println(maxSubArray(nums));
	}

}
