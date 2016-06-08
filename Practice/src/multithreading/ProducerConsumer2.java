package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {
	
	private List<Integer> buffer;
	private int bufferSize;
	private ReentrantLock lock;
	private Condition empty;
	private Condition full;
	
	public ProducerConsumer2(int bufferSize) {
		buffer = new LinkedList<Integer>();
		this.bufferSize = bufferSize;
		lock = new ReentrantLock();
		empty = lock.newCondition();
		full = lock.newCondition();
	}
	
	public boolean isEmpty() {
		try {
			lock.lock();
			return buffer.isEmpty();
		} finally {
			lock.unlock();
		}
	}
	
	public boolean isFull() {
		try {
			lock.lock();
			return buffer.size() == this.bufferSize;
		} finally {
			lock.unlock();
		}
	}
	
	public void produce(Integer data) throws InterruptedException {
		lock.lock();
		try {
			while(this.isFull()) {
				System.out.println(Thread.currentThread().getName() + " waiting for consumer");
				empty.await();
			}
			System.out.println("Produced : " + data);
			this.buffer.add(data);
			full.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void consume() throws InterruptedException {
		lock.lock();
		try {
			while(this.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " waiting for producer");
				full.await();
			}
			System.out.println("Cosumed : " + this.buffer.remove(0));
			empty.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public static Runnable producer(ProducerConsumer2 pc2, int data) {
		return () -> {
			try {
				pc2.produce(data);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	public static Runnable consumer(ProducerConsumer2 pc2) {
		return () -> {
			try {
				pc2.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] values = {1,2,3,4,5};
		ProducerConsumer2 pc = new ProducerConsumer2(values.length);
		
		Thread[] producers = new Thread[values.length];
		Thread[] consumers = new Thread[values.length+1];
		
		for(int i = 0; i < values.length; i++) {
			producers[i] = new Thread(producer(pc, values[i]));
		}
		
		for(int i = 0; i <= values.length; i++) {
			consumers[i] = new Thread(consumer(pc));
		}
		
		for(int i = 0; i < values.length; i++)
			producers[i].start();
		
		for(int i = 0; i <= values.length; i++)
			consumers[i].start();
		
		for(int i = 0; i <= values.length; i++) {
			if(i < values.length)
				producers[i].join();
			consumers[i].join();
		}
	}
}
