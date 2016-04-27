package com.mia2b.beta;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.mia2b.display.DisplayWindow;
import com.mia2b.display.SpriteAssets;
import com.mia2b.tiles.YellowTile;
import com.mia2b.world.WorldObjects;

public class Testing {
	static int [][] mapArray = new Maze(21).getIntMaze();

			  					 	
	public static BufferedImage im;
	
	public static void makeMap() {
		im = new BufferedImage(mapArray[0].length*SpriteAssets.getSpritewidth(),mapArray.length* SpriteAssets.getSpriteheight() , BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < mapArray.length;i++){
			for (int j = 0; j < mapArray[0].length;j++){
				mapArray[i][j] = (int) ((Math.random()*6)-2);
			}
		}
	}
	public static void addMap(){
		int midY = 32;//((mapArray.length/2)*32);
		int midX = 0;//((mapArray[0].length/2)*32);
		for (int i = 0; i < mapArray.length; i++) {
			for (int j = 0; j < mapArray[0].length; j++) {
				if(mapArray[i][j] == 1){
					WorldObjects.addTile(new YellowTile(),i*32-midX, j*32-midY);
				}
				if(mapArray[i][j] == 2){
					
				}
			}
		}
	}
}
