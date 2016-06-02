package string;

public class InterleavingString2 {

	public static boolean isInterleave(String s1, String s2, String s3) {
//		int i = 0;
//		int j = 0;
//		int k = 0;
//        while(k < s3.length()) {
//        	if(i < s1.length() && s3.charAt(k) == s1.charAt(i))
//        		i += 1;
//        	else if(j < s2.length() && s3.charAt(k) == s2.charAt(j))
//        		j += 1;
//        	else
//        		return false;
//        	k += 1;
//        }
//        if(i < s1.length() || j < s2.length())
//        	return false;
//        return true;
		
		boolean[][] T = new boolean[s1.length() + 1][s2.length() + 1];
		if(s3.length() != (s1.length() + s2.length()))
			return false;
		
		for(int i = 0; i <= s1.length(); ++i) {
			for(int j = 0; j <= s2.length(); ++j) {
				
				if(i == 0 && j == 0)
					T[i][j] = true;
				
				else if(i == 0 && (s2.charAt(j - 1) == s3.charAt(j - 1)))
					T[i][j] = T[i][j-1];
				
				else if(j == 0 && i > 0 && (s1.charAt(i - 1) == s3.charAt(i - 1)))
					T[i][j] = T[i-1][j];
				
				else if(i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1))
					T[i][j] = T[i-1][j];
				
				else if(i > 0 && s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1))
					T[i][j] = T[i][j-1];
				
				else if(i > 0 && j > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1))
					T[i][j] = T[i-1][j] || T[i][j-1];
			}
		}
		return T[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("aa" ,"bc" ,"abac"));
	}

}
