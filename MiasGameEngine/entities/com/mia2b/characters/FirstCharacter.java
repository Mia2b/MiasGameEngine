package com.mia2b.characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
		ArrayList<ParentTile> tiles = Camera.getVisibleTiles();
		int xSpeed = speed;
		int ySpeed = speed;
		
		for(ParentTile i: tiles){
			while(collisionBox(i).intersects(nextXPosition(lastActionDelta ,xSpeed,direction ),nextYPosition(lastActionDelta ,ySpeed,direction ),WIDTH,HEIGHT)){
				if(collisionBox(i).intersects(nextXPosition(lastActionDelta ,xSpeed,direction ),y,WIDTH,HEIGHT))
					xSpeed--;
				if(collisionBox(i).intersects(x,nextYPosition(lastActionDelta ,ySpeed,direction ),WIDTH,HEIGHT))
					ySpeed--;
			}
		}
		this.x = nextXPosition(lastActionDelta ,xSpeed,direction );
		this.y = nextYPosition(lastActionDelta ,ySpeed,direction );
	}
	
	private Rectangle collisionBox(ParentTile i){
		return new Rectangle(i.getX(),i.getY(),WIDTH+1,HEIGHT+1);
		
	}
	private double nextXPosition(double lastActionDelta , int xSpeed, double direction ){
		return this.x + (Math.cos(Math.toRadians(direction)) * xSpeed * lastActionDelta);
	}
	private double nextYPosition(double lastActionDelta , int ySpeed, double direction ){
		return this.y + (Math.sin(Math.toRadians(direction)) * ySpeed * lastActionDelta);
	}
	
	void quickSort(ArrayList<ParentTile> out) {
		mainQuickSort(out, 0, out.size() - 1);
	}

	void mainQuickSort(ArrayList<ParentTile> out, int left, int right) {
		int index = quickSortPartition(out, left, right);
		if (left < (index - 1))
			mainQuickSort(out, left, index - 1);
		if (right > index)
			mainQuickSort(out, index, right);
	}

	int quickSortPartition(ArrayList<ParentTile> out, int left, int right) {
		int center = out.get((left + right) / 2).getDistanceFromPlayer(this);
		while (left <= right) {
			while (out.get(left).getDistanceFromPlayer(this) < center) {
				left++;
			}
			while (out.get(right).getDistanceFromPlayer(this) > center) {
				right--;
			}
			if (left <= right) {
				ParentTile temp = out.get(left); 
				out.set(left,out.get(right));
				out.set(right,temp);
				left++;
				right--;
			}
		}
		return left;
	}
	
	
}
