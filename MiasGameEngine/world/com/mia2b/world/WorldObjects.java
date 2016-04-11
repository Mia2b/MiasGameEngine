package com.mia2b.world;

import java.util.ArrayList;
import com.mia2b.characters.ParentCharacter;
import com.mia2b.enemies.ParentEnemy;
import com.mia2b.tiles.ParentTile;

public class WorldObjects {
	private static volatile ArrayList<ParentCharacter> worldCharacters = new ArrayList<ParentCharacter>();
	private static volatile ArrayList<ParentEnemy> worldEnemies = new ArrayList<ParentEnemy>();
	private static volatile ArrayList<ParentTile> worldTiles = new ArrayList<ParentTile>();
	
	
	public static synchronized void addCharacter(ParentCharacter object,int startX,int startY){
		object.setX(startX);
		object.setY(startY);
		worldCharacters.add(object);
	}
	public static synchronized void addEnemy(ParentEnemy object,int startX,int startY){
		object.setX(startX);
		object.setY(startY);
		worldEnemies.add(object);
	}
	public static synchronized void addTile(ParentTile object,int startX,int startY){
		object.setX(startX);
		object.setY(startY);
		worldTiles.add(object);
	}
	
	public static ArrayList<ParentCharacter> getCharacters(){
		return worldCharacters;
		
	}
	public static ArrayList<ParentEnemy> getEnemies(){
		return worldEnemies;
		
	}
	public static ArrayList<ParentTile> getTiles(){
		return worldTiles;
		
	}
}
