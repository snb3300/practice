
public class MaxSizeSquareSubMatrix {

	public static int getMaxSizeOfSubMatrix(int[][] m) {
		int maxSize = 0;
		if(m.length > 0 && m[0].length > 0) {
			int [][] sizeMatrix = new int[m.length][m[0].length];
			for(int i = 0; i < m.length; i++)
				sizeMatrix[i][0] = m[i][0];
			for(int i = 0; i < m[0].length; i++)
				sizeMatrix[0][i] = m[0][i];
				
			for(int i = 1; i < m.length; i++) {
				for(int j = 1; j < m[0].length; j++) {
					if(m[i][j] == 1) {
						int min1 = Integer.min(sizeMatrix[i-1][j], sizeMatrix[i][j-1]);
						int min2 = Integer.min(min1, sizeMatrix[i-1][j-1]) + 1;
						sizeMatrix[i][j] = min2;
						maxSize = Integer.max(maxSize, min2);
					} else {
						sizeMatrix[i][j] = m[i][j];
					}
				}
			}
		}
		return maxSize;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = {{0,1,1,0,1},
					{1,1,0,1,0},
					{0,1,1,1,0},
					{1,1,1,1,0}};
		System.out.println(getMaxSizeOfSubMatrix(a));
	}

}
