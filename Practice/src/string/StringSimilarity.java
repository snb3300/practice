package string;

public class StringSimilarity {

	public static int getSimilarity(char[] s) {
		int k = 1;
		int n = s.length;
		int[] a = new int[n];
		int i, j;
		int res = n;
		while (k < n) {
			j = k;
			i = 0;
			while(j < n && s[i] == s[j]) {
				i += 1;
				j += 1;
			}
			res += j - k;
			k += 1;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getSimilarity("a".toCharArray()));
	}

}
