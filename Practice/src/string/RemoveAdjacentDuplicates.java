package string;

import java.util.ArrayList;
import java.util.List;

public class RemoveAdjacentDuplicates {
	
	public static List<Character> removeUtil(List<Character> buff, char last) {
		if(buff.size() <= 1) {
			return buff;
		}
		
		if(buff.get(0) == buff.get(1)) {
			last = buff.get(0);
			while((buff.get(1) & buff.get(0)) == buff.get(0)) {
				buff.remove(0);
			}
			return removeUtil(buff, last);
		}
		
		List<Character> rem_str = removeUtil(buff.subList(1, buff.size()), last);
		
		if(rem_str.get(0) == buff.get(0)) {
			last = buff.get(0);
			return rem_str.subList(1, rem_str.size());
		}
		
		if(rem_str.isEmpty() && last == buff.get(0)) {
			return rem_str;
		}
		
		rem_str.add(0, buff.get(0));
		return rem_str;
	}
	
	public static String remove(String input) {
		StringBuffer buff = new StringBuffer();
		int i = 1;
		buff.append(input.charAt(0));
		while(i < input.length()) {
			char current = buff.charAt(buff.length() - 1);
			
			if(input.charAt(i) == current && (i == input.length() - 1 || input.charAt(i + 1) != current)) {
				buff.deleteCharAt(buff.length() - 1);
			} else if (input.charAt(i) != current) {
				buff.append(input.charAt(i));
			}
			i++;
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(remove("azxxxza"));
		String s = "cazxxxza";
		List<Character> buff = new ArrayList<>();
		
		for(char c : s.toCharArray()) {
			buff.add(c);
		}
		System.out.println(removeUtil(buff, '\0'));
	}

}
