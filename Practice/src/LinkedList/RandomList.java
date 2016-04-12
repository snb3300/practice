package LinkedList;

public class RandomList {
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode h = null;
		if(head != null) {
			RandomListNode n1 = head.next;
			h = new RandomListNode(head.label);
			RandomListNode n2 = h;
			
			while(n1 != null) {
				RandomListNode n3 = new RandomListNode(n1.label);
				n2.next = n1.next;
				n1.next = n2;
				n1 = n2.next;
			}
		}
		return h;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
