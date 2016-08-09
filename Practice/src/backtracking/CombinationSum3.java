package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CombinationSum3 {

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
	
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	int[] candidates = {1,2,3,4,5,6,7,8,9};
    	
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1)
        	return null;
        
        List<Integer> curr = new ArrayList<>();
        
        combinationSum(candidates, n, 0, curr, result);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
        result.clear();
        for(List<Integer> x : set) {
        	if(x.size() == k)
        		result.add(x);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] candidates = {10,1,2,7,6,1,5};
//		int target = 8;
//		List<List<Integer>> result = combinationSum3(3, 9);
//		for(List<Integer> a : result) {
//			System.out.println(a);
//		}
		
		Set<Integer> set = new TreeSet<>();
		int[] arr = {3,5,2,7,4,1};
		for(int x : arr) {
			set.add(x);
		}
		Object[] a = set.toArray();
		if(a.length % 2 == 1)
			System.out.println(a[a.length / 2]);
		else {
			int mid1 = a.length / 2;
			int mid2 = mid1 - 1;
			System.out.println(((int)a[mid1] + (int)a[mid2]) / 2);
		}
		System.out.println(set);
	}

}
