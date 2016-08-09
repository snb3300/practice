package dynamicprogramming;

public class UniquePathWithObstacles {

	public static int uniquePaths(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] T = new int[m][n];
		
		if(obstacleGrid[0][0] == 0)
			T[0][0] = 1;
		
		for(int i = 1; i < n ; i++) {
			if(obstacleGrid[0][i-1] == 1)
				obstacleGrid[0][i] = 1;
			if(obstacleGrid[0][i] == 0)
				T[0][i] = 1;
		}
		
		for(int i = 1; i < m ; i++) {
			if(obstacleGrid[i-1][0] == 1)
				obstacleGrid[i][0] = 1;
			if(obstacleGrid[i][0] == 0)
				T[i][0] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 0)
					T[i][j] = T[i][j-1] + T[i-1][j];
			}
		}
		return T[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m1 = {{0,1,0},{0,1,0},{0,0,0}};
		int[][] m2 = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(uniquePaths(m1));
		System.out.println(uniquePaths(m2));
	}

}
