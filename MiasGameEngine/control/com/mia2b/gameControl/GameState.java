package com.mia2b.gameControl;

public class GameState {
	private static boolean running = false;
	private static boolean sleeping = false;
	
	public static boolean isRunning() {
		return running;
	}
	public static void setRunning(boolean running){
		GameState.running = running;
	}
	
	public static boolean isSleeping() {
		return sleeping;
	}
	public static void setSleeping(boolean sleeping) {
		GameState.sleeping = sleeping;
	}
	
	

}
