package string;

import java.math.BigInteger;
import java.util.Scanner;

public class BuildString {
	
	public static int getLargestCommonSubstring(char[] s) {
		int len = 0;
		int i = s.length - 1;
		int j = i - 1;
		int curLen = 0;
		while(j >= 0) {
			if(s[j] == s[i]) {
				i--;
				j--;
				curLen += 1;
			}
			else {
				if(i == s.length - 1)
					j--;
				if(i < s.length - 1) 
					i += 1;
				
				curLen = 0;
			}
			len = Integer.max(len, curLen);
		}
		return len;
	}
	
	public static int getMinCost(String s, int A, int B) {
		int[] T = new int[s.length()];
		
		if(s.length() > 0) {
			T[0] = A;
			for(int i = 1; i < s.length(); i++) {
				int len = getLargestCommonSubstring(s.substring(0, i+1).toCharArray());
				if(len > 0)
					T[i] = Integer.min(T[i -1] + A, T[i - len] + B);
				else
					T[i] = T[i - 1] + A;
			}
		}
		return s.length() > 0 ? T[s.length() - 1] : 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "aabaacaba";
//		String s2 = "bacbacacb";
//		System.out.println(getMinCost(s2, 8, 9));
		Scanner in = new Scanner(System.in);
        int b = new Integer(in.nextLine());
        for(int i = 0; i < b; i++) {
        	String[] arr = in.nextLine().split(" ");
        	String input = in.nextLine();
        	int A = new Integer(arr[1]);
        	int B = new Integer(arr[2]);
        	System.out.println(getMinCost(input, A, B));
        }
        in.close();
	}

}
