package arrays;

/**
 * Given an array of positive integers, find maximum possible value K such that 
 * the array has at-least K elements that are greater than or equal to K. 
 * The array is unsorted and may contain duplicate values.
 * 
 * Input: [2, 3, 4, 5, 6, 7]
 * Output: 4
 * Explanation : 4 elements [4, 5, 6, 7]  are greater than equal to 4
 * 
 * Input: [6, 7, 9, 8, 10]
 * Output: 5
 * Explanation : All 5 elements are greater than equal to 5
 * 
 * Expected time complexity : O(n)
 * @author sbhalekar
 *
 */
public class MaximumKInArray {
	
	public static int getMaximumK(int[] input) {
		int[] aux = new int[input.length + 1];
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input.length) {
				aux[input[i]] += 1;
			} else {
				aux[input.length] += 1;
			}
		}
		
		int sum = 0;
		for(int i = input.length; i >= 0; i--) {
			sum += aux[i];
			
			if(sum >= i)
				return i;
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 3, 4, 5, 6, 7};
		System.out.println(getMaximumK(a));
	}

}
