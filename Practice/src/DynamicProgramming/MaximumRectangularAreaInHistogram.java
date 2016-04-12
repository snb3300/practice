package DynamicProgramming;

import java.util.Stack;

public class MaximumRectangularAreaInHistogram {

	public static int largestRectangleArea(int[] heights) {
        int maxArea = -1;
        int area = 0;
        int i;
        Stack<Integer> stack = new Stack<Integer>();
        for(i = 0; i < heights.length;) {
        	if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
        		stack.push(i++);
        	} else {
        		int top = stack.pop();
        		if(stack.empty())
        			area = heights[top] * i;
        		else {
        			area = heights[top] * (i - stack.peek() - 1);
        		}
        		if(area > maxArea)
        			maxArea = area;
        	}
        }
        while(!stack.isEmpty()) {
        	int top = stack.pop();
    		if(stack.empty())
    			area = heights[top] * i;
    		else {
    			area = heights[top] * (i - stack.peek() - 1);
    		}
    		if(area > maxArea)
    			maxArea = area;
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
		int i = new Integer('1');
	}

}
