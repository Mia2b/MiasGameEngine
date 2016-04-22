package com.mia2b.world;

import java.util.ArrayList;

import com.mia2b.beta.Camera;
import com.mia2b.characters.ParentCharacter;
import com.mia2b.enemies.ParentEnemy;
import com.mia2b.gameControl.GameVariables;
import com.mia2b.tiles.ParentTile;

public class WorldUpdate {
	public void tick(double timeSinceLastTick){
		
		entitiesActions(timeSinceLastTick);
		GameVariables.addTps(1);
		
	}
	private void entitiesActions(double timeSinceLastTick) {
		Camera.setVisibleEntities();
		for (ParentCharacter i : new ArrayList<ParentCharacter>(WorldObjects.getCharacters())) {
			i.action(timeSinceLastTick);
		}
		for (ParentEnemy i :  new ArrayList<ParentEnemy>(WorldObjects.getEnemies())) {
			i.action();
		}
		for (ParentTile i :  new ArrayList<ParentTile>(WorldObjects.getTiles())) {
			i.action();
		}
		
	}
}
