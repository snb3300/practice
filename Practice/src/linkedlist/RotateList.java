package linkedlist;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  val = x;
	    	  next = null;
	      }
	      
	      public String toString() {
			return Integer.toString(val);
	    	  
	      }
	  }


public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
		if(head == null)
            return head;
        
        ListNode h1 = head;
        ListNode h2 = head;
        
        while(h2 != null) {
        	size += 1;
        	h2 = h2.next;
        }
        
        h2 = head;
        k = k % size;
        
        while(k > 0 && h2 != null) {
            h2 = h2.next;
            k -= 1;
        }
        
        while(h2 != null && h2.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        
        if(h2 != null) {
        	h2.next = head;
            head = h1.next;
            h1.next = null;
        }
        return head;
    }
	
	
	static void printList(ListNode head) {
		ListNode n = head;
		while(n != null) {
			System.out.print(" " + n.val);
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		RotateList rl = new RotateList();
		
		head = rl.rotateRight(head, 2000000000);
		
		printList(head);
	}

}
