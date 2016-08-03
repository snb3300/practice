package arrays;

public class MaximumProductSubarray {

	int getMaximumProductInN(int[] input) {
	     int[] max = new int[input.length];
	     int[] min = new int[input.length];
	     
	     max[0] = input[0];
	     min[0] = input[0];
	     int maxProduct = input[0];
	     
	     for(int i = 1; i < input.length; i++) {
	     
	         if (input[i] > 0) 
	         {
	             max[i] = Integer.max(input[i], input[i] * max[i - 1]);
	             min[i] = Integer.min(input[i], input[i] * min[i - 1]);         
	         } else {
	             max[i] = Integer.max(input[i], input[i] * min[i - 1]);
	             min[i] = Integer.min(input[i], input[i] * max[i - 1]);         
	         }
	         
	         maxProduct = Integer.max(maxProduct, max[i]);
	     }
	     
	     return maxProduct;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2,-3,-1, -3, -4, 1, -1};
		System.out.println(new MaximumProductSubarray().getMaximumProductInN(input));
	}

}
