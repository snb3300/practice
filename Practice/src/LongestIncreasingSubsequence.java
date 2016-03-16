import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int getLengthOfLongestIncreasingSubsequence(int[] a) {
		int maxLen = 1;
		int []subSequenceLen = new int[a.length];
		
		for (int i = 0; i < a.length - 1; i++) {
			int previousMax = a[i];
			Arrays.fill(subSequenceLen, 1);
			for (int j = i+1; j < a.length; j++) {
				if ((a[j] > a[i]) && (a[j] > previousMax)) {
					subSequenceLen[j] = subSequenceLen[j-1] + 1;
					previousMax = a[j];
				} else
					subSequenceLen[j] = subSequenceLen[j-1];
				maxLen = Integer.max(maxLen, subSequenceLen[j]);
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int[] a = {-1,4,-2,4,3,2,5,1,8};
		System.out.println(getLengthOfLongestIncreasingSubsequence(a));
	}

}
