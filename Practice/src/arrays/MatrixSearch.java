package arrays;

public class MatrixSearch {
	
    private boolean binarySearchUtil(int[] arr, int l, int h, int t) {
        if(l > h)
            return false;
            
        int mid = (l + h) / 2;
        if(arr[mid] == t)
            return true;
        if(t < arr[mid])
            return binarySearchUtil(arr, l, mid - 1, t);
        return binarySearchUtil(arr, mid + 1, h, t);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] >= target) {
                return matrix[i][0] <= target ? binarySearchUtil(matrix[i], 0, col, target) : false;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{1}};
		int target = 1;
		
		System.out.println(new MatrixSearch().searchMatrix(m, target));
	}

}
