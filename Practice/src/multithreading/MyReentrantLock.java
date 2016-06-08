package multithreading;

public class MyReentrantLock {
	
	private boolean isLocked;
	private Thread lockedBy;
	private int lockCount;
	private final Object sync;
	
	public MyReentrantLock() {
		this.isLocked = false;
		this.lockedBy = null;
		this.lockCount = 0;
		sync = new Object();
	}
	
	
	public void lock() throws InterruptedException {
		while(isLocked && lockedBy != Thread.currentThread())
			sync.wait();
		isLocked = true;
		lockedBy = Thread.currentThread();
		lockCount += 1;
	}
	
	public void unlock() throws InterruptedException {
		if(!isLocked || lockedBy != Thread.currentThread())
			return;
		lockCount -= 1;
		if(lockCount == 0) {
			isLocked = false;
			sync.notify();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
