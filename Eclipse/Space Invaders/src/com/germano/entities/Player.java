package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;

public class Player extends Entity {

	public boolean right, left, isShooting = false;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {

		if (right) { // Sistema de movimento
			x += speed;
		} else if (left) {
			x -= speed;
		}
		if (x >= Game.WIDTH) {
			x = -16;
		} else if (x + 16 < 0) {
			x = Game.WIDTH;
		}
		if (isShooting) { // Sistema de tiro
			isShooting = false;
			int xx = this.getX() + 6;
			int yy = this.getY() + 6;
			Shoot shoot = new Shoot(xx, yy, 3, 3, 2, null);
			Game.entities.add(shoot);

		}
	}

}
