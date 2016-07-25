package arrays;

/**
 * Explanation - http://www.geeksforgeeks.org/collect-maximum-coins-before-hitting-a-dead-end/
 * 
 * @author sbhalekar
 *
 */
public class CollectMaxCoins {

	public static boolean isValid(int i, int j, int R, int C) {
		return (i >= 0 && i < R) && (j >= 0 && j < C);
	}
	
	public static int getMaxCoins(char[][] mat, int[][][] T, int i, int j, int dir) {
		if(!isValid(i, j, mat.length, mat[0].length) || mat[i][j] == '#')
				return 0;
		if(T[i][j][dir] != -1)
			return T[i][j][dir];
		
		T[i][j][dir] = mat[i][j] == 'C' ? 1 : 0;
		
		if(dir == 1) {
			T[i][j][dir] += Integer.max(getMaxCoins(mat, T, i+1, j, 0), 
					getMaxCoins(mat, T, i, j+1, 1));
		}
		if(dir == 0) {
			T[i][j][dir] += Integer.max(getMaxCoins(mat, T, i, j-1, 0), 
				getMaxCoins(mat, T, i+1, j, 1));
		}
		return T[i][j][dir];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat = { {'E', 'C', 'C', 'C', 'C'},
                {'C', '#', 'C', '#', 'E'},
                {'#', 'C', 'C', '#', 'C'},
                {'C', 'E', 'E', 'C', 'E'},
                {'C', 'E', '#', 'C', 'E'}
              };
		int n = mat.length;
		int m = mat[0].length;
		int[][][] T = new int[n][m][2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 2; k++) {
					T[i][j][k] = -1;
				}
			}
		}
		System.out.println(getMaxCoins(mat, T, 0, 0, 1));
	}

}
