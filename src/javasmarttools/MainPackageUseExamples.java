package javasmarttools;

import java.util.Random;

public class MainPackageUseExamples {

	public static void main(String[] args) throws InterruptedException {

		Stopwatch myWatch = new Stopwatch();
		Random myRandom = new Random();

		int laps = 5 + myRandom.nextInt(5); // select a number from 5 to 10

		System.out.println("Horses will run for " + laps + " laps");

		myWatch.reset();

		for (int i = 0; i < laps; i++) {

			int thisDelay = 500 + myRandom.nextInt(1000);

			System.out.print("Lap #" + (i + 1) + ". The horse is running... (wait)...");
			Thread.sleep(thisDelay);
			System.out.println("The last lap took " + myWatch.markLapDown() + "ms. Total Elapsed time is "
					+ myWatch.getElapsedTime() + "ms.");
		}

		myWatch.stop();
		System.out.println(
				"Total running time = " + myWatch.getElapsedTime() + "ms (˜" + myWatch.getElapsedTime() / 1000 + "s).");

	}

}
