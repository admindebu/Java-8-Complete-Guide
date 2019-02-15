
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author manojgovindaraj
 *
 */
public class ReadWriteAndStampedLocks {

	Map<String, String> map = new HashMap<>();

	void testReadWriteLock() {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable writeTask = () -> {
			lock.writeLock().lock();
			try {
				System.out.println("Write Inprogress....");
				TimeUnit.SECONDS.sleep(5);
				map.put("key", "value");
				System.out.println("Write Completed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		};

		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println("Read Inprogress....");
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Read Completed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		};

		executor.submit(writeTask);
		executor.submit(readTask);
		executor.submit(readTask);

		stop(executor);
	}

	void testStampedLock() {
		StampedLock lock = new StampedLock();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable writeTask = () -> {
			long writeLockStamp = lock.writeLock();
			try {
				System.out.println("Write Inprogress....");
				TimeUnit.SECONDS.sleep(5);
				map.put("key", "value");
				System.out.println("Write Completed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlockWrite(writeLockStamp);
			}
		};

		Runnable readTask = () -> {
			// long readLockStamp = lock.tryOptimisticRead();
			long readLockStamp = lock.readLock();
			try {
				System.out.println("Read Inprogress....");
				System.out.println("Is Lock Valid: " + lock.validate(readLockStamp));
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Read Completed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlockRead(readLockStamp);
			}
		};

		executor.submit(writeTask);
		executor.submit(readTask);
		executor.submit(readTask);
		stop(executor);
	}

	public static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public static class Main {
		public static void main(String[] args) {
			ReadWriteAndStampedLocks readWriteAndStampedLocks = new ReadWriteAndStampedLocks();
			readWriteAndStampedLocks.testReadWriteLock();
			// readWriteAndStampedLocks.testStampedLock();
		}
	}

}
