package linkedlist;


/**
 * http://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 * @author sbhalekar
 *
 */
public class SortedListIntersection {
	
	private static void intersectionUtil(Node h1, Node h2, LinkedList result, int prevData) {
		if(h1 == null || h2 == null) {
			return;
		}
		
		if(h1.data == h2.data && h1.data != prevData) {
			result.addElement(h1.data);
			intersectionUtil(h1.next, h2.next, result, h1.data);
		} else if(h1.data < h2.data)
			intersectionUtil(h1.next, h2, result, prevData);
		else
			intersectionUtil(h1, h2.next, result, prevData);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList result = new LinkedList();
		Node h1 = new Node(1);
		h1.next = new Node(2);
		h1.next.next = new Node(2);
		h1.next.next.next = new Node(4);
		h1.next.next.next.next = new Node(6);
		
		Node h2 = new Node(2);
		h2.next = new Node(2);
		h2.next.next = new Node(2);
		h2.next.next.next = new Node(6);
		
		intersectionUtil(h1, h2, result, -1);
		result.printList();
	}

}
