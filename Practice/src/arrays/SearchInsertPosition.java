package arrays;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
        if(nums.length > 0) {
            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;
            while(low < high) {
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] >= target) {
                    high = ((mid-1) < 0) ? 0 : mid - 1;
                } else {
                    low = mid + 1;
                }
                mid = (low + high) / 2;
            }
            if(nums[mid] < target)
                return mid+1;
            else
                return mid;
        } else {
            return 0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		int target = 0;
		try {
			
		} catch (java.lang.NullPointerException e) {
			// TODO: handle exception
		}
		System.out.println(searchInsert(nums, target));
	}

}
