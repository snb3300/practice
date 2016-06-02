package multithreading;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
	private List<Integer> dataStructure;
//	private Integer[] dataStructure;
	private final int size;
	private Lock lock;
	private Condition full;
	private Condition empty;
	
	
	public MyBlockingQueue(int size) {
		this.size = size;
		dataStructure = new LinkedList<Integer>();
		lock = new ReentrantLock();
		full = lock.newCondition();
		empty = lock.newCondition();
	}
	
	public int getLength() {
		int length = -1;
		lock.lock();
		try {
			length = this.dataStructure.size();
		} finally {
			lock.unlock();
		}
		return length;
	}
	
	public boolean isEmpty() {
		if(this.getLength() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(this.getLength() == this.size) {
			return true;
		}
		return false;
	}
	
	public int dequeue() throws InterruptedException {
		lock.lock();
		try {
			while(this.isEmpty())
				full.await();
			int result = this.dataStructure.remove(0);
			empty.signalAll();
			return result;
		} finally {
			lock.unlock();
		}
	}
	
	public void enqueue(Integer data) throws InterruptedException {
		lock.lock();
		try {
			while(this.isFull())
				empty.await();
			this.dataStructure.add(data);
			full.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public static void stopExecutor(ExecutorService executor) {
		try {
			System.out.println("attempting to shutdown executor service");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (! executor.isTerminated()) {
				System.err.println("Task did not terminate");
			}
			executor.shutdownNow();
		}
	}
	
	public static Runnable enque(MyBlockingQueue mbq, Integer data) {
		return () -> {
			try {
				mbq.enqueue(data);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	public static Runnable dequeue(MyBlockingQueue mbq) {
		return () -> {
			try {
				System.out.println("Dequeue : " + mbq.dequeue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	public static void main(String[] args) {
		MyBlockingQueue myBQ = new MyBlockingQueue(5);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Runnable> runnables = Arrays.asList(dequeue(myBQ),
				enque(myBQ, 1),
				enque(myBQ, 2),
				dequeue(myBQ),
				enque(myBQ, 3),
				dequeue(myBQ),
				enque(myBQ, 4),
				enque(myBQ, 5),
				dequeue(myBQ),
				dequeue(myBQ));
		for (Runnable runnable : runnables) {
			executor.submit(runnable);
		}
		stopExecutor(executor);
	}
}
