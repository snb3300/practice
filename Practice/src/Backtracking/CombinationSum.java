package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void combinationSum(int[] candidates, int target, int startIndex,
			List<Integer> curr, List<List<Integer>> result) {
		if(target == 0) {
			List<Integer> tmp = new ArrayList<>(curr);
			result.add(tmp);
			return;
		}
		
		for(int i = startIndex; i < candidates.length; i++) {
			if(target < candidates[i])
				return;
			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1)
        	return null;
        
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, curr, result);
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {3,6,2,7};
		int target = 7;
		
		List<List<Integer>> result = combinationSum(candidates, target);
		for(List<Integer> a : result) {
			System.out.println(a);
		}
	}

}
