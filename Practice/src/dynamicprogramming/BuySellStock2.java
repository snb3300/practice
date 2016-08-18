package dynamicprogramming;

public class BuySellStock2 {
	
	public static int maxProfitUtil(int[] a, int i) {
		if(i >= a.length)
			return 0;
		
		int lmax = 0;
		for(int j = i + 1; j < a.length; j++) {
			lmax = Integer.max(lmax, a[j] - a[i] + maxProfitUtil(a, j + 2));
		}
		return lmax;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {30,30,15,18,20,25,80};
		int[] a = {3,5,8,2,10,14};
		int gMax = 0;
		for (int i = 0; i < a.length; i++) {
			gMax = Integer.max(gMax, maxProfitUtil(a, i));
		}
		System.out.println(gMax);
	}

}
