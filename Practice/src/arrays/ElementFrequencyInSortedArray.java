package arrays;

/**
 * Count the Frequency of each element in sorted array
 * 
 * Method 1 : Traverse the sorted array and keep the count.
 * Method 2 : Use Binary Search  
 * @author sbhalekar
 *
 */
public class ElementFrequencyInSortedArray {

	/**
	 * Traverse the array and maintain element count. If next element is different
	 * then add the count to the output list
	 * 
	 * Time Complexity = O(n)
	 * 
	 * @param input array
	 * @return list
	 */
	public static int[] method1(int[] input) {
		int size = input[input.length - 1] + 1;
		int[] countList = new int[size];
		
		for(int i = 0; i < input.length; i++) {
			countList[input[i]] += 1;
		}
		return countList;
	}
	
	private static void binarySearchUtil(int[] input, int[] countList, int low, int high) {
		if(input[low] == input[high]) {
			countList[input[low]] += high - low + 1;
			return;
		}
		int mid = (low + high) / 2;
		binarySearchUtil(input, countList, low, mid);
		binarySearchUtil(input, countList, mid+1, high);
	}
	
	/**
	 * Use Binary Search and if the first and last element of sub array is same add the count
	 * 
	 * Time Complexity = O(m * log(n)) where m <= M (constant) => O(log(n))
	 * @param input
	 * @return
	 */
	public static int[] method2(int[] input) {
		int size = input[input.length - 1] + 1;
		int[] countList = new int[size];
		binarySearchUtil(input, countList, 0, input.length - 1);
		return  countList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,2,3,3,5,5,8,8,8,9,9, 10};
		int[] o = method2(a);
		for(int x : o) {
			System.out.print(x + " ");
		}
	}

}
