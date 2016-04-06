package DynamicProgramming;

public class RodCutting {

	public static int getMaxPrice(int[] price, int N) {
		int[][] T = new int[price.length][N+1];
		
		for(int i = 0; i<price.length; i++) {
			int val = i+1;
			for(int j = 0; j <= N; j++) {
				if(j == 0) {
					T[i][j] = 0;
					continue;
				}
				if(i == 0)
					T[i][j] = j * price[i];
				else if(val > j)
					T[i][j] = T[i-1][j];
				else
					T[i][j] = Integer.max(T[i-1][j], price[i] + T[i][j-val]);
			}
		}
		return T[price.length-1][N];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {1,5,8,9,10,17,17,20};
//		int[] price = {2,5,7,8};
		int N = 7;
		System.out.println(getMaxPrice(price, N));
	}

}
