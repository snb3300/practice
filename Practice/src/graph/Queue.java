package graph;

import java.util.LinkedList;
import java.util.List;

public class Queue {
	private List<Integer> data;
	
	public Queue() {
		data = new LinkedList<>();
	}
	
	public void enqueue(int x) {
		data.add(x);
	}
	
	public int dequeue() {
		return data.remove(0);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
}
