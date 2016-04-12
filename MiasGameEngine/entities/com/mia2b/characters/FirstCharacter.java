package com.mia2b.characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.mia2b.beta.Camera;
import com.mia2b.display.SpriteAssets;
import com.mia2b.tiles.ParentTile;
import com.mia2b.world.KeysPressed;

public class FirstCharacter extends ParentCharacter{
	private BufferedImage image = SpriteAssets.getCharacter().get(0);
	private final int WIDTH = 32;
	private final int HEIGHT = 32;
	private double x;
	private double y;
	private int speed = 64;
	private int rotateSpeed = 64;
	private double currentDirection = 45;
	private boolean isRealPlayer = false;
	
	public FirstCharacter (){
		speed = 64*5;
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
			while (isTouching(i,nextYPosition(lastActionDelta ,ySpeed,direction ),nextXPosition(lastActionDelta ,xSpeed,direction ))){
				if(isInY(i,nextYPosition(lastActionDelta ,ySpeed,direction ))){
					ySpeed--;
				}
				if(isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction ))){
					System.out.println(isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction )));
					xSpeed--;
				}
			}
		}
		this.x = nextXPosition(lastActionDelta ,xSpeed,direction );
		this.y = nextYPosition(lastActionDelta ,ySpeed,direction );
	}
	private boolean isInY(ParentTile tile,double y){
		if((tile.getY() < y && (tile.getY()+HEIGHT) > y) ||( tile.getY() < (y+HEIGHT) && (tile.getY()+HEIGHT) > (y+HEIGHT))){
			return true;
		}
		return false;
	}
	private boolean isInX(ParentTile tile,double x){
		if((tile.getX() < x && (tile.getX()+WIDTH) > x) ||( tile.getX() < (x+WIDTH) && (tile.getX()+WIDTH) > (x+WIDTH))){
			return true;
		}
		return false;
	}
	
	private boolean isTouching(ParentTile tile,double x, double y){
		if (isInY(tile, y) && isInX(tile, x)){
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
