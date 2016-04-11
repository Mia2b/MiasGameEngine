package com.mia2b.controlLoops;

import com.mia2b.gameControl.GameState;
import com.mia2b.world.WorldUpdate;

public class TickThread implements Runnable {
	Thread t;
	String tName;

	public TickThread(String threadName) {
		tName = threadName;
		t = new Thread(this, tName);
		System.out.println("Starting " + t);
		t.start();
	}

	public void run() {
		loopTick();
	}

	private void loopTick() {
		try {
			WorldUpdate update = new WorldUpdate(); // Construct update

			final double ticks = 60D; // Initialize and set tick rate
			double lastTime = System.nanoTime(); // Get the current time to
			double lastUpdate = System.nanoTime();
			double deltaTime = 0; // Initialize the delta
			double ticksPerSecond = 1000000000 / ticks; // Calculate Ticks Per Second
		

			while (GameState.isRunning()) { // While running

				long currentTime = System.nanoTime(); // Get the current time
				deltaTime += (currentTime - lastTime) / ticksPerSecond; // Calculate
																		// the
																		// delta
																		// time
				lastTime = currentTime; // Set last time to the current time

				if (deltaTime >= 1) { // if the delta is greater than 1
					update.tick((currentTime-lastUpdate)/1000000000); // then call tick
					deltaTime--; // subtract from delta to set it back below 1
					lastUpdate = currentTime;
				}
				while (GameState.isSleeping()) { // While sleeping
					Thread.sleep(500); // Wait
				} // loop till out of sleeping

			} // While running
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error On" + tName);
		}
	}
}
