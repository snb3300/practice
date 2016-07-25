package arrays;

/**
 * http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 * @author sbhalekar
 *
 */
public class TimeToRotAllOranges {

	private static int[] x = {-1,1,0,0};
	private static int[] y = {0,0,-1,1};
	
	public static boolean isValid(int i, int j, int R, int C) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}
	
	public static int getMinTime(int[][] mat) {
		int time = -1;
		int[] delimeter = {-1, -1};
		boolean wasDelimeter = false;
		Queue q = new Queue(); 
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 2) {
					int[] a = {i,j};
					q.enqueue(a);
					mat[i][j] = 0;
				}
			}
		}
		q.enqueue(delimeter);
		System.out.println(q);
		
		while(!q.isEmpty()) {
			int[] rotten = q.dequeue();
			if(wasDelimeter) {
				time += 1;
				wasDelimeter = false;
			}
			
			if(rotten[0] == -1) {
				wasDelimeter = true;
				if (!q.isEmpty())
					q.enqueue(delimeter);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int newX = rotten[0] + x[i];
				int newY = rotten[1] + y[i];
				
				if(isValid(newX, newY, mat.length, mat[0].length) && mat[newX][newY] == 1) {
					mat[newX][newY] = 2;
					int[] r = {newX, newY};
					q.enqueue(r);
				}
			}
		}
		return time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		System.out.println(getMinTime(mat));
	}

}

class Queue {
	private class Node {
		int[] data;
		Node next;
		
		Node(int[] data) {
			this.data = data;
			next = null;
		}
		
		public String toString() {
			return "{" + data[0] + " " + data[1] + "}";
		}
	}
	
	Node head, tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void enqueue(int[] d) {
		Node n = new Node(d);
		if(this.isEmpty()) {
			head = n;
			tail = head;
		} else {
			tail.next = n;
			tail = tail.next;
		}
	}
	
	public int[] dequeue() {
		Node n = head;
		head = head.next;
		if(head == null)
			tail = null;
		return n != null ? n.data : null;
	}
	
	public String toString() {
		Node n = head;
		StringBuffer buff = new StringBuffer();
		while(n != null) {
			buff.append(n + " ");
			n = n.next;
		}
		return buff.toString();
	}
}
