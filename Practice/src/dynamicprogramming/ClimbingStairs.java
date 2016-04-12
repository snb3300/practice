package dynamicprogramming;

public class ClimbingStairs {

	public static int climbStairs(int n) {
		if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else {
        	int[] T = new int[n+1];
    		T[0] = 1;
    		T[1] = 1;
    		for(int i = 2; i <= n; i++) {
    			T[i] = T[i-1] + T[i-2];
    		}
    		return T[n];
        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(6));
	}

}
