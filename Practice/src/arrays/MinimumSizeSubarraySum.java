package arrays;

public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
        int curr_sum = 0;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int min_len = n;
        
        while(end < n) {
            while(curr_sum <= s && end < n)
                curr_sum += nums[end++];
                
            while(curr_sum >= s && start < end) {
                min_len = Integer.min(min_len, end - start);
                curr_sum -= nums[start++];
            }
        }
        return nums.length > 0 ? min_len : 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, arr));
		
	}

}
