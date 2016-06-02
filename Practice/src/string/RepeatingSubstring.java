package string;

public class RepeatingSubstring {

	public static boolean isRepeat(String str) {
		int[] lps = new int[str.length()];
		int n = str.length();
		PatternSearch.computeLPS(str.toCharArray(), lps);
		PatternSearch.printLPS(lps);
		return (n % (n - lps[n - 1]) == 0) ? true : false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRepeat("abcabcabc"));
	}

}
