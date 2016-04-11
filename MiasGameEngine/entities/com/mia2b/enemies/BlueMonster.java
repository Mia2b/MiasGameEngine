package com.mia2b.enemies;

import java.awt.image.BufferedImage;

import com.mia2b.display.SpriteAssets;

public class BlueMonster extends ParentEnemy{
	private BufferedImage image = SpriteAssets.getEnemy().get(0);
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
}