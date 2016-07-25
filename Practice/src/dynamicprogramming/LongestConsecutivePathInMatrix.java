package dynamicprogramming;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a-character-matrix/
 * @author sbhalekar
 *
 */
public class LongestConsecutivePathInMatrix {

	public static int[] x = {0,1,1,-1,1,0,-1,-1};
	public static int[] y = {1,0,1,1,-1,-1,0,-1};
	
	public static boolean isValid(int i, int j, int R, int C) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}
	
	public static boolean isAdjacent(char curr, char prev) {
		return (curr - prev) == 1;
	}
	
	public static int getLongestPath(char[][] mat, int[][] T, int i, int j, char prev) {
		if(!isValid(i, j, mat.length, mat[0].length) || !isAdjacent(mat[i][j], prev))
			return 0;
		
		if(T[i][j] != -1)
			return T[i][j];
		
		int res = 0;
		
		for(int k = 0; k < 8; k++) {
			res = Integer.max(res, 1 + getLongestPath(mat, T, i+x[k], j+y[k], mat[i][j]));
		}
		return T[i][j] = res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat = { {'a', 'c', 'd'},
                {'h', 'b', 'e'},
                {'i', 'g', 'f'}};
		
		int[][] T = new int[mat.length][mat[0].length];
		for(int i = 0; i < mat.length; i++)
			Arrays.fill(T[i], -1);
		
		int ans = 0;
		int si = 1;
		int sj = 2;
		for(int i = 0; i < 8; i++) {
			ans = Integer.max(ans, 1 + getLongestPath(mat, T, si + x[i], sj + y[i], 'e'));
		}
		System.out.println(ans);

	}

}
