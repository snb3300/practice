
public class KnapsackProblem {

	public static int getMaxValue(int[] wt, int[] v, int W) {
		int len = wt.length;
		int[][] K = new int[len+1][W+1];
		
		for(int i = 0; i <= len; i++) {
			for(int w = 0; w <= W; w++) {
				if(w == 0 || i == 0)
					K[i][w] = 0;
				else if(w < wt[i-1])
					K[i][w] = K[i-1][w];
				else {
					K[i][w] = Integer.max(v[i-1] + K[i-1][w - wt[i-1]], K[i-1][w]);
				}
			}
		}
		return K[len][W];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    System.out.println(getMaxValue(wt, val, W));
	}

}
