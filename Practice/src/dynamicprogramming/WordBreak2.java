package dynamicprogramming;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	
	
	// Incomplete solution
	
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> broken = new ArrayList<>();
        boolean break1 = false;
        int m = 0;
        for(int i = 0; i <= s.length(); i++) {
        	StringBuffer buffer = new StringBuffer();
        	if(wordDict.contains(s.substring(0, i))) {
        		buffer.append(s.substring(0, i));
        		break1 = true;
        	}
        	
        	if(break1) {
        		m = i;
        		if(i == s.length()) {
        			broken.add(buffer.toString());
        			break;
        		}
        		
        		for(int j = i+1; j <= s.length(); j++) {
        			boolean break2 = false;
        			String intermediate = s.substring(m, j);
        			if(!break2 && wordDict.contains(intermediate)) {
        				buffer.append(" ");
        				buffer.append(s.substring(m, j));
        				break2 = true;
        				m = j;
        			}
        			
        			if(j == (s.length()) && break2) {
        				broken.add(buffer.toString());
        			} else {
        				break2 = false;
        			}
        		}
        		break1 = false;
        	}
        }
        return broken;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "catsanddogs";
		String s = "aaaaaaa";
		
		Set<String> words = new HashSet<String>();
		words.add("cat");
		words.add("cats");
		words.add("and");
		words.add("sand");
		words.add("dog");
		words.add("aaaa");
		words.add("aaa");
		System.out.println(wordBreak(s, words));
		
		
		
		StringBuffer buff = new StringBuffer();
		buff.append(0);
		buff.deleteCharAt(buff.length() - 1);
	}

}
