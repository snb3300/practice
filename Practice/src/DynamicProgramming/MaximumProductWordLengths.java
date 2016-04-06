package DynamicProgramming;

public class MaximumProductWordLengths {

	public static int wordToInteger(String word) {
		int wordInt = 0;
		for(int i = 0; i < word.length(); i++) {
			wordInt |= (1 << (word.charAt(i) - 'a'));
		}
		return wordInt; 
	}
	
	public static int getMaximumProduct(String[] words) {
		int maxLength = 0;
		int[] wordInts = new int[words.length];
		for(int i = 0; i < words.length; i++)
			wordInts[i] = wordToInteger(words[i]);
		
		for(int i = 0; i < words.length - 1; i++) {
			for(int j = i+1; j < words.length; j++) {
				int lenProduct = words[i].length() * words[j].length();
				if(((wordInts[i] & wordInts[j]) == 0) && (maxLength < lenProduct))
					maxLength = lenProduct;
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(getMaximumProduct(words));
	}

}
