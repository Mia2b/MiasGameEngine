package com.mia2b.controlLoops;

import com.mia2b.gameControl.GameState;
import com.mia2b.world.WorldRender;

public class RenderThread implements Runnable {
	Thread t;
	String tName;

	public RenderThread(String threadName) {
		tName = threadName;
		t = new Thread(this, tName);
		System.out.println("Starting " + t);
		t.start();
	}

	public void run() {
		loopRender();
	}

	private void loopRender() {
		try {
			WorldRender world = new WorldRender();
			while (GameState.isRunning()) {
				world.render();
				while (GameState.isSleeping()) {
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error On " + tName);
		}
	}
}
