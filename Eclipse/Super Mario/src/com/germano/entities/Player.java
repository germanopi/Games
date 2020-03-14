package com.germano.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;
import com.germano.world.Camera;
import com.germano.world.World;

public class Player extends Entity {

	public boolean right, left;

	public static double life = 100;

	public static int currentCoins = 0;
	public static int maxCoins = 0;

	public int dir = 1;
	private double gravity = 0.4;
	private double vspd = 0;

	public boolean jump = false;

	public boolean isJumping = false;

	private int framesAnimation = 0;
	private int maxFrames = 15;

	private int maxSprite = 2;
	private int currentSprite = 0;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		// Falta colocar dano de pular nos inimigos
		depth = 2;
		vspd += gravity;
		if (!World.isFree((int) x, (int) (y + 1)) && jump) { // Se apertar pular com o player no chão pula
			vspd = -8;
			jump = false;
		}

		if (!World.isFree((int) x, (int) (y + vspd))) {
			int signVsp = 0;
			if (vspd >= 0) {
				signVsp = 1;
			} else {
				signVsp = -1;
			}
			while (World.isFree((int) x, (int) (y + signVsp))) {
				y = y + signVsp;
			}
			vspd = 0;
		}
		y = y + vspd;

		if (right && World.isFree((int) (x + speed), (int) y)) {
			x += speed;
			dir = 1;
		} else if (left && World.isFree((int) (x - speed), (int) y)) {
			x -= speed;
			dir = -1;
		}

		for (int i = 0; i < Game.entities.size(); i++) { // Perder Vida
			Entity e = Game.entities.get(i);
			if (e instanceof Enemy) {
				if (Entity.isColidding(this, e)) {
					if (Entity.rand.nextInt(100) < 10) {
						life--;
					}
				}
			}
		}

		for (int i = 0; i < Game.entities.size(); i++) { // Coletar moeda
			Entity e = Game.entities.get(i);
			if (e instanceof Coin) {
				if (Entity.isColidding(this, e)) {
					if (Entity.rand.nextInt(100) < 10) {
						Player.currentCoins++;
						Game.entities.remove(i);
						break;
					}
				}
			}
		}

		// Mantem a camera dentro da janela do jogo
		Camera.x = Camera.clamp((int) (x - (Game.WIDTH / 2)), 0, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp((int) (y - (Game.HEIGHT / 2)), 0, World.HEIGHT * 16 - Game.HEIGHT);
	}

	public void render(Graphics g) {
		framesAnimation++;
		if (framesAnimation == maxFrames) {
			currentSprite++;
			framesAnimation = 0;
			if (currentSprite == maxSprite) {
				currentSprite = 0;
			}
		}
		if (dir == 1) {
			sprite = Entity.PLAYER_SPRITE_DIR[currentSprite];
		} else if (dir == -1) {
			sprite = Entity.PLAYER_SPRITE_DIR[currentSprite];
		}
		super.render(g);
	}
}
