package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;

public class Enemy extends Entity {

	public int life = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		y += speed;
		if (y >= Game.HEIGHT) { // Remove inimigo se sair da tela
			Game.entities.remove(this);
			Game.life -= Entity.rand.nextInt(10) + 1;
			return;
		}
		for (int i = 0; i < Game.entities.size(); i++) { // Remove inimigo se morrer
			Entity e = Game.entities.get(i);
			if (e instanceof Shoot) {
				if (Entity.isColidding(this, e)) {
					Game.entities.remove(e);
					life--;
					if (life == 0) {
						Explosion explosion = new Explosion(x, y, 16, 16, 0, null);
						Game.entities.add(explosion);
						Game.score++;
						Game.entities.remove(this);
						return;
					}
					break;
				}
			}
		}
	}

}
