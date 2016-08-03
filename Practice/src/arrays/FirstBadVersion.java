package arrays;

import java.math.BigInteger;

public class FirstBadVersion {
	
	private boolean isBadVersion(int n) {
		if(n >= 2) {
			return true;
		}
		return false;
	}
	
    private int firstBadVersionUtil(BigInteger l, BigInteger h) {
        if(l.compareTo(h) >= 0) {
            if(isBadVersion(l.intValue()))
                return l.intValue();
            return 0;
        }
        
        BigInteger mid = l.add(h).divide(new BigInteger("2"));
        if(isBadVersion(mid.intValue())) {
            return firstBadVersionUtil(l, mid);
        } else {
            return firstBadVersionUtil(mid.add(BigInteger.ONE), h);
        }
    }
    
    public int firstBadVersion(int n) {
        return firstBadVersionUtil(BigInteger.ONE, BigInteger.valueOf(n));
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion fbv = new FirstBadVersion();
		System.out.println(fbv.firstBadVersion(3));
	}

}
