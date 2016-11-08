package hackerrank;

public class VMwareChallenge {

	
	static void printDomains(String[] arr) {
		
	}
	
	
	static int maxDifference(int[] a) {
		if(a.length == 0)
			return -1;
		
		int maxDiff = -1;
		int n = a.length;
		int[] lMin = new int[n];
		int[] rMax = new int[n];
		
		lMin[0] = a[0];
		rMax[n-1] = a[n-1];
		
		for(int i = 1; i < n; i++)
			lMin[i] = Integer.min(a[i], lMin[i-1]);
		
		for(int i = n-2; i >= 0; i--)
			rMax[i] = Integer.max(a[i], rMax[i+1]);
		
		for(int i = 0; i < n; i++) {
			int curMax = rMax[i] - lMin[i];
			maxDiff = Integer.max(curMax, maxDiff);
		}
		return maxDiff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,10,2,4,8,1};
		int[] b = {1,2,3};
		System.out.println(maxDifference(b));
	}

}
