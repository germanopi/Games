package com.germano.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {

	public World(String path) {
		try {
			BufferedImage bitmap = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
			bitmap.getRGB(0, 0, bitmap.getWidth(), bitmap.getHeight(), pixels, 0, bitmap.getWidth());
			for (int xx = 0; xx < bitmap.getWidth(); xx++) { // Verifica cada pixel do mapa
				for (int yy = 0; yy < bitmap.getHeight(); yy++) {
					if (pixels[xx + yy * bitmap.getWidth()] == 0xff000000) {
						// Grass]
						Main.blocos.add(new Block(xx * 48, yy * 48, 2));
					} else if (pixels[xx + yy * bitmap.getWidth()] == 0xffffffff) {
						// Road
						if (pixels[xx + (yy + 1) * bitmap.getWidth()] == 0xff000000
								|| pixels[xx + (yy - 1) * bitmap.getWidth()] == 0xff000000) {
							Main.blocos.add(new Block(xx * 48, yy * 48, 1)); // Horizontal Road
						} else {
							Main.blocos.add(new Block(xx * 48, yy * 48, 0)); // Vertical Road
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
