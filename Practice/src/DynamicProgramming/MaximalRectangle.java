package DynamicProgramming;

import java.util.Stack;

public class MaximalRectangle {

	public static int largestRectangularArea(int[] heights) {
        int maxArea = -1;
        int area = 0;
        int i;
        Stack<Integer> stack = new Stack<Integer>();
        for(i = 0; i < heights.length;) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea)
                    maxArea = area;
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() - 1);
            }
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
    
    public static void fillArray(int[] heights, char[] row) {
        for(int i = 0; i < row.length; i++) {
            if(row[i] == '0') {
                heights[i] = 0;
            } else {
                heights[i] += Character.getNumericValue(row[i]);
            }
        }
    }
    
    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length > 0) {
            int[] heights = new int[matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                fillArray(heights, matrix[i]);
                int cur = largestRectangularArea(heights);
                max = Integer.max(cur, max);
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'0','1'}, {'1', '0'}};
		System.out.println(maximalRectangle(matrix));
	}

}
