package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {
	
	private String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private String[] numbers;
    
	private void letterCombinationsUtil(int numbersIndex, StringBuffer curr, List<String> sol) {
		if(numbersIndex >= numbers.length) {
			sol.add(curr.toString());
			return;
		}
		
		String s = numbers[numbersIndex];
		if(s.isEmpty())
			letterCombinationsUtil(numbersIndex + 1, curr, sol);
		
		for(int i = 0; i < s.length(); i++) {
			curr.append(s.substring(i, i+1));
			letterCombinationsUtil(numbersIndex + 1, curr, sol);
			curr.delete(curr.length() - 1, curr.length());
		}
	}
	
	public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        numbers = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
        	int index = Integer.parseInt(digits.substring(i, i+1));
        	numbers[i] = map[index];
        }
        if(digits.length() > 0)
        	letterCombinationsUtil(0, new StringBuffer(), sol);
        return sol;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationPhoneNumber l = new LetterCombinationPhoneNumber();
		System.out.println(l.letterCombinations("013"));
	}

}
