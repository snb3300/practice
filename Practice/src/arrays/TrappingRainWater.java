package arrays;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar
 * is 1, compute how much water it is able to trap after raining.
 * 
 * Examples:
 * 
 * Input: arr[]   = {2, 0, 2}
 * Output: 2
 * | |
 * |_|
 * We can trap 2 units of water in the middle gap.
 * 
 * Input: arr[]   = {3, 0, 0, 2, 0, 4}
 * Output: 10
 * Structure is like below
 *      |
 * |    |
 * |  | |
 * |__|_|
 * We can trap "3*2 units" of water between 3 an 2,
 * "1 unit" on top of bar 2 and "3 units" between 2 and 4.
 * 
 * @author sbhalekar
 *
 */
public class TrappingRainWater {
	
	public static int findWater(int[] arr) {
		int water = 0;
		
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			left[i] = Integer.max(left[i-1], arr[i]);
		}
		
		right[arr.length - 1] = arr[arr.length - 1];
		for(int i = arr.length - 2; i>= 0; i--) {
			right[i] = Integer.max(right[i+1], arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			water += Integer.min(left[i], right[i]) - arr[i];
		}
		return water;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2, 0, 2};
		int[] arr2 = {3, 0, 0, 2, 0, 4};
		int[] arr3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println(findWater(arr1));
		System.out.println(findWater(arr2));
		System.out.println(findWater(arr3));
	}

}
