package arrays;

import java.util.PriorityQueue;

/**
 * http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
 * @author sbhalekar
 *
 */

public class PrintSortedElements {
	private class data implements Comparable<data>{
		int x;
		int row;
		int rowIndex;
		
		public data(int x, int row, int rowIndex) {
			this.x = x;
			this.row = row;
			this.rowIndex = rowIndex;
		}
		
		@Override
		public int compareTo(data o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
		
		public String toString() {
			return Integer.toString(x);
		}
	};
	public void print(int[][] matrix) {
		int N = matrix[0].length;
		int M = matrix.length;
		PriorityQueue<data> heap = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			heap.add(new data(matrix[i][0], i, 1));
		}
		
		while(!heap.isEmpty()) {
			data min = heap.poll();
			if(min.rowIndex < N - 1)
				heap.add(new data(matrix[min.row][min.rowIndex + 1], min.row, min.rowIndex + 1));
			System.out.print(" " + min.x);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{10,20,30,40},{15,25,35,45},{27,29,37,48}, {32,33,39,50}};
		new PrintSortedElements().print(mat);
	}

}
