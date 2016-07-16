package string;

import java.util.ArrayList;
import java.util.List;

public class AllPallindromicPartition {

	public static boolean isPallindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while(i <= j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i += 1;
			j -= 1;
		}
		return true;
	}
	
	public static void pallindromicPartitions(String s, List<String> allPartitions, List<String> currentPartitions) {
		if(s.isEmpty()) {
			allPartitions.addAll(currentPartitions);
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			String right = s.substring(i + 1, s.length());
			if(isPallindrome(left)) {
				currentPartitions.add(left);
				pallindromicPartitions(right, allPartitions, currentPartitions);
				if(currentPartitions.size() > 1) {
					currentPartitions.remove(currentPartitions.size() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> all = new ArrayList<>();
		List<String> curr = new ArrayList<>();
		
		String s = "iti";
		
		pallindromicPartitions(s, all, curr);
		System.out.println(all);
		
	}

}
