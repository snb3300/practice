package LinkedList;

class Node {
	int data;
	Node next;
	
	public Node(int x) {
		this.data = x;
		this.next = null;
	}
}


public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addElement(int x) {
		Node n = new Node(x);
		if(this.isEmpty()) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
		this.size += 1;
	}
	
	public void printList() {
		Node n = this.head;
		while(n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}
	
	public int deleteNode() {
		int n = Integer.MIN_VALUE;
		if(head != null) {
			n = head.data;
			head = head.next;
			this.size -= 1;
		} else {
			tail = null;
		}
		return n;
	}
	
	public void reverseIter() {
		Node prev, curr, next;
		prev = null;
		curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next; 
		}
		head = prev;
	}
	
	public Node recuHelper(Node prev, Node curr) {
		if(curr == null)
			return prev;
		Node next = curr.next;
		curr.next = prev;
		return recuHelper(curr, next);
	}
	
	public void reverseRecur() {
		head = recuHelper(null, head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
//		int[] array = {1,2,3,4,5};
		int[] array = {1,2};
		for(int x : array)
			list.addElement(x);
		
		list.printList();
		System.out.println();
//		while(!list.isEmpty()) {
//			System.out.print(list.deleteNode());
//		}
//		
//		System.out.println("\nSize = " + list.getSize());
		list.reverseIter();
		list.printList();
		System.out.println();
		list.reverseRecur();
		list.printList();
	}

}
