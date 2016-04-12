package backtracking;

public class RatMaze {

	public int[][] sol;
	public int N;
	
	public RatMaze(int n) {
		N = n;
		sol = new int[N][N];
	}
	
	public void printSolution() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private boolean isSafe(int[][] maze, int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}
	
	public void solveMaze(int[][] maze) {
		if(solveMazeUtil(maze, 0, 0))
			printSolution();
		else
			System.out.println("No solution to maze");
	}
	
	public boolean solveMazeUtil(int[][] maze, int x, int y) {
		if(x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if(solveMazeUtil(maze, x + 1, y))
				return true;
			
			if(solveMazeUtil(maze, x, y + 1))
				return true;
			
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 1, 0},
	            {1, 0, 1, 1}
	        };
		RatMaze rm = new RatMaze(maze.length);
		rm.solveMaze(maze);
	}

}
