package string;

public class PrintSentences {
	
	public static void print(String[][] wordsList, int curList, int curWord, StringBuffer sentence) {
		if(curList == wordsList.length) {
			System.out.println(sentence);
			return;
		}
		for(int i = curWord; i< wordsList[curList].length; i++) {
			String cur = wordsList[curList][i];
			sentence.append(cur + " ");
			print(wordsList, curList+1, 0, sentence);
			sentence.delete(sentence.length() - cur.length() - 1, sentence.length());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] wordsList = {{"you", "we"},{"have", "are"},{"sleep", "eat", "drink"}};
		print(wordsList, 0, 0, new StringBuffer());
	}

}
