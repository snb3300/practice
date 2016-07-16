package string;

public class TransformString {

	private static final int MAX_CHARS = 256;
	
	
	public static int transformDistance(String s1, String s2) {
		int dist = 0;
		int i, j;
		int[] charCount = new int[MAX_CHARS];
		
		if(s1.length() != s2.length())
			return -1;
		
		for(i = 0; i < s1.length(); i++) {
			charCount[s1.charAt(i)] += 1;
		}
		
		for(i = 0; i < s2.length(); i++) {
			charCount[s1.charAt(i)] -= 1;
		}
		
		for(i = 0; i < s1.length(); i++) {
			if(charCount[s1.charAt(i)] != 0)
				return -1;
		}
		
		i = s1.length() - 1;
		j = s2.length() - 1;
		
		while(i >= 0) {
			while( i >= 0 && s1.charAt(i) != s2.charAt(j)) {
				i -= 1;
				dist += 1;
			}
			if(i >= 0) {
				i -= 1;
				j -= 1;
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(transformDistance("EACBD", "EABCD"));
	}

}
