package com.germano.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.germano.entities.Entity;
import com.germano.entities.Player;
import com.germano.main.Game;

public class World {

	public static int WIDTH, HEIGHT;

	public World(String path) {

	}

	public static void restartGame() {
		Game.score = 0;
		Game.player = new Player(Game.WIDTH / 2 - 30, Game.HEIGHT / 2, 16, 16, 2,
				Game.spritesheet.getSprite(0, 0, 16, 16));
		Game.entities.clear();
		Game.entities.add(Game.player);
		return;
	}

	public void render(Graphics g) {

	}

}
