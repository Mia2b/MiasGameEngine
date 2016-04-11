package com.mia2b.gameControl;

public class GameVariables {
	private static int tps = 0;
	private static int fps = 0;
	
	private static int cps = 0;
	
	public static int getTps() {
		return tps;							
	}
	public static void setTps(int tps) {
		GameVariables.tps = tps;					
	}
	public static void addTps (int add) {
		GameVariables.tps += add;				
	}
	public static int getFps() {
		return fps;							
	}
	public static void setFps(int fps) {
		GameVariables.fps = fps;					
	}
	public static void addFps (long add) {
		GameVariables.fps += add;				
	}
	public static int getCps() {
		return cps;
	}
	public static void setCps(int cps) {
		GameVariables.cps = cps;
	}
	public static void addCps(int add){
		GameVariables.cps += add;
	}
}
