package dynamicprogramming;

public class EditDistance {
	
	public static int getMin3(int a, int b, int c) {
		return Integer.min(a, Integer.min(b, c));
	}
	public static int getEditDistance(char[] s1, char[] s2) {
		int [][]editDistance = new int[s1.length + 1][s2.length + 1];
		
		for(int i = 0; i<= s1.length; i++) {
			for(int j = 0; j <= s2.length; j++) {
				if(i == 0)
					editDistance[i][j] = j;
				else if(j == 0)
					editDistance[i][j] = i;
				else {
					if(s1[i-1] == s2[j-1])
						editDistance[i][j] = editDistance[i-1][j-1];
					else
						editDistance[i][j] = 1 + getMin3(editDistance[i-1][j],
								editDistance[i][j-1], editDistance[i-1][j-1]);
				}
			}
		}
		return editDistance[s1.length][s2.length];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s1 = "sunday".toCharArray();
		char[] s2 = "saturday".toCharArray();
		System.out.println(getEditDistance(s1, s2));
	}

}
