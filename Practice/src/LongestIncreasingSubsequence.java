import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int getLengthOfLongestIncreasingSubsequence(int[] a) {
		int maxLen = 1;
		int []subSequenceLen = new int[a.length];
		Arrays.fill(subSequenceLen, 1);
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if ((a[j] > a[i])) {
					subSequenceLen[j] = Integer.max(subSequenceLen[j], subSequenceLen[i] + 1);
				}
				maxLen = Integer.max(maxLen, subSequenceLen[j]);
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60 };
//		int[] a = {10,9,2,5,3,4};
//		int[] a = {1,3,6,7,9,4,10,5,6};
		int[] a = {10,22,9,33,21,50,41,60,80};
		System.out.println(getLengthOfLongestIncreasingSubsequence(a));
	}

}
