package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndGene {
	
	public static Map<Character, Integer> count = new HashMap<Character, Integer>();
	
	public static void updateMap(char c, int factor) {
		int x = count.get(c);
    	count.put(c, x + factor);
	}
	
	public static int getMinSubStringLength(int a, String s) {
        int result = 0;
        count.put('A', 0);
        count.put('G', 0);
        count.put('T', 0);
        count.put('C', 0);
        
        for(int i = 0; i < a; i++) {
        	updateMap(s.charAt(i), 1);
        }
        
        if(count.get('A') == a / 4 && count.get('G') == a / 4 &&
        		count.get('C') == a / 4 && count.get('T') == a / 4) {
        	return result;
        }
        
        int left = 0;
        int right = 0;
        result = a + 1;
        
        for(;right < a; right++) {
        	char c = s.charAt(right);
        	updateMap(c, -1);
        	while(count.get('A') <= a / 4 && count.get('G') <= a / 4 &&
            		count.get('C') <= a / 4 && count.get('T') <= a / 4) {
        		result = Integer.min(result, right - left + 1);
        		updateMap(s.charAt(left), 1);
        		left += 1;
        	}
        }
        return result;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = new Integer(in.nextLine());
        String b = in.nextLine();
        in.close();
        System.out.println(getMinSubStringLength(a, b));
        
    }
}
