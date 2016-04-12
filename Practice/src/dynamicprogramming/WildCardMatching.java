package dynamicprogramming;

public class WildCardMatching {
	
	public static boolean isMatch(String s, String p) {
		boolean[][] T = new boolean[s.length() + 1][p.length() + 1];
		StringBuffer buffer = new StringBuffer();
		boolean first = true;
		for(int i = 0; i < p.length(); i++) {
			if(first && p.charAt(i) == '*') {
				buffer.append('*');
				first = false;
			} else if(p.charAt(i) != '*') {
				buffer.append(p.charAt(i));
				first = true;
			}
		}
		
		p = buffer.toString();
		for(int i = 1; i <= s.length(); i++) {
			T[i][0] = false;
		}
		
		if(p.length() > 0 && p.charAt(0) == '*')
			T[0][1] = true;

		T[0][0] = true;
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				if((p.charAt(j-1) == s.charAt(i-1)) || (p.charAt(j-1) == '?'))
					T[i][j] = T[i-1][j-1];
				else if(p.charAt(j-1) == '*')
					T[i][j] = T[i-1][j] || T[i][j-1];
				else
					T[i][j] = false;	
			}
		}
		
		return T[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abefcdgiescdfimde";
		String p = "ab*cd?i*de";
		System.out.println(isMatch(s, p));
	}

}
