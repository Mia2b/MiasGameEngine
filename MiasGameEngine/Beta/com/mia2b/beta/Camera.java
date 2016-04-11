package com.mia2b.beta;

import java.util.ArrayList;

import com.mia2b.characters.ParentCharacter;
import com.mia2b.display.DisplayWindow;
import com.mia2b.enemies.ParentEnemy;
import com.mia2b.tiles.ParentTile;
import com.mia2b.world.WorldObjects;

public class Camera {
	private static double CameraX = getBufferWidth();
	private static double CameraY = getBufferHeight();
	
	private static int bufferWidth = DisplayWindow.getFrame().getWidth()/2;
	private static int bufferHeight = DisplayWindow.getFrame().getHeight()/2;
	
	private static int renderBuffer = 64;
	
	private static volatile ArrayList<ParentCharacter> visibleCharacters = new ArrayList<ParentCharacter>();
	private static volatile ArrayList<ParentEnemy> visibleEnemies = new ArrayList<ParentEnemy>();
	private static volatile ArrayList<ParentTile> visibleTiles = new ArrayList<ParentTile>();
	
	public static int getCameraX() {
		return (int) CameraX;
	}
	public static void setCameraX(double cameraX) {
		CameraX = cameraX;
	}
	public static int getCameraY() {
		return (int) CameraY;
	}
	public static void setCameraY(double cameraY) {
		CameraY = cameraY;
	}
	
	public static void setVisibleEntities(){
		visibleCharacters.clear();
		visibleEnemies.clear();
		visibleTiles.clear();
		
		for (ParentCharacter i : new ArrayList<ParentCharacter>(WorldObjects.getCharacters())) {
			if(i.getX() < getCameraX()+(getBufferWidth()+getRenderBuffer()) && i.getX() > getCameraX()-(getBufferWidth()+getRenderBuffer()) && i.getY() < getCameraY()+(getBufferHeight()+getRenderBuffer()) && i.getY() > getCameraY()-(getBufferHeight()+getRenderBuffer())){
				visibleCharacters.add(i);
			}
		}
		for (ParentEnemy i :  new ArrayList<ParentEnemy>(WorldObjects.getEnemies())) {
			if(i.getX() < getCameraX()+(getBufferWidth()+getRenderBuffer()) && i.getX() > getCameraX()-(getBufferWidth()+getRenderBuffer()) && i.getY() < getCameraY()+(getBufferHeight()+getRenderBuffer()) && i.getY() > getCameraY()-(getBufferHeight()+getRenderBuffer())){
				visibleEnemies.add(i);
			}
		}
		for (ParentTile i :  new ArrayList<ParentTile>(WorldObjects.getTiles())) {
			if(i.getX() < getCameraX()+(getBufferWidth()+getRenderBuffer()) && i.getX() > getCameraX()-(getBufferWidth()+getRenderBuffer()) && i.getY() < getCameraY()+(getBufferHeight()+getRenderBuffer()) && i.getY() > getCameraY()-(getBufferHeight()+getRenderBuffer())){
				visibleTiles.add(i);
			}
		}
	}
	
	public static ArrayList<ParentCharacter> getVisibleCharacters() {
		return visibleCharacters;
	}
	public static ArrayList<ParentEnemy> getVisibleEnemies() {
		return visibleEnemies;
	}
	public static ArrayList<ParentTile> getVisibleTiles() {
		return visibleTiles;
	}
	public static int getRenderBuffer() {
		return renderBuffer;
	}
	public static void setRenderBuffer(int renderBuffer) {
		Camera.renderBuffer = renderBuffer;
	}
	public static int getBufferWidth() {
		return bufferWidth;
	}
	public static void setBufferWidth(int bufferWidth) {
		Camera.bufferWidth = bufferWidth;
	}
	public static int getBufferHeight() {
		return bufferHeight;
	}
	public static void setBufferHeight(int bufferHeight) {
		Camera.bufferHeight = bufferHeight;
	}
}
