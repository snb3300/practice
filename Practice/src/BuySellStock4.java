
public class BuySellStock4 {

	public static int maxProfit(int k, int[] prices) {
		int[][] T = new int[k+1][prices.length];
		for(int i = 1; i <= k; i++) {
			for(int j = 1; j < prices.length; j++) {
				int maxTillDay = 0;
				for(int m = 0; m < j; m++) {
					maxTillDay = Integer.max(T[i-1][m] + prices[j] - prices[m], maxTillDay);
				}
				T[i][j] = Integer.max(T[i][j-1], maxTillDay);
			}
		}
		return (prices.length > 1) ? T[k][prices.length-1] : 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,5,7,1,4,3,1,3};
		int k = 3;
		System.out.println(maxProfit(k, prices));
	}

}
