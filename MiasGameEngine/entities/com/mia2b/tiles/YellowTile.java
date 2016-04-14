package com.mia2b.tiles;

import java.awt.image.BufferedImage;

import com.mia2b.characters.ParentCharacter;
import com.mia2b.display.SpriteAssets;

public class YellowTile extends ParentTile{
	private BufferedImage image = SpriteAssets.getTile().get(0);
	private int x;
	private int y;
	
	
	@Override
	public int getX() {
		return x;
	}
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public BufferedImage getImage() {
		return image;
	}
	@Override
	public void action(){
		
	}
	@Override
	public int getDistanceFromPlayer(ParentCharacter character){
		int deltaX = (int) (this.x - character.getX());
		int deltaY = (int) (this.y - character.getY());
		return (int)(Math.sqrt(deltaX * deltaX) + (deltaY * deltaY));
	}
}