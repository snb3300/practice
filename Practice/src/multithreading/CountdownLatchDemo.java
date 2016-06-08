package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread aggregatorService = new Thread(new Service("AggregatorService", 1000, latch));
		Thread validatorService = new Thread(new Service("ValidatorService", 1000, latch));
		
		cacheService.start();
		aggregatorService.start();
		validatorService.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All Services have been initialized");
	}

}

class Service implements Runnable {
	
	private String name;
	private long initTime;
	private CountDownLatch latch;
	
	public Service(String name, long initTime, CountDownLatch latch) {
		this.name = name;
		this.initTime = initTime;
		this.latch = latch;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(this.initTime);
			System.out.println(this.name + " initialized");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.latch.countDown();
	}
	
}