package arrays;

public class LongestSubArray {

	static int maxLength(int[] a, int k) {
		if (a.length == 0)
			return 0;
		
		int maxLen = 0;
		int i = 0;
		int j = 1;
		int curLen = 1;
		int curSum = a[i];
		while(j < a.length) {
			if ((curSum + a[j]) <= k) {
				curLen += 1;
				curSum += a[j++];
			} else {
				curSum -= a[i++];
				curLen = j - i;
			}
			maxLen = Integer.max(maxLen, curLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		int[] a1 = {3,1,2,1};
		int[] a2 = {74,659,931,273,545,879,924,710,441,166,493,43,988,504,328,730,841,613,304,170,710,158,561,934,100,279,817,336,98,827,513,268,811,634,980,150,580,822,968,673,394,337,486,746,229,92,195,358,2,154,709,945,669,491,125,197,531,904,723,667,550};
		System.out.println(maxLength(a, 3));
		System.out.println(maxLength(a1, 4));
		System.out.println(maxLength(a2, 22337));
	}

}
