package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Threads1 {
	
	public static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	
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
	
	public static Callable<String> callable(String result, long timeout) {
		return () -> {
			TimeUnit.SECONDS.sleep(timeout);
			return result;
		};
	}
	
	public static Callable<Integer> increment() {
		return () -> {
			try {
				lock.lock();
				return count++;
			} finally {
				lock.unlock();
			}
		};
	}
	
	public static void simpleSyncExecutor() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEachOrdered(i -> executor.submit(Threads1.increment()));
		stopExecutor(executor);
		System.out.println(count);
	}
	
	public static void invokeAnyCallableExecutor() {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
					callable("task1", 2),
					callable("task2", 1),
					callable("task3", 3)
				);
		try {
			String result = executor.invokeAny(callables);
			System.out.println(result);
			stopExecutor(executor);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void simpleCallableExecutor() {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		try {
			System.out.println("Future isDone? " + future.isDone());
			Integer result = future.get();
			System.out.println("Future isDone? " + future.isDone());
			System.out.println("Result = " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopExecutor(executor);
	}
	
	public static void simpleRunnableExecutor() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});
		stopExecutor(executor);
	}
	
	public static void simpleRunnableWithSleep() {
		Runnable runnable = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println("Foo " + threadName);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + threadName);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
	}
	
	public static void simpleRunnable() {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		
		task.run();
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		simpleRunnableWithSleep();
//		simpleRunnableExecutor();
//		simpleCallableExecutor();
//		invokeAnyCallableExecutor();
//		simpleSyncExecutor();
		
		BlockingQueue<String> bq = new LinkedBlockingQueue<String>();
	
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return bq.take();
			}
		};
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				bq.add("abc");
			}
		};
		
		List<Future<String>> futures = new ArrayList<>();
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(callable);
		callables.add(callable);
		callables.add(callable);
		callables.add(callable);
		
		try {
			futures = executor.invokeAll(callables);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		executor.submit(runnable);
		executor.submit(runnable);
		executor.submit(runnable);
		
//		executor.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				bq.add("abc");
//			}
//		});
		
		for(Future<String> f : futures) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		stopExecutor(executor);
	}

}
