package com.mia2b.characters;

import java.awt.image.BufferedImage;

import com.mia2b.beta.Camera;
import com.mia2b.display.SpriteAssets;
import com.mia2b.world.KeysPressed;

public class FirstCharacter extends ParentCharacter{
	private BufferedImage image = SpriteAssets.getCharacter().get(0);
	private double x;
	private double y;
	private int speed = 64;
	private double currentDirection = 45;
	private boolean isRealPlayer = false;
	
	public FirstCharacter (){
		speed = (int) (1024 + Math.random()*2048);

	}
	public FirstCharacter (boolean isReal){
		this();
		isRealPlayer = isReal;
		

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
		
		moveWithInput(lastActionDelta, isRealPlayer);
		
	}


	private void moveWithInput(double lastActionDelta, boolean isMainPlayer) {
		if(isMainPlayer){
			if(KeysPressed.contains('W') && KeysPressed.contains('A')){
				currentDirection=225;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('A') && KeysPressed.contains('S')){
				currentDirection=135;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('S') && KeysPressed.contains('D')){
				currentDirection=45;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('D') && KeysPressed.contains('W')){
				currentDirection=315;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('W')){
				currentDirection=270;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('A')){
				currentDirection=180;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('S')){
				currentDirection=90;
				move(lastActionDelta,speed,currentDirection);
			}else
			if(KeysPressed.contains('D')){
				currentDirection=0;
				move(lastActionDelta,speed,currentDirection);
			}
			Camera.setCameraX(x);
			Camera.setCameraY(y);
		}
	}
	private void move(double lastActionDelta , int speed, double direction ){
		this.x += Math.cos(Math.toRadians(direction)) * speed * lastActionDelta;
		this.y += Math.sin(Math.toRadians(direction)) * speed * lastActionDelta;
	}
}
