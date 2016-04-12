package String;

import java.util.Stack;

public class LongestValidParantheses {
	
	public static int longestValidParentheses(String s) {
        int result = 0;
        Stack<int[]> stack = new Stack<int[]>();
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		int[] a = {i, 0}; 
        		stack.push(a);
        	} else {
        		if(stack.empty() || stack.peek()[1] == 1) {
        			int[] a = {i, 1};
        			stack.push(a);
        		} else {
        			stack.pop();
        			int currLen = 0;
        			if(stack.empty())
        				currLen = i + 1;
        			else {
        				currLen = i - stack.peek()[0];
        			}
        			result = Math.max(result, currLen);
        		}
        		
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
