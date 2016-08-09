package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BFSGraph {
	
	public static List<Integer> bfs(Graph g, int startVertex) {
		List<Integer> traversal = new ArrayList<Integer>();
		Queue q = new Queue();
		int vertices = g.getVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		visited[startVertex] = true;
		q.enqueue(startVertex);
		traversal.add(startVertex);
		while(!q.isEmpty()) {
			int v = q.dequeue();
			Iterator<Integer> it = g.getAdjList(v).iterator();
			while(it.hasNext()) {
				int x = it.next();
				if(!visited[x]) {
					q.enqueue(x);
					traversal.add(x);
					visited[x] = true;
				}
			}
		}
		return traversal;
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
        System.out.println(bfs(g, 0));
	}

}
