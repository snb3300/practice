package arrays;

public class MaximumProductSubarray {

	int getMaximumProductInN(int[] nums) {
		
		int maxProduct = 1;
	    int local_max = 1;
	    int local_min = 1;
	     
	    for(int i = 0; i < nums.length; i++) {
	    	 if(nums[i] > 0) {
	    		 local_max = local_max * nums[i];
	    		 local_min = Integer.min(local_min * nums[i], 1);
	    	 } else if (nums[i] == 0) {
	    		 local_max = 1;
	    		 local_min = 1;
	    	 } else {
	    		 int tmp = local_max;
	    		 local_max = Integer.max(local_min * nums[i], 1);
	    		 local_min = tmp * nums[i];
	    	 }
	    	 maxProduct = Integer.max(maxProduct, local_max);
	     }
	     return maxProduct;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2,-3,-1, -3, -4, 0, -1};
		System.out.println(new MaximumProductSubarray().getMaximumProductInN(input));
	}

}
