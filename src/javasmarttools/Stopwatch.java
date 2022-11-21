package javasmarttools;

public class Stopwatch {

	protected long stopwatchStartedTime = 0, stopwatchElapsedTime = 0,

			lapStartedTime = 0, lapElapsedTime = 0;

	/*
	 * Stopwatch functions
	 */

	// reset all the counters
	public void reset() {
		this.stopwatchStartedTime = this.lapStartedTime = getCurrentTime();
		this.stopwatchElapsedTime = this.lapElapsedTime = 0L;
	}

	// stop main timer (stopwatch timer)
	public long stop() {
		this.markLapDown();
		return stopwatchElapsedTime;
	}

	// returns elapsed stopwatch time since last 'lapMarkDown' or 'stop'
	public long getElapsedTime() {
		return stopwatchElapsedTime;
	}

	/*
	 * Lap Functions
	 */

	// save last lap time
	public long markLapDown() {
		long currentTime = this.getCurrentTime();
		stopwatchElapsedTime = currentTime - stopwatchStartedTime;
		lapElapsedTime = currentTime - lapStartedTime;
		lapStartedTime = currentTime;
		return this.getLastLap();
	}

	// get last lap time
	public long getLastLap() {
		return lapElapsedTime;

	}

	/*
	 * Internal + control Functions
	 */

	// starts timer when object is created - can be reset on 'reset' method
	public Stopwatch() {
		this.reset();
	}

	protected long getCurrentTime() {
		return System.currentTimeMillis();
	}

}