package string;

public class ShortestPallindrome {

	private int computeLPS(char[] s) {
        int[] lps = new int[s.length];
        int i = 1;
        int len = 0;
        while(i < s.length) {
            if(s[i] == s[len]) {
                len += 1;
                lps[i++] = len;
            } else {
                if(len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps[s.length - 1];
    }
    
    
    public String shortestPalindrome(String s) {
        if(s.length() <= 0)
    		return s;
        StringBuilder buff = new StringBuilder(s);
        String rev = buff.reverse().toString();
        buff.delete(0, buff.length());
        buff.append(s);
        buff.append(rev);
        int len = computeLPS(buff.toString().toCharArray());
        
        if(len > s.length())
        	len = len % s.length() + 1;
        
        if(len + 1 == buff.length())
        	return s;
        
        
        buff.delete(buff.length() - len, buff.length());
        String toAppend = buff.substring(s.length());
        buff.delete(0, buff.length());
        buff.append(toAppend);
        buff.append(s);
        return buff.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPallindrome sp = new ShortestPallindrome();
		System.out.println(sp.shortestPalindrome("aabba"));
		System.out.println(sp.shortestPalindrome("aacecaaa"));
		System.out.println(sp.shortestPalindrome("aaaaa"));
		System.out.println(sp.shortestPalindrome(""));
	}

}
