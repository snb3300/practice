package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class CombinationSum2 {

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
			combinationSum(candidates, target - candidates[i], i + 1, curr, result);
			curr.remove(curr.size() - 1);
		}
	}
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1)
        	return null;
        
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        
        combinationSum(candidates, target, 0, curr, result);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
        result.clear();
        result.addAll(set);
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = combinationSum2(candidates, target);
		for(List<Integer> a : result) {
			System.out.println(a);
		}
	}

}
