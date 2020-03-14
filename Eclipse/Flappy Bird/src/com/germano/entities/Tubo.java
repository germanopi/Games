package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;

public class Tubo extends Entity {

	public Tubo(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		x--;
		if (x + width <= 0) { // Remove tubos que sairam da tela
			Game.score += 0.5;
			Game.entities.remove(this);
			return;
		}
	}

	public void render(Graphics g) { // Renderiza os tubos
		if (sprite != null) {
			g.drawImage(sprite, this.getX(), this.getY(), width, height, null);
		} else {
			g.setColor(Color.green);
			g.fillRect(this.getX(), this.getY(), width, height);
		}
	}
}
