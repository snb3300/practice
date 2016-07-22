package arrays;


/**
 * Given a matrix of characters and a pattern, find the orientation of pattern
 * in the matrix. In other words, find if pattern appears in matrix in horizontal
 * or vertical direction. Achieve this in minimum time possible.
 * 
 * mat[N][N] = { {'a', 'b', 'c', 'd', 'e'},
              {'f', 'g', 'h', 'i', 'j'},
              {'k', 'l', 'm', 'n', 'o'},
              {'p', 'q', 'r', 's', 't'},
              {'u', 'v', 'w', 'x', 'y'}};
 * pattern = "pqrs";
 * Output: Horizontal
 * 
 * @author sbhalekar
 *
 */
public class PatternOrientationInMatrix {

	public static int[] computeLPS(char[] pattern) {
		int[] lps = new int[pattern.length];
		int len = 0;
		lps[0] = 0;
		
		for(int i = 1; i < pattern.length; ) {
			if(pattern[i] == pattern[len]) {
				len += 1;
				lps[i] = len;
			} else {
				if(len > 0) {
					len = lps[len - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}
		return lps;
	}
	
	
	public static boolean KMPSearch(char[] pattern, char[] input, int[] lps) {
		int i = 0;
		int j = 0;
		
		while(i < input.length) {
			if(pattern[j] == input[i]) {
				i += 1;
				j += 1;
			}
			
			if(j == pattern.length)
				return true;
			if(j < pattern.length && pattern[j] != input[i]) {
				if(j > 0)
					j = lps[j - 1];
				else
					i += 1;
			}
		}
		
		return false;
	}
	
	public static String getPatternOrientation(char[][] mat, char[] pattern) {
		
		int[] lps = computeLPS(pattern);
		
		for(int i = 0; i < mat.length; i++) {
			if(KMPSearch(pattern, mat[i], lps)) {
				return "Horizontal";
			}
			
			char[] col = new char[mat.length];
			for(int j = 0; j < mat.length; j++) {
				col[j] = mat[j][i];
			}
			
			if(KMPSearch(pattern, col, lps)) {
				return "Vertical";
			}
		}
		return "NOT FOUND";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] mat = {
		        {'a', 'b', 'c', 'd', 'e'},
		        {'f', 'g', 'h', 'i', 'j'},
		        {'k', 'l', 'm', 'n', 'o'},
		        {'p', 'q', 'r', 's', 't'},
		        {'u', 'v', 'w', 'x', 'y'}
		 
		    };
		String pattern = "pqrs";
		System.out.println(getPatternOrientation(mat, pattern.toCharArray()));
	}

}
