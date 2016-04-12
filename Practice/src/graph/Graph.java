package graph;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int vertices;
	private List<Integer> adjList[];
	
	public Graph(int v) {
		vertices = v;
		adjList = new List[vertices];
		for(int i = 0; i < vertices; ++i)
			adjList[i] = new LinkedList<Integer>();
	}
	
	public int getVertices() {
		return this.vertices;
	}
	
	public void addEdge(int src, int dst) {
		adjList[src].add(dst);
	}
	
	public List<Integer> getAdjList(int vertex) {
		return adjList[vertex];
	}
}
