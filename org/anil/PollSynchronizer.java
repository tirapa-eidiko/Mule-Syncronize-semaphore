package org.anil;

import java.util.concurrent.Semaphore;

public class PollSynchronizer {

	private static final int MAX_PERMITS_NUMBER = 1;
	// private static final Logger log =
	// Logger.getLogger(PollSynchronizer.class);

	private Semaphore semaphore;

	public void lock() {
		try {
			getLock().acquire();
		} catch (InterruptedException e) {
			// log.error(e.getCause(), e);
		}
	}

	public void unlock() {
		getLock().release();
	}

	public Semaphore getLock() {
		if (semaphore == null) {
			this.semaphore = new Semaphore(MAX_PERMITS_NUMBER);
		}

		return this.semaphore;
	}

}
