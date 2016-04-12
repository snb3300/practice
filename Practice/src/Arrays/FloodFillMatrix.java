package Arrays;

public class FloodFillMatrix {

	public static void floodFillHelper(int[][] screen, int prevC, int newC, int x, int y) {
		int m = screen.length;
		int n = screen[0].length;
		if(x < 0 || x >= m || y < 0 || y >= n)
			return;
		if(screen[x][y] != prevC)
			return;
		
		screen[x][y] = newC;
		floodFillHelper(screen, prevC, newC, x-1, y);
		floodFillHelper(screen, prevC, newC, x, y-1);
		floodFillHelper(screen, prevC, newC, x+1, y);
		floodFillHelper(screen, prevC, newC, x, y+1);
	}
	
	public static void floodFill(int[][] screen, int newC, int x, int y) {
		int prevC = screen[x][y];
		floodFillHelper(screen, prevC, newC, x, y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
               };
		int x = 4, y = 4, newC = 3;
		floodFill(screen, newC, x, y);
		for (int i=0; i<screen.length; i++)
	    {
	        for (int j=0; j<screen[0].length; j++)
	           System.out.print(screen[i][j] + " ");
	        System.out.println();
	    }
	}

}
