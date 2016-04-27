package com.mia2b.characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.mia2b.beta.Camera;
import com.mia2b.display.SpriteAssets;
import com.mia2b.tiles.ParentTile;
import com.mia2b.world.KeysPressed;

public class FirstCharacter extends ParentCharacter {
	private BufferedImage image = SpriteAssets.getCharacter().get(0);
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	private double x;
	private double y;
	private double speed = 0;
	private double maxSpeed = 1024;
	private double accel = 1048;
	private int rotateSpeed = 64;
	private double currentDirection = 45;
	private boolean isRealPlayer = false;

	public FirstCharacter() {
		//speed = (int) (64 + Math.random() * 1024);
		//rotateSpeed = (int) (64 + Math.random() * 2560);
		//speed = 1024;
	}

	public FirstCharacter(boolean isReal) {
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
	public void action(double lastActionDelta) {

		moveWithInput(lastActionDelta, isRealPlayer);

	}

	private void moveWithInput(double lastActionDelta, boolean isMainPlayer) {
		if (isMainPlayer) {
			if (KeysPressed.contains('W') && KeysPressed.contains('A')) {
				currentDirection = 225;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('A') && KeysPressed.contains('S')) {
				currentDirection = 135;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('S') && KeysPressed.contains('D')) {
				currentDirection = 45;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('D') && KeysPressed.contains('W')) {
				currentDirection = 315;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('W')) {
				currentDirection = 270;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('A')) {
				currentDirection = 180;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('S')) {
				currentDirection = 90;speed += accel * 1 * lastActionDelta;
			} else if (KeysPressed.contains('D')) {
				currentDirection = 0; speed += accel * 1.5 * lastActionDelta;
			}else {
				speed -= accel * 2 * lastActionDelta;
			}
			
			if(speed > maxSpeed){
				speed=maxSpeed;
			} else if(speed < 0){
				speed = 0;
			}
			System.out.println(speed);
			move(lastActionDelta,(int) speed, currentDirection);
			Camera.setCameraX(x);
			Camera.setCameraY(y);
		} else {
			currentDirection = currentDirection + (rotateSpeed * lastActionDelta);
			move(lastActionDelta, (int)speed, currentDirection);
		}
	}

	private void move(double lastActionDelta, int speed, double direction) {
		/*
		 * <<<<<<< HEAD int xSpeed = speed; int ySpeed = speed; for(ParentTile
		 * i: Camera.getVisibleTiles()){ if
		 * (isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction ),32)){
		 * while(isInY(i,nextYPosition(lastActionDelta ,ySpeed,direction ),32)){
		 * ySpeed--; } }
		 * 
		 * if(isInY(i,nextYPosition(lastActionDelta ,ySpeed,direction ),32)){
		 * 
		 * while(isInX(i,nextXPosition(lastActionDelta ,xSpeed,direction ),32)){
		 * xSpeed--; } =======
		 */

		ArrayList<ParentTile> tiles = new ArrayList<ParentTile>(Camera.getVisibleTiles());
		double nextX = nextXPosition(lastActionDelta, speed, direction);
		double nextY = nextYPosition(lastActionDelta, speed, direction);
		if (!tiles.isEmpty()) {
			quickSort(tiles);
			for (ParentTile i : (tiles)) {
					Rectangle hitBox = collisionBox(i);
					boolean none = true;
					while (hitBox.intersects(nextX, nextY, WIDTH, HEIGHT)) {
						
						none = true;
						if (hitBox.intersects(nextX, y, WIDTH, HEIGHT)) {
							nextX -= (Math.cos(Math.toRadians(direction)));
							none = false;
						}
						if (hitBox.intersects(x, nextY, WIDTH, HEIGHT)) {
							nextY = nextY - (Math.sin(Math.toRadians(direction)));
							none = false;
						}
						if (none) {
							nextY = y;
							nextX = x;
						}
						
					}
			}
		}
		this.x = nextX;
		this.y = nextY;

	}

	/*
	 * <<<<<<< HEAD private boolean isInY(ParentTile i,double y, int offset){
	 * if(i.getY() < y && (i.getY()+offset) > y || i.getY() < y+offset &&
	 * (i.getY()+offset) > y+offset){ return true; } return false; } private
	 * boolean isInX(ParentTile i,double x, int offset){ if(i.getX() < x &&
	 * (i.getX()+offset) > x || i.getX() < x+offset && (i.getX()+offset) >
	 * x+offset){ return true; } return false; }
	 * 
	 * private double nextXPosition(double lastActionDelta , int xSpeed, double
	 * direction ){ return this.x + (Math.cos(Math.toRadians(direction)) *
	 * xSpeed * lastActionDelta); } private double nextYPosition(double
	 * lastActionDelta , int ySpeed, double direction ){ return this.y +
	 * (Math.sin(Math.toRadians(direction)) * ySpeed * lastActionDelta); }
	 * =======
	 */
	private Rectangle collisionBox(ParentTile i) {
		return new Rectangle(i.getX(), i.getY(), WIDTH + 1, HEIGHT + 1);

	}

	private double nextXPosition(double lastActionDelta, int xSpeed, double direction) {
		return this.x + (Math.cos(Math.toRadians(direction)) * xSpeed * lastActionDelta);
	}

	private double nextYPosition(double lastActionDelta, int ySpeed, double direction) {
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
				out.set(left, out.get(right));
				out.set(right, temp);
				left++;
				right--;
			}
		}
		return left;
	}

	// >>>>>>> branch 'master' of https://github.com/Mia2b/MiasGameEngine.git

}
