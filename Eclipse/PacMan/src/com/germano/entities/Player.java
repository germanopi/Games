package com.germano.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;
import com.germano.world.Camera;
import com.germano.world.World;

public class Player extends Entity {

	public boolean right, up, left, down;
	public int lastDir = 1;
	public BufferedImage sprite_left;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		sprite_left = Game.spritesheet.getSprite(48, 0, 16, 16);
	}

	public void tick() {
		depth = 1;
		if (right && World.isFree((int) (x + speed), this.getY())) {
			x += speed;
			lastDir = 1;
		} else if (left && World.isFree((int) (x - speed), this.getY())) {
			x -= speed;
			lastDir = -1;
		}
		if (up && World.isFree(this.getX(), (int) (y - speed))) {
			y -= speed;
		} else if (down && World.isFree(this.getX(), (int) (y + speed))) {
			y += speed;
		}

		checkAndTakeApple();

		if (Game.appleCount == Game.appleCurrent) {
			System.out.println("Ganhamos o jogo");
			World.restartGame();
		}

	}

	public void checkAndTakeApple() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity current = Game.entities.get(i);
			if (current instanceof Apple) {
				if (Entity.isColidding(this, current)) {
					Game.entities.remove(i);
					Game.appleCurrent++;
					return;
				}
			}
		}

	}

	public void render(Graphics g) {
		if (lastDir == 1) {
			super.render(g);
		} else if (lastDir == -1) {
			g.drawImage(sprite_left, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
	}
}
