package Arrays;

public class MissingNumber {

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for(int num : nums)
			sum += num;
		return (n*(n+1)) / 2 - sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,3};
		System.out.println(missingNumber(nums));
	}

}
