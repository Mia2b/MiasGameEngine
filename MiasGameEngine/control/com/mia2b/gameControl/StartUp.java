package com.mia2b.gameControl;

import com.mia2b.controlLoops.renderThread;
import com.mia2b.controlLoops.tickThread;
import com.mia2b.display.DisplayWindow;
import com.mia2b.display.DisplayWindowAction;
import com.mia2b.display.SpriteAssets;
import com.mia2b.characters.*;
import com.mia2b.enemies.*;
import com.mia2b.tiles.*;
import com.mia2b.world.WorldObjects;

public class StartUp {

	public static void main(String[] args) {
		
		GameState.setRunning(true);
		DisplayWindow.startDisplay();
		
		new DisplayWindowAction(DisplayWindow.getFrame());
		SpriteAssets.loadAssets();
		System.out.println("here");
		//Testing.makeMap();
		
		//WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		
		for (int i = 0;i < 10; i++){
			WorldObjects.addEnemy(new BlueMonster(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
			WorldObjects.addTile(new RedTile(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		}
		
		System.out.println("here");
		new tickThread("Tick-Loop");													
		new renderThread("Render-Loop");
		

		GetAndSetFpsTps();

		
	}

	private static void GetAndSetFpsTps() {
		while (GameState.isRunning()) {
			GameVariables.setTps(0);
			GameVariables.setFps(0);
			GameVariables.setCps(0);
			try {																					
				Thread.sleep(500);																		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DisplayWindow.setFrameName("Ticks/s: " + GameVariables.getTps()*2 + " | Frame/s: " + GameVariables.getFps()*2 + "| Bounces/s "+ GameVariables.getCps()*2 + "| Objects: " + (WorldObjects.getCharacters().size()+WorldObjects.getEnemies().size()+WorldObjects.getTiles().size()));
		}
	}
}
