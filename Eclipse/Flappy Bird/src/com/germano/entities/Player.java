package com.germano.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.germano.main.Game;
import com.germano.world.World;

public class Player extends Entity {

	public static boolean isPressed = false;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		depth = 2;
		if (!isPressed) { // Movimento do player
			y += 2;
		} else {
			y -= 2;
		}
		if (y > Game.HEIGHT || y < 0) { // Saiu da tela
			World.restartGame();
		}

		for (int i = 0; i < Game.entities.size(); i++) { // Testa Colisão
			Entity e = Game.entities.get(i);
			if (e != this) {
				if (Entity.isColidding(this, e)) {
					World.restartGame();
					return;
				}
			}
		}
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (Player.isPressed) { // Subindo
			g2.rotate(Math.toRadians(-20), this.getX() + width / 2, this.getY() + height / 2);
			g2.drawImage(sprite, this.getX(), this.getY(), null);
			g2.rotate(Math.toRadians(20), this.getX() + width / 2, this.getY() + height / 2);
		} else { // Descendo
			g2.rotate(Math.toRadians(20), this.getX() + width / 2, this.getY() + height / 2);
			g2.drawImage(sprite, this.getX(), this.getY(), null);
			g2.rotate(Math.toRadians(-20), this.getX() + width / 2, this.getY() + height / 2);
		}
	}

}
