package DynamicProgramming;

public class LongestCommonSubsequence {

	public static int getLCSLength(char[] s1, char[] s2) {
		int[][] lcsMatrix = new int[s1.length+1][s2.length+1];
		
		for(int i = 0; i <= s1.length; i++) {
			for(int j = 0; j<=s2.length; j++) {
				if(i == 0 || j == 0)
					lcsMatrix[i][j] = 0;
				else if(s1[i-1] == s2[j-1]) {
					lcsMatrix[i][j] = lcsMatrix[i-1][j-1] + 1;
				} else {
					lcsMatrix[i][j] = Integer.max(lcsMatrix[i-1][j], lcsMatrix[i][j-1]);
				}
			}
		}
		return lcsMatrix[s1.length][s2.length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		System.out.println(getLCSLength(s1.toCharArray(), s2.toCharArray()));
	}
}
