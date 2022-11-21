package javasmarttools;

public class Stopwatch {
	
	protected
	  long stopwatchStartedTime = 0,
		   stopwatchElapsedTime = 0,
		   
	       lapStartedTime = 0,
	       lapElapsedTime = 0;
	
	/*
	 * Stopwatch functions
	 */

	public void reset() {
		this.stopwatchStartedTime = this.lapStartedTime = getCurrentTime();
		this.stopwatchElapsedTime = this.lapElapsedTime = 0L;
	}
	
	public long stop() {
		this.markLapDown();
		return stopwatchElapsedTime;
	}
	
	// returns elapsed time in the last lapMarkDown
	public long getElapsedTime() {
		return stopwatchElapsedTime;
		
	}
	
	/*
	 * Lap Functions
	 */

	public long markLapDown() {
		long currentTime = this.getCurrentTime();
		
		stopwatchElapsedTime = currentTime - stopwatchStartedTime;
		lapElapsedTime = currentTime - lapStartedTime;
		lapStartedTime = currentTime;
		
		return this.getLastLap();
	}
	
	public long getLastLap() {
		return lapElapsedTime;
		
	}
	
	/*
	 * Internal + control Functions
	 */


	public Stopwatch() {
		this.reset();
	}
	
	protected long getCurrentTime() {
		return System.currentTimeMillis();
	}

}