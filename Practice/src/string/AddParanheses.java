package string;

import java.util.ArrayList;
import java.util.List;

public class AddParanheses {
	
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < input.length(); i++) {
        	char cur = input.charAt(i);
        	
        	if(cur == '+' || cur == '-' || cur == '*') {
        		List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
        		List<Integer> res2 = diffWaysToCompute(input.substring(i+1));
        		
        		for(int n1 : res1) {
        			for(int n2 : res2) {
        				switch(cur) {
        				case '+': res.add(n1 + n2);
        							break;
        				case '-': res.add(n1 - n2);
        							break;
        				case '*': res.add(n1 * n2);
        							break;
        				}
        			}
        		}
        	}
        }
        if(res.isEmpty())
        	res.add(Integer.parseInt(input));
        return res;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddParanheses ap = new AddParanheses();
		
		System.out.println(ap.diffWaysToCompute("2*3-4*5"));
	}

}
