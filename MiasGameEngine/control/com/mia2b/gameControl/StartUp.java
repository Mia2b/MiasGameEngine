package com.mia2b.gameControl;

import com.mia2b.beta.Testing;
import com.mia2b.characters.FirstCharacter;
import com.mia2b.controlLoops.CombineThread;
import com.mia2b.controlLoops.RenderThread;
import com.mia2b.controlLoops.TickThread;
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
		Testing.addMap();
		
		//WorldObjects.addCharacter(new FirstCharacter(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		for(int i = 0;i<1;i++)
		WorldObjects.addCharacter(new FirstCharacter(true),0,0);
		
		
		//WorldObjects.addEnemy(new BlueMonster(),(int)(Math.random() * DisplayWindow.getFrame().getWidth()), (int)(Math.random() * DisplayWindow.getFrame().getHeight()));
		
		//for (int i = 0;i < 9000; i++){
		//	WorldObjects.addTile(new YellowTile(),(int)(Math.random() * DisplayWindow.getFrame().getWidth() *3), (int)(Math.random() * DisplayWindow.getFrame().getHeight()*3));
		//}
		
		
		DisplayWindow.getCanvas().addKeyListener(new KeyInput()) ;
		new CombineThread("Combine Thread", 999);
		//new TickThread("tick");
		//new RenderThread("pretty");
		

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
