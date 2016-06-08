package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("All parties have arrived at the barrier.");
			}
		});
		
		Thread t1 = new Thread(new NewService("CacheService",  barrier));
		Thread t2 = new Thread(new NewService("AggregatorService",  barrier));
		Thread t3 = new Thread(new NewService("ValidatorService",  barrier));
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class NewService implements Runnable {

	private String name;
	private CyclicBarrier barrier;
	
	public NewService(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(this.name + " is initialized and waiting on barrier");
			barrier.await();
			System.out.println(this.name + " has crossed the barrier");
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
