package arrays;

public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		int minLength = nums.length + 1;
        int curSum = 0;
        int start = 0;
        int i = 0;
        
        while(i <= nums.length) {
            if(curSum >= s) {
                if(start == i - 1)
                    return 1;
                minLength = Integer.min(minLength, i - start);
                curSum -= nums[start++];
            } else {
                if(i == nums.length)
                    break;
                curSum += nums[i++];
            }
        }
        // for(int i = 0; i < nums.length; i++) {
        //     curSum += nums[i];
        //     while(start <= i && curSum >= s) {
        //         minLength = Integer.min(minLength, i - start + 1);
        //         curSum -= nums[start++];
        //     }
        // }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int s = 11;
		System.out.println(minSubArrayLen(s, arr));
		
	}

}
