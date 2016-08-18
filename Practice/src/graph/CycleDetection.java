package graph;

import java.util.Arrays;
import java.util.Stack;

public class CycleDetection {
	
	public static boolean isCircular(Graph g, int startVertex) {
		if(!g.isEmpty()) {
			int vertices = g.getVertices();
			Stack<Integer> stack = new Stack<Integer>();
			boolean[] visited = new boolean[vertices];
			Arrays.fill(visited, false);
			stack.push(startVertex);
			visited[startVertex] = true;
			
			
			
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
