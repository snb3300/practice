package dynamicprogramming;

public class LongestPallindromeSubstring {

	public static String getLPS(String str) {
		int maxLength = 1;
		int n = str.length();
		boolean[][] T = new boolean[n][n];
		int startIndex = 0;
		char[] string = str.toCharArray();
		for(int i = 0; i < n; i++) {
			T[i][i] = true;
		}
		
		for(int i = 0; i < n-1; i++) {
			if(string[i] == string[i+1]) {
				T[i][i+1] = true;
				startIndex = i;
				maxLength = 2;
			}
		}
		
		for(int k = 3; k <= n; k++) {
			for(int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				
				if(string[i] == string[j] && T[i+1][j-1]) {
					T[i][j] = true;
					if(k > maxLength) {
						maxLength = k;
						startIndex = i;
					}
				}	
			}
		}
		return str.substring(startIndex, startIndex+maxLength);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLPS("forgeeksskeegfor"));
		System.out.println(getLPS("abaccad"));
		System.out.println(getLPS("abcd"));
		System.out.println(getLPS("abbd"));
		System.out.println(getLPS("aaaa"));
	}

}
