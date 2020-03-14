package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;

public class Shoot extends Entity {

	public Shoot(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		y -= speed;
		if (y < 0) { // Remove tiro se sair da tela
			Game.entities.remove(this);
			return;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(this.getX(), this.getY(), width, height);
	}
}
