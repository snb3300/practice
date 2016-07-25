package string;

import java.util.Scanner;

public class SherlockValidString {

	public static boolean isValid(String s) {
		int[] freq = new int[26];
		int distinct = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(freq[s.charAt(i) - 'a'] == 0)
				distinct += 1;
			freq[s.charAt(i) - 'a'] += 1;
		}
		
		System.out.println("Length : " + s.length());
		for(char i = 'a'; i <= 'z'; i++) {
			if(freq[i - 'a'] > 0)
				System.out.println(i + " : " + freq[i - 'a']);
		}
		
		if(s.length() % distinct == 0)
			return true;
		
		for(int i = 0; i < s.length(); i++) {
			int cFreq = freq[s.charAt(i) - 'a'];
			if(cFreq > 0) {
				if((s.length() - cFreq) % (distinct - 1) == 0)
					return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        in.close();
        if(isValid(b))
            System.out.println("YES");
        else
            System.out.println("NO");
	}

}
