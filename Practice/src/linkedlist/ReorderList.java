package linkedlist;

public class ReorderList {
	
	private ListNode reverseLL(ListNode head, ListNode prev) {
		if(head == null)
			return prev;
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		return reverseLL(next, prev);
	}
	
	public void reorderList(ListNode head) {
		
		if(head == null || head.next == null)
			return;
		
		ListNode s = head;
		ListNode f = head;
		
		while(f != null && f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}
		
		
		ListNode h2 = s.next;
		s.next = null;
		h2 = reverseLL(h2, null);
		ListNode h1 = head;
		
		while(h2 != null) {
			ListNode l = h1.next;
			ListNode r = h2.next;
			h1.next = h2;
			h2.next = l;
			h1 = l;
			h2 = r;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rl = new ReorderList();
		int[] a = {1,2};
		ListNode head = null;
		ListNode tail = null;
		for(int x : a) {
			if(head == null && tail == null) {
				head = new ListNode(x);
				tail = head;
			} else {
				tail.next = new ListNode(x);
				tail = tail.next;
			}
		}
		RotateList.printList(head);
		rl.reorderList(head);
		RotateList.printList(head);
	}

}
