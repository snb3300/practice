package arrays;

/**
 * Given a matrix of size M x N, there are large number of queries to find submatrix sums. 
 * Inputs to queries are left top and right bottom indexes of submatrix whose sum is to find out.
 * How to preprocess the matrix so that submatrix sum queries can be performed in O(1) time.
 * 
 * Input: mat[M][N] = {{1, 2, 3, 4, 6},
                    {5, 3, 8, 1, 2},
                    {4, 6, 7, 5, 5},
                    {2, 4, 8, 9, 4} };
 * Query1: tli = 0, tlj = 0, rbi = 1, rbj = 1
 * Query2: tli = 2, tlj = 2, rbi = 3, rbj = 4
 * Query3: tli = 1, tlj = 2, rbi = 3, rbj = 3;

 * Output:
 * Query1: 11  // Sum between (0, 0) and (1, 1)
 * Query2: 38  // Sum between (2, 2) and (3, 4)
 * Query3: 38  // Sum between (1, 2) and (3, 3)
 * 
 * @author sbhalekar
 *
 */
public class SubmatrixSumQueries {

	public static int getSum(int[][] mat, int tli, int tlj, int rbi, int rbj) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] T = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i == 0 && j == 0) {
					T[i][j] = mat[i][j];
					continue;
				}
				if(i == 0 && j != 0)
					T[i][j] = T[i][j-1] + mat[i][j];
				else if(i != 0 && j == 0)
					T[i][j] = T[i-1][j] + mat[i][j];
				else {
					T[i][j] = T[i-1][j] + T[i][j-1] + mat[i][j] - T[i-1][j-1];
				}
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		return T[rbi][rbj] - T[tli-1][rbj] - T[rbi][tli-1] + T[tli-1][tlj-1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4} };
		System.out.println(getSum(mat, 2, 2, 3, 4));
	}

}
