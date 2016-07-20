package dynamicprogramming;


/**
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. 
 * We make a few assumptions:
	…..An egg that survives a fall can be used again.
	…..A broken egg must be discarded.
	…..The effect of a fall is the same for all eggs.
	…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
	…..If an egg survives a fall then it would survive a shorter fall.
	…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
	
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way.
 * Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks.
 * In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that
 * is guaranteed to work in all cases?
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total 
 * number of trials are minimized.
 * @author sbhalekar
 *
 */
public class EggDrop {

	public static int getMinimumTrials(int n, int k) {
		int[][] T = new int[k+1][n+1];
		
		for(int i = 0; i <= n; i++) {
			T[1][i] = i;
		}
		
		for(int i = 1; i <= k; i++) {
			T[i][1] = 1;
		}
		
		for(int i = 2; i <= k; i++) {
			for(int j = 2; j <= n; j++) {
				T[i][j] = Integer.MAX_VALUE;
				for(int x = 1; x <= j; x++) {
					int res = 1 + Integer.max(T[i-1][x-1], T[i][j-x]);
					T[i][j] = Integer.min(T[i][j], res);
				}
			}
		}
		return T[k][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinimumTrials(36, 2));
	}

}
