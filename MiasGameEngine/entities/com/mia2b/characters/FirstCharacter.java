package com.mia2b.characters;

import java.awt.image.BufferedImage;

import com.mia2b.beta.Camera;
import com.mia2b.display.SpriteAssets;

public class FirstCharacter extends ParentCharacter{
	private BufferedImage image = SpriteAssets.getCharacter().get(0);
	private double x;
	private double y;
	private int speed = 64;
	private int rotateSpeed = 45;
	private double direction = 45;
	public FirstCharacter (){
		speed = (int) (Math.random()*256);
		rotateSpeed = (int) (Math.random()*256);;
	}
	
	
	@Override
	public double getX() {
		return x;
	}
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public double getY() {
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
	public void action(double lastActionDelta){
		move(lastActionDelta,speed,direction);
		Camera.setCameraX(x);
		Camera.setCameraY(y);
		direction += rotateSpeed * lastActionDelta;
		//split();
	}
	private void move(double lastActionDelta , int speed, double direction ){
		this.x += Math.cos(Math.toRadians(direction)) * speed * lastActionDelta;
		this.y += Math.sin(Math.toRadians(direction)) * speed * lastActionDelta;
	}
}
