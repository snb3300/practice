package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
    }
	
	private static void dfs(List<String> result, String s, int left, int right) {
		if(left > right)
			return;
		
		if(left == 0 && right == 0) {
			result.add(s);
			return;
		}
		
		if (left > 0)
			dfs(result, s+"(", left - 1, right);
		
		if (right > 0)
			dfs(result, s+")", left, right - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}

}
