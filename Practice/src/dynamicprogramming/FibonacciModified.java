package dynamicprogramming;

import java.math.BigInteger;

public class FibonacciModified {

	public static BigInteger getFib(int A, int B, int n) {
        BigInteger curr = BigInteger.ZERO;
        BigInteger t0 = BigInteger.valueOf(A);
        BigInteger t1 = BigInteger.valueOf(B);
        
        while(n - 2 > 0) {
            curr = t0.add(t1.multiply(t1));
            t0 = t1;
            t1 = curr;
            n -= 1;
        }
        return curr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFib(0, 1, 5));
	}

}
