package backtracking;

public class KnightsTour {
	public static final int N = 8;
	public static int[][] sol = new int[N][N];
	public static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
	public static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static boolean isSafe(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}
	
	public static void printSolution() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void init() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				sol[i][j] = -1;
	}
	
	public static void solveKT(int x, int y) {
		init();
		sol[x][y] = 0;
		
		if(!solveKTUtil(1, x, y))
			System.out.println("No Solution exists");
		else
			printSolution();
	}
	
	public static boolean solveKTUtil(int moveIndex, int x, int y) {
		if(moveIndex == N*N)
			return true;
		int next_x, next_y;
		for(int i = 0; i < N; i++) {
			next_x = xMove[i] + x;
			next_y = yMove[i] + y;
			if(isSafe(next_x, next_y)) {
				sol[next_x][next_y] = moveIndex;
				if(solveKTUtil(moveIndex+1, next_x, next_y))
					return true;
				else
					sol[next_x][next_y] = -1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveKT(2,1);
	}

}
