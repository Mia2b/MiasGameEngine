package com.mia2b.world;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import com.mia2b.beta.Camera;
import com.mia2b.beta.Testing;
import com.mia2b.characters.ParentCharacter;
import com.mia2b.display.DisplayWindow;
import com.mia2b.enemies.ParentEnemy;
import com.mia2b.gameControl.GameVariables;
import com.mia2b.tiles.ParentTile;

public class WorldRender {
	private BufferStrategy bs;
	private Graphics g;

	public WorldRender() {
		
		if (bs == null) {
			DisplayWindow.getCanvas().createBufferStrategy(2);
			return;
		}
		
	}

	public void render() {
		bs = DisplayWindow.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, DisplayWindow.getFrame().getWidth(), DisplayWindow.getFrame().getHeight());
		// Draw
		drawEntities();
		
		//Testing.paintCompoent(g);
		//Output
		bs.show();
		g.dispose();
		GameVariables.addFps(1);
	}

	private void drawEntities() {
		Camera.setVisibleEntities();
		for (ParentCharacter i : new ArrayList<ParentCharacter>(Camera.getVisibleCharacters())) {
			//if(i != null)
			g.drawImage(i.getImage(), (int)i.getX()-Camera.getCameraX() + Camera.getBufferWidth()-16, (int)i.getY()-Camera.getCameraY() + Camera.getBufferHeight()-16, null);
		}
		for (ParentEnemy i :  new ArrayList<ParentEnemy>(Camera.getVisibleEnemies())) {
			//if(i != null)
			g.drawImage(i.getImage(), (int)i.getX()-Camera.getCameraX() + Camera.getBufferWidth()-16, (int)i.getY()-Camera.getCameraY() + Camera.getBufferHeight()-16, null);
		}
		for (ParentTile i :  new ArrayList<ParentTile>(Camera.getVisibleTiles())) {
			//if(i != null)
			g.drawImage(i.getImage(), (int)i.getX()-Camera.getCameraX() + Camera.getBufferWidth()-16, (int)i.getY()-Camera.getCameraY() + Camera.getBufferHeight()-16, null);
			}
	}
}
