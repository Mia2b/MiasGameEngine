package com.mia2b.gameControl;

import com.mia2b.characters.FirstCharacter;
import com.mia2b.controlLoops.CombineThread;
import com.mia2b.display.DisplayWindow;
import com.mia2b.display.DisplayWindowAction;
import com.mia2b.display.SpriteAssets;
import com.mia2b.enemies.BlueMonster;
import com.mia2b.tiles.YellowTile;
import com.mia2b.world.WorldObjects;

public class StartUp {

	public static void main(String[] args) {
		
		GameState.setRunning(true);
		DisplayWindow.startDisplay();
		
		new DisplayWindowAction(DisplayWindow.getFrame());
		SpriteAssets.loadAssets();
		//Testing.makeMap();
		
		//WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addCharacter(new FirstCharacter(true),0,0);
		//WorldObjects.addEnemy(new BlueMonster(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		WorldObjects.addTile(new YellowTile(),128, 128);
		WorldObjects.addTile(new YellowTile(),128, 128+30);
		WorldObjects.addTile(new YellowTile(),128+30, 128+30);
		
		for (int i = 0;i < 1000; i++){
			
		//	WorldObjects.addCharacter(new FirstCharacter(),0,0);
		}
		
		
		DisplayWindow.getCanvas().addKeyListener(new KeyInput()) ;
		new CombineThread("Combine Thread", 100);
		

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
