package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* To execute Java, please define "static void main" on a class
* named Solution.
*
* If you need more classes, simply define them inline.
*/

public class Solution {

	Queue q;

	public Solution(Queue q) {
		this.q = q;
	}
	
	public static Runnable enqueue(Queue q, String v) {
		return () -> {
			try {
				q.enqueue(v);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
	
	public static Runnable dequeue(Queue q) {
		return () -> {
			try {
				q.dequeue();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
	
	public static void main(String[] args) throws InterruptedException {
		Queue q = new Queue();
		
		List<Thread> dq = new ArrayList<>();
		List<Thread> eq = new ArrayList<>();
		
		String[] values = {"abc","pqr","lmn","stu"};		
		
		for(int i = 0; i < 5; i++)
			dq.add(new Thread(dequeue(q)));
		
		for(String v : values)
			eq.add(new Thread(enqueue(q, v)));
		
		
		for(int i = 0; i < dq.size(); i++)
			dq.get(i).start();
		
		for(int i = 0; i < eq.size(); i++)
			eq.get(i).start();
		
		for(int i = 0; i < eq.size(); i++)
			eq.get(i).join();
		
		for(int i = 0; i < dq.size(); i++)
			dq.get(i).join();
	}
}

class Queue {

	private Node head, tail;
	private Lock lock;
	private Condition empty;

	public Queue() {
		head = null;
		tail = null;
		lock = new ReentrantLock();
		empty = lock.newCondition();
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void enqueue(String v) throws InterruptedException {
		lock.lock();
		try {
			Node n = new Node(v, null);
			if (this.isEmpty()) {
				head = n;
				tail = n;
			} else {
				tail.next = n;
				tail = tail.next;
			}
			System.out.println();
			System.out.println(Thread.currentThread().getName() + " enqueued " + v + ". Notifying");
			System.out.println("Queue : " + this);
			empty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public String dequeue() throws InterruptedException {
		lock.lock();
		try{
			// This loop is necessary to confirm that queue has at least 1 value before proceeding with dequeue
			while (this.isEmpty()) {
				System.out.println("Queue Empty: " + Thread.currentThread().getName() + " is waiting to dequeu");
				empty.await();
			}
			Node temp = head;
			
			head = head.next;
			temp.next = null;
		
			if (head == null)
				tail = null;
			System.out.println();
			System.out.println(Thread.currentThread().getName() + " has dequeued " + temp.value);
			System.out.println("Queue : " + this);
			return temp.value;
		} finally {
			lock.unlock();
		}
	}

	private class Node {

		String value;
		Node next;

		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public String toString() {
		Node n = head;
		StringBuffer buff = new StringBuffer();
		while (n != null) {
			buff.append(n.value + " ");
			n = n.next;
		}
		return buff.toString();
	}

}