package dynamicprogramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	
	
	private static List<String> sentence;
	
	public static void wordBreakUtil(String s, StringBuffer buff, Set<String> wordDict) {
		
		if(s.length() == 0) {
			sentence.add(buff.toString().trim());
		}
		
		for(int i = 1; i <= s.length(); i++) {
			String word = s.substring(0, i);
			if(wordDict.contains(word)) {
				int prevIndex = buff.length();
				buff.append(" " + word);
				wordBreakUtil(s.substring(i), buff, wordDict);
				buff.delete(prevIndex, buff.length());
			}
		}
	}
	
	
	
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        sentence = new ArrayList<>();
        StringBuffer buff = new StringBuffer();
        wordBreakUtil(s, buff, wordDict);
        return sentence;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "catsanddog";
//		String s = "aaaaaaa";
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] dic = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> words = new HashSet<String>(Arrays.asList(dic));
		
		
//		Set<String> words = new HashSet<String>();
//		words.add("cat");
//		words.add("cats");
//		words.add("and");
//		words.add("sand");
//		words.add("dog");
//		words.add("aaaa");
//		words.add("aaa");
		System.out.println(wordBreak(s, words));
		
		
		
//		StringBuffer buff = new StringBuffer();
//		buff.append(0);
//		buff.deleteCharAt(buff.length() - 1);
	}

}
