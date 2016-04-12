package backtracking;

public class WordSearch {
	
	public static boolean isSafe(char[][] board, boolean[][] visited, int x, int y) {
		int N = board.length;
		int M = board[0].length;
		
		return (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]);
	}
	
	public static boolean existsUtil(char[][] board, boolean[][] visited, String word, int wordIndex, int x, int y) {
		if(isSafe(board, visited, x, y)) {
			if(wordIndex < word.length() && board[x][y] == word.charAt(wordIndex)) {
				visited[x][y] = true;
				if(wordIndex == word.length() - 1)
					return true;
				boolean ret = existsUtil(board, visited, word, wordIndex + 1, x + 1, y) ||
						existsUtil(board, visited, word, wordIndex + 1, x - 1, y) ||
						existsUtil(board, visited, word, wordIndex + 1, x, y + 1) ||
						existsUtil(board, visited, word, wordIndex + 1, x, y - 1);
				if(!ret)
					visited[x][y] = false;
				return ret;
			}	
		}
		return false;
	}
	
	
	public static boolean exists(char[][] board, String word) {
		int row = board.length;
		if(row > 0) {
			int col = board[0].length;
			int startX = -1;
			int startY = -1;
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(word.charAt(0) == board[i][j]) {
						startX = i;
						startY = j;
						if(existsUtil(board, new boolean[row][col], word, 0, startX, startY))
							return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		System.out.println(exists(board, "SEE"));
	}

}
