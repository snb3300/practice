package arrays;

public class DungeonGame {

	public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] h = new int[n][m];
        
        for(int i = 1; i < m; i++) {
            h[0][i] = dungeon[0][i] + h[0][i-1];
        }
        
        for(int i = 1; i < n; i++) {
            h[i][0] = dungeon[i][0] + h[i-1][0];
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(h[i-1][j] < 0 && h[i][j-1] < 0) {
                    h[i][j] = dungeon[i][j] + Integer.max(h[i-1][j], h[i][j-1]);
                } else {
                    h[i][j] = dungeon[i][j] + Integer.min(h[i-1][j], h[i][j-1]);
                }
            }
        }
        if(h[n-1][m-1] < 0)
            return h[n-1][m-1] * -1 + 1;
        return 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] d = {{-200}};
		System.out.println(calculateMinimumHP(d));
	}

}
