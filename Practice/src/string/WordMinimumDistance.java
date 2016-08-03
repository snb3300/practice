package string;

/**
 * Find minimum distance between two words (order preserved) in a big string. 
 * For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
 * e.g 2. "hello how are hello you" - distance is 1 
 * e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
 * e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 * 
 * @author sbhalekar
 */
public class WordMinimumDistance {

	public static int getMinimumDistance(String[] words, String s1, String s2) {
		int min  = words.length + 1;
		int f1 = -1;
		int f2 = -1;
		
		for(int i = 0; i< words.length; i++) {
			
			if(words[i].compareTo(s1) == 0) {
				f1 = i;
			}else if(words[i].compareTo(s2) == 0)
				f2 = i;
			
			if(f1 != -1 && f2 != -1) {
				if(f2 - f1 > 0)
					min = Integer.min(min, f2 - f1);
				f1 = f2 = -1;
			}
		}
		return min == words.length + 1 ? -1 : min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = "how are you".split(" ");
		System.out.println(getMinimumDistance(words, "hello", "you"));
	}

}
