package string;

public class PatternSearch {

	public static void computeLPS(char[] pattern, int[] lps) {
		int len = 0;
		lps[0] = 0;
		
		for(int i = 1; i < pattern.length;) {
			if(pattern[i] == pattern[len]) {
				len += 1;
				lps[i] = len;
				i += 1;
			} else {
				if(len > 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
	
	public static void KMPSearch(char[] pattern, char[] text) {
		int[] lps = new int[pattern.length];
		int i = 0, j = 0;
		computeLPS(pattern, lps);
		printLPS(lps);
		
		while(i < text.length) {
			if(pattern[j] == text[i]) {
				i += 1;
				j += 1;
			}
			
			if(j == pattern.length) {
				System.out.println("Pattern found at index : " + (i - j));
				j = lps[j - 1];
			} else if (i < text.length && pattern[j] != text[i]) {
				if(j > 0) {
					j = lps[j - 1];
				} else {
					i += 1;
				}
			}
		}
	}
	
	public static void printLPS(int[] lps) {
		System.out.print("LPS :");
		for(int i = 0; i < lps.length; i++) {
			System.out.print(" " + lps[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern1 = "ABABCABAB";
		String text1 = "ABABDABACDABABCABAB";
		
		String pattern2 = "ABCABY";
		String text2 = "ABXABCABYABCABCABY";
		
		String pattern3 = "Geeks";
		String text3 = "GeeksGeeks";
		
		String pattern4 = "ababc";
		String text4 = "abadbababcab";
		
		KMPSearch(pattern4.toCharArray(), text4.toCharArray());
	}

}
