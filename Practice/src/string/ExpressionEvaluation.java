package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ExpressionEvaluation {

	public static Integer getValue(int o1, int o2, char op) {
		switch(op) {
			case '+': return o1 + o2;
			case '-': return o1 - o2;
			case '*': return o1 * o2;
			case '/': return o1 / o2;
		}
		return null;
	}
	
	public static int evaluate(String expression) {
		int result = 0;
		Map<Character, Integer> preceedence = new HashMap<Character, Integer>();
		Stack<Character> operator = new Stack<>();
		Stack<Integer> operand = new Stack<>();
		Set<Character> validOperators = new HashSet<>();
		validOperators.add('+');
		validOperators.add('-');
		validOperators.add('/');
		validOperators.add('*');
		preceedence.put('(', 0);
		preceedence.put('+', 2);
		preceedence.put('-', 1);
		preceedence.put('*', 4);
		preceedence.put('/', 3);
		
		for(int i = 0; i < expression.length(); i++) {
			
			if(Character.isDigit(expression.charAt(i))) {
				StringBuffer buff = new StringBuffer();
				while(i < expression.length() && Character.isDigit(expression.charAt(i))) {
					buff.append(expression.charAt(i));
					i += 1;
				}
				operand.push(Integer.parseInt(buff.toString()));
			} else if(validOperators.contains(expression.charAt(i))) {
				if(operator.isEmpty() || preceedence.get(expression.charAt(i)) > preceedence.get(operator.peek())) {
					operator.push(expression.charAt(i));
				} else {
					while(!operator.isEmpty() && (preceedence.get(expression.charAt(i)) < preceedence.get(operator.peek()))) {
						int o1 = operand.pop();
						int o2 = operand.pop();
						operand.push(getValue(o1, o2, expression.charAt(i)));
					}
					operator.push(expression.charAt(i));
				}
			} else if (expression.charAt(i) == '(') {
				operator.push('(');
			} else if (expression.charAt(i) == ')') {
				while(operator.peek() != '(') {
					operand.push(getValue(operand.pop(), operand.pop(), operator.pop()));
				}
				operator.pop();
			}
		}
		while(!operator.isEmpty()) {
			int o1 = operand.pop();
			int o2 = operand.pop();
			operand.push(getValue(o1, o2, operator.pop()));
		}
		return operand.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(evaluate("10 + 2 * 6"));
		System.out.println(evaluate("100 * (2 + 12) / 14"));
	}

}
