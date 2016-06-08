package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer1 {
	
	private List<Integer> buffer;
	private int bufferSize;
	
	public ProducerConsumer1(int bufferSize) {
		buffer = new ArrayList<>(bufferSize);
		this.bufferSize = bufferSize;
	}
	
	public boolean isEmpty() {
		synchronized (buffer) {
			return buffer.isEmpty();
		}
	}
	
	public boolean isFull() {
		synchronized (buffer) {
			return this.buffer.size() == this.bufferSize;
		}
	}
	
	public void produce(Integer data) throws InterruptedException {
		synchronized (buffer) {
			while(this.isFull())
				buffer.wait();
			System.out.println("Produced : " + data);
			buffer.add(data);
			buffer.notifyAll();
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized (buffer) {
			while(this.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " waiting for producer");
				buffer.wait();
			}
			System.out.println("Removed : " + buffer.remove(0));
			buffer.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] values = {1,2,3,4,5};
		Thread[] producers = new Thread[values.length];
		Thread[] consumers = new Thread[values.length];
		ProducerConsumer1 pc = new ProducerConsumer1(values.length - 1);
		
		for(int i = 0; i < values.length; i++) {
//			producers[i] = new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					try {
//						Random r = new Random();
//						pc.produce(r.nextInt());
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			});
			
			consumers[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						pc.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		
		for(int i = 0; i < values.length; i++) {
			consumers[i].start();
//			producers[i].start();
		}
		
		for(int i = 0; i < values.length; i++) {
			try {
				consumers[i].join();
//				producers[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}

}
