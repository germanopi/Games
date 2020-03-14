package com.germano.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.world.World;

public class Enemy extends Entity {

	public int dir = 1;
	public int vida = 2;
	public boolean right = true, left = false;
	private int framesAnimation = 0, maxFrames = 15, maxSprite = 4, currentSprite = 0;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() { 
		if (World.isFree((int) x, (int) (y + 1))) { // Gravidade
			y += 1;
		}
		if (right) {
			if (World.isFree((int) (x + speed), (int) y)) {
				x += speed;
				dir = 1;
				if (World.isFree((int) (x + 16), (int) y + 1)) {
					right = false;
					left = true;
				}
			} else {
				right = false;
				left = true;
			}
		}
		
		if (left) {
			if (World.isFree((int) (x - speed), (int) y)) {
				x -= speed;
				dir = -1;
				if (World.isFree((int) (x - 16), (int) y + 1)) {
					right = true;
					left = false;
				}
			} else {
				right = true;
				left = false;
			}
		}
	}

	public void render(Graphics g) {
		framesAnimation++;
		if (framesAnimation == maxFrames) {
			framesAnimation = 0;
			currentSprite++;
			if (currentSprite == maxSprite) {
				currentSprite = 0;
			}
		}
		if (dir == 1) {
			sprite = Entity.ENEMY_SPRITE_RIGHT[currentSprite];
		} else if (dir == -1) {
			sprite = Entity.ENEMY_SPRITE_LEFT[currentSprite];
		}
		super.render(g);
	}
}
