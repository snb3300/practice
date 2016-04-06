import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFSGraph {

	public static List<Integer> getDFS(Graph g, int startVertex) {
		List<Integer> dfs = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int vertices = g.getVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		visited[startVertex] = true;
		dfs.add(startVertex);
		stack.push(startVertex);
		while(!stack.isEmpty()) {
			int v = stack.pop();
			Iterator<Integer> i = g.getAdjList(v).iterator();
			while(i.hasNext()) {
				int adj = i.next();
				if(!visited[adj]) {
					stack.push(adj);
					visited[adj] = true;
					dfs.add(adj);
				}
			}
		}
		return dfs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
		g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(getDFS(g, 0));
	}

}
