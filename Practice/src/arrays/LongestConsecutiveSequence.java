package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
        int longest = 1;
        Set<Integer> sequence = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++)
        	sequence.add(nums[i]);
        
        for(int i = 0; i < nums.length; i++) {
        	if(!sequence.contains(nums[i] - 1)) {
        		int j = nums[i];
        		while(sequence.contains(j)) {
        			j += 1;
        		}
        		longest = Integer.max(longest, j - nums[i]);
        	}
        }
        
        return longest;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] arr = {1, 9, 3, 10, 4, 20, 2};
		System.out.println(lcs.longestConsecutive(arr));
	}

}
