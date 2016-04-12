package com.mia2b.characters;

import java.awt.image.BufferedImage;

import com.mia2b.beta.Camera;
import com.mia2b.display.SpriteAssets;
import com.mia2b.tiles.ParentTile;
import com.mia2b.world.KeysPressed;

public class FirstCharacter extends ParentCharacter{
	private BufferedImage image = SpriteAssets.getCharacter().get(0);
	private double x;
	private double y;
	private int speed = 64;
	private int rotateSpeed = 64;
	private double currentDirection = 45;
	private boolean isRealPlayer = false;
	
	public FirstCharacter (){
		speed = (int) (64 + Math.random()*1000);
		rotateSpeed=(int) (64 + Math.random()*2560);
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
		}else{
			currentDirection = currentDirection + (rotateSpeed * lastActionDelta);
			move(lastActionDelta,speed,currentDirection);
		}
	}
	private void move(double lastActionDelta , int speed, double direction ){
		int xSpeed = speed;
		int ySpeed = speed;
		for(ParentTile i: Camera.getVisibleTiles()){
			if (isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction ),32)){
				while(isInY(i,nextYPosition(lastActionDelta ,ySpeed,direction ),32)){
					ySpeed--;
				}
			}
				
			if(isInY(i,nextYPosition(lastActionDelta ,ySpeed,direction ),32)){
				while(isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction ),32)){
					xSpeed--;
				}
			}
		}
		this.x = nextXPosition(lastActionDelta ,xSpeed,direction );
		this.y = nextYPosition(lastActionDelta ,ySpeed,direction );
	}
	
	private boolean isInY(ParentTile i,double y, int offset){
		if(i.getY() < y && (i.getY()+offset) > y || i.getY() < y+offset && (i.getY()+offset) > y+offset){
			return true;
		}
		return false;
	}
	private boolean isInX(ParentTile i,double x, int offset){
		if(i.getX() < x && (i.getX()+offset) > x || i.getX() < x+offset && (i.getX()+offset) > x+offset){
			return true;
		}
		return false;
	}
	
	private double nextXPosition(double lastActionDelta , int xSpeed, double direction ){
		return this.x + (Math.cos(Math.toRadians(direction)) * xSpeed * lastActionDelta);
	}
	private double nextYPosition(double lastActionDelta , int ySpeed, double direction ){
		return this.y + (Math.sin(Math.toRadians(direction)) * ySpeed * lastActionDelta);
	}
	
}
