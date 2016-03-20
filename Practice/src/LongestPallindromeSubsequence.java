import java.util.Arrays;

public class LongestPallindromeSubsequence {

	public static int getLength(char[] sequence) {
		int n = sequence.length;
		int[][] T = new int[n][n];
		int i,j;
		
		for(i = 0; i<n; i++)
			Arrays.fill(T[i], 1);
		
		for(int k = 2; k <= n; k++) {
			for(i = 0; i < n-k+1; i++) {
				j = i+k-1;
				if(sequence[i] == sequence[j])
					T[i][j] = T[i+1][j-1] + 2;
				else
					T[i][j] = Integer.max(T[i][j-1], T[i+1][j]);
					
			}
		}
		return T[0][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BBABCBCAB";
		System.out.println(getLength(s.toCharArray()));
	}

}
