package dynamicprogramming;

public class LongestRepeatingSubSequence {

	public int getLongestLength(char[] str) {
		int n = str.length;
		int[][] T = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				
				if(i != j && str[i-1] == str[j-1])
					T[i][j] = 1 + T[i-1][j-1];
				else
					T[i][j] = Integer.max(T[i][j-1], T[i-1][j]);
			}
		}
		return T[n][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
