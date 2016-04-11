package com.mia2b.display;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class SpriteAssets {
	private static SpriteSheet sheet;
	private static final int spriteWidth = 32, spriteHeight = 32;
	private static ArrayList<BufferedImage> 	character	= new ArrayList<BufferedImage>(),
												enemy		= new ArrayList<BufferedImage>(),
												tile 		= new ArrayList<BufferedImage>(); 
	private BufferedImage blank;
	public static void loadAssets(){
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		loadCharacters();
		loadEnemies();
		loadTiles();
	}
	private static void loadCharacters(){
		getCharacter().add(sheet.crop(1, 1, getSpritewidth(), getSpriteheight()));
	}
	private static void loadEnemies(){
		getEnemy().add(sheet.crop(2, 1, getSpritewidth(), getSpriteheight()));
	}
	private static void loadTiles(){
		getTile().add(sheet.crop(3, 1, getSpritewidth(), getSpriteheight())); //0
		getTile().add(sheet.crop(3, 2, getSpritewidth(), getSpriteheight())); //0
		getTile().add(sheet.crop(3, 3, getSpritewidth(), getSpriteheight())); //0
		getTile().add(sheet.crop(3, 4, getSpritewidth(), getSpriteheight())); //0
				
	}
	public static ArrayList<BufferedImage> getTile() {
		return tile;
	}
	public static void setTile(ArrayList<BufferedImage> tile) {
		SpriteAssets.tile = tile;
	}
	public static ArrayList<BufferedImage> getEnemy() {
		return enemy;
	}
	public static void setEnemy(ArrayList<BufferedImage> enemy) {
		SpriteAssets.enemy = enemy;
	}
	public static ArrayList<BufferedImage> getCharacter() {
		return character;
	}
	public static void setCharacter(ArrayList<BufferedImage> character) {
		SpriteAssets.character = character;
	}
	public BufferedImage getBlank() {
		return blank;
	}
	public void setBlank(BufferedImage blank) {
		this.blank = blank;
	}
	public static int getSpritewidth() {
		return spriteWidth;
	}
	public static int getSpriteheight() {
		return spriteHeight;
	}
}
