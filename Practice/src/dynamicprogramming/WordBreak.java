package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, Set<String> wordDict) {
		int size = s.length();
		if(size > 0) {
			boolean[] T = new boolean[size+1];
			Arrays.fill(T, false);
			for(int i = 1; i <= size; i++) {
				if(!T[i] && wordDict.contains(s.substring(0, i)))
					T[i] = true;
				
				if(T[i]) {
					if(i == size)
						return true;
					
					for(int j = i+1; j <= size; j++) {
						if(!T[j] && wordDict.contains(s.substring(i, j)))
							T[j] = true;
							
						if(j == size && T[j])
							return true;
					}
				}
				
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordSet = new HashSet<String>();
		wordSet.add("mobile");
		wordSet.add("samsung");
		wordSet.add("sam");
		wordSet.add("sung");
		wordSet.add("man");
		wordSet.add("mango");
		wordSet.add("icecream");
		wordSet.add("and");
		wordSet.add("go");
		wordSet.add("i");
		wordSet.add("like");
		wordSet.add("ice");
		wordSet.add("cream");
		
		System.out.println(wordBreak("ilikesamsung", wordSet));
		System.out.println(wordBreak("samsungandmangok", wordSet));
	}

}
