package com.mia2b.beta;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.mia2b.display.SpriteAssets;

public class Testing {
	static int [][] mapArray = new int [200][200];
//											{	{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3,  1, 0, 2, 1, 1, -1,  0, 0},
//			  					 				{ 0, 1, 0, 0,0,0, 0, 0, 1, 0, 3, 1, 0, 2, 1, -1, -1, 0,  0 },
//			  					 				{ 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 , 3, 1, 0, 2, 1, -1, -1, 0,0},
//			  					 				{ 0, 3, 1, 0, 2, 1, -1, -1, 0, 0, 3, 1, 0, 2, 1, -1, -1,0,0},
//			  					 				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,-1, -1,-1, -1, -1, 3, 1, 0, 2, 1,-1,-1,0,0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0 , 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0 , 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0 , 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0 , 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0 , 3, 1, 0, 2, 1, -1, -1, 0, 0},
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 },
//			  					 				{ 0, 0, 0, 0,-1,0, 0, 0, 0, 0, 3, 1, 0, 2, 1, -1, -1, 0, 0 }};
	
			  					 	
	public static BufferedImage im = new BufferedImage(mapArray[0].length*SpriteAssets.getSpritewidth(),mapArray.length* SpriteAssets.getSpriteheight() , BufferedImage.TYPE_INT_ARGB);
	
	public static void makeMap() {
		
		for (int i = 0; i < mapArray.length;i++){
			for (int j = 0; j < mapArray[0].length;j++){
				mapArray[i][j] = (int) ((Math.random()*6)-2);
			}
		}

		Graphics g = im.getGraphics();

		for (int i = 0; i < mapArray.length; i++) {
			for (int j = 0; j < mapArray[1].length; j++) {
				// if statement for if its on the screen
				if(mapArray[i][j] != -1){
					g.drawImage(SpriteAssets.getTile().get(mapArray[i][j]), j * 32, i * 32, null);
				}
			}
		}
		
	}

	public static void paintCompoent(Graphics g) {
		g.drawImage(im, 0, 0, null);
	}
}
