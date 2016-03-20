import java.util.Arrays;

public class CoinChange {
	
	public static int getMinimumCoinChange(int coins[], int N) {
		int[] T = new int[N+1];
		Arrays.fill(T, Integer.MAX_VALUE - 1);
		T[0] = 0;
		
		for(int j = 0; j < coins.length; j++) {
			for(int i = 1; i <= N; i++) {
				if (coins[j] <= i) {
					T[i] = Integer.min(T[i], 1 + T[i - coins[j]]);
				}
			}
		}
		return T[N];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 11;
		int[] S = {1,2,5};
		System.out.println(getMinimumCoinChange(S, N));
	}

}
