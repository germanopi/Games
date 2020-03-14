package com.germano.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;

public class Explosion extends Entity {

	private int frames = 0, targetFrames = 10, maxAnimation = 2, currentAnimation = 0;

	public BufferedImage[] explosionSprites = new BufferedImage[3];

	public Explosion(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

		explosionSprites[0] = Game.spritesheet.getSprite(0, 16, 16, 16);
		explosionSprites[1] = Game.spritesheet.getSprite(16, 16, 16, 16);
		explosionSprites[2] = Game.spritesheet.getSprite(32, 16, 16, 16);
	}

	public void tick() {
		frames++;
		if (frames == targetFrames) {
			frames = 0;
			currentAnimation++;
			if (currentAnimation == maxAnimation) {
				Game.entities.remove(this);
				return;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(explosionSprites[currentAnimation], this.getX(), this.getY(), null);
	}
}
