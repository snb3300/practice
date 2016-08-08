package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutation {

	private void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
	private void addAsList(int[] arr, List<List<Integer>> res) {
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++)
			l.add(arr[i]);
		res.add(l);
	}
	
	private void permuteUtil(int[] arr, int l, int r, List<List<Integer>> res) {
        if(l == r) {
            addAsList(arr, res);
        }
        for(int i = l; i <= r; i++) {
        	swap(arr, i, l);
        	permuteUtil(arr, l+1, r, res);
        	swap(arr, i, l);
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		List<List<Integer>> res = new ArrayList<>();
		Permutation p = new Permutation();
		p.permuteUtil(arr, 0, arr.length - 1, res);
		System.out.println(res);
	}

}
