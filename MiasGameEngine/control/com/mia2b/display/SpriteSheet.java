package com.mia2b.display;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
		removePinkAndBlue();
	}

	public BufferedImage crop(int y, int x, int width, int height) {
		x--;
		y--;
		return sheet.getSubimage(x * width, y * height, width, height);
	}

	private void removePinkAndBlue() {
		for (int y = 0; y < sheet.getHeight(); ++y) {
			for (int x = 0; x < sheet.getWidth(); ++x) {
				int argb = sheet.getRGB(x, y);
				if (argb == 0xFFFF00FF || argb == 0xFF00FFFF) {
					sheet.setRGB(x, y, 0x00000000);
				}
			}
		}
	}
}
