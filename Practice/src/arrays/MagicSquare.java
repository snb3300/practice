package arrays;

import java.util.Scanner;

public class MagicSquare {
	public static int getMinCost(int[][] mat) {
        int sum = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
        }
        return Math.abs(sum - 45);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int[][] mat = new int[3][3];
        for(int i=0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                mat[i][j] = in.nextInt();
        }
        in.close();
        System.out.println(getMinCost(mat));
    }
}
