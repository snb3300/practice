package arrays;

public class SearchSortedArray {

	public static int findPivot(int[] arr, int low, int high) {
		if(high < low)
			return -1;
		if(high == low)
			return low;
		
		int mid = (high + low) / 2;
		if(mid < high && arr[mid] > arr[mid+1])
			return mid;
		if(mid > low && arr[mid] < arr[mid - 1])
			return mid - 1;
		if(arr[low] < arr[mid])
			return findPivot(arr, mid+1, high);
		return findPivot(arr, low, mid-1);
	}
	
	public static int binarySearch(int[] arr, int low, int high, int key) {
		
		if(high < low)
			return -1;
		int mid = (low + high) / 2;
		if(arr[mid] == key)
			return mid;
		if(key < arr[mid])
			return binarySearch(arr, low, mid-1, key);
		return binarySearch(arr, mid+1, high, key);
	}
	
	public static int pivotedBinarySearch(int[] arr, int key) {
		int pivot = findPivot(arr, 0, arr.length - 1);
		
		System.out.println(pivot);
		
		if(pivot == -1)
			return binarySearch(arr, 0, arr.length - 1, key);
		
		
		if(arr[pivot] == key)
			return pivot;
		if(arr[0] > key)
			return binarySearch(arr, pivot + 1, arr.length - 1, key);
		return binarySearch(arr, 0, pivot - 1, key);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,7,8,9,10,1,2,3};
		System.out.println(pivotedBinarySearch(arr, 8));
		
		int[] arr1 = {1,2,3};
		System.out.println(findPivot(arr1, 0, arr1.length - 1));
	}

}
