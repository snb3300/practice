package string;

import java.util.Arrays;

public class IsomaorphicStrings {

	public static final int MAX_CHARS = 256;
	
	public static boolean isIsomorphic(String s1, String s2) {
		
		if(s1.length() != s2.length())
			return false;
		
		int[] cache = new int[MAX_CHARS];
		Arrays.fill(cache, -1);
		
		for(int i = 0; i < s1.length(); i++) {
			if(cache[s1.charAt(i)] == -1 && cache[s2.charAt(i)] == -1) {
				cache[s1.charAt(i)] = s2.charAt(i);
				cache[s2.charAt(i)] = s1.charAt(i);
			} else if (cache[s1.charAt(i)] != s2.charAt(i) && cache[s2.charAt(i)] != s1.charAt(i)) {
				return false;
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("aab", "aab"));
	}

}
