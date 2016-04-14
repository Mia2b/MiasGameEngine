package com.mia2b.tiles;

import java.awt.image.BufferedImage;

import com.mia2b.characters.ParentCharacter;

public class ParentTile implements Cloneable{
//	private int x;
//	private int y;
//	private BufferedImage image;
	
	
	public void action() {
	}
	public BufferedImage getImage() {
		return null;
	}
	public void setY(int y) {
	}
	public int getY() {
		return 0;
	}
	public void setX(int x) {
	}
	public int getX() {
		return 0;
	}
	public int getDistanceFromPlayer(ParentCharacter character){
		return 0;
	}
}
