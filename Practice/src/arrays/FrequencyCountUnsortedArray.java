package arrays;

/**
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be absent from the array. 
 * Count frequency of all elements that are present and print the missing elements.
 * 
 * Input: arr[] = {2, 3, 3, 2, 5}
 * Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1
 * @author sbhalekar
 *
 */

public class FrequencyCountUnsortedArray {

	public static void method1(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] <= 0) {
				i += 1;
			} else {
				int index = arr[i] - 1;
				if(arr[index] <= 0) {
					arr[index] -= 1;
					arr[i++] = 0;
				}
				else {
					arr[i] = arr[index];
					arr[index] = -1;
				}
			}
		}
	}
	
	public static void method2(int[] arr) {
		int n = arr.length;
		
		for(int i = 0; i < n; i++)
			arr[i] -= 1;
		
		for(int i = 0; i < n; i++) {
			arr[arr[i] %n] += n;
		}
		for(int i = 0; i < n; i++)
			arr[i] /= n;
	}
	
	public static void print(int[] arr) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,3,2,5};
		method2(arr);
		print(arr);
	}

}
