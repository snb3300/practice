package string;

import java.util.Scanner;

public class LexicographicallyMinimunString {

	public static String getMin(String s1, String s2) {
		if(s1.isEmpty() && s2.isEmpty())
			return "";
		if(s1.isEmpty() && !s2.isEmpty())
			return s2;
		if(!s1.isEmpty() && s2.isEmpty())
			return s1;
		char c_s1 = s1.charAt(0);
		char c_s2 = s2.charAt(0);
		StringBuffer buff = new StringBuffer();
		if(c_s1 < c_s2) {
			buff.append(c_s1);
			buff.append(getMin(s1.substring(1), s2));
		} else if(c_s1 >= c_s2) {
			buff.append(c_s2);
			buff.append(getMin(s1, s2.substring(1)));
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int b = new Integer(in.nextLine());
        for(int i = 0; i < b; i++) {
        	String A = in.nextLine() + 'z';
        	String B = in.nextLine() + 'z';
        	System.out.println(getMin(A, B));
        }
        in.close();
	}

}
