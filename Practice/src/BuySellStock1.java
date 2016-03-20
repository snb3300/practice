
public class BuySellStock1 {

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		if(prices.length > 1) {
            maxProfit = prices[1] - prices[0];
            int minVal = prices[0];
            for(int i = 1; i < prices.length; i++) {
                if((prices[i] - minVal) > maxProfit)
                	maxProfit = prices[i] - minVal;
                if(prices[i] < minVal)
                	minVal = prices[i];
            }
        }
		return (maxProfit >= 0) ? maxProfit : 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {100, 180, 260, 310, 40, 535, 695};
//		int[] prices = {2, 1};
		System.out.println(maxProfit(prices));
	}

}
