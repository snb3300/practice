package arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateRPN {
	
	private Set<String> operator = new HashSet<String>();
	
	public int evalRPN(String[] tokens) {
		operator.add("+");
		operator.add("-");
		operator.add("/");
		operator.add("*");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < tokens.length; i++) {
			
			String token = tokens[i];
			if(!operator.contains(token)) {
				stack.push(Integer.valueOf(token));
			} else {
				int x = stack.pop();
				int y = stack.pop();
				
				switch(token) {
					case "+": stack.push(x + y);
								break;
					case "-": stack.push(y - x);
								break;
					case "*": stack.push(x * y);
								break;
					case "/": stack.push(y / x);
								break;
				}
			}
			
		}
		return stack.pop();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens1 = {"2", "1", "+", "3", "*"};
		String[] tokens2 = {"4", "13", "5", "/", "+"};
		System.out.println(new EvaluateRPN().evalRPN(tokens1));
		System.out.println(new EvaluateRPN().evalRPN(tokens2));
	}

}
