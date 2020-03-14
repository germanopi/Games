package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.germano.main.Game;
import com.germano.world.Camera;
import com.germano.world.FloorTile;
import com.germano.world.Tile;
import com.germano.world.WallTile;
import com.germano.world.World;

public class Enemy extends Entity {

	public boolean right = true, left = false;
	public double vida = Entity.rand.nextInt(100 - 50) + 50, maxVida = vida;
	private int framesAnimation = 0, maxFrames = 15, maxSprite = 4, currentSprite = 0;

	public BufferedImage sprite1, sprite2;
	public int dir = 1;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite1,
			BufferedImage sprite2) {
		super(x, y, width, height, speed, null);
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
	}

	public void tick() {
		if (World.isFree((int) x, (int) (y + 1))) { // Gravidade
			y += 1;
		}

		if (dir == 1) { // Movimentação para direita
			if (World.isFree((int) (x + speed), (int) y)) {
				x += speed;
			} else { // Quebra bloco da direita
				int xNext = (int) ((x + speed) / 16) + 1;
				int yNext = (int) (y / 16);
				if (World.tiles[xNext + yNext * World.WIDTH] instanceof WallTile
						&& World.tiles[xNext + yNext * World.WIDTH].solid == false) {
					World.tiles[xNext + yNext * World.WIDTH] = new FloorTile(xNext * 16, yNext * 16, Tile.TILE_AR);
				}
				dir = -1;
				left = true;
				right = false;
			}
		} else if (dir == -1) { // Movimentação para esquerda
			if (World.isFree((int) (x - speed), (int) y)) {
				x -= speed;
			} else { // Quebra bloco da esquerda
				int xNext = (int) ((x - speed) / 16);
				int yNext = (int) (y / 16);
				if (World.tiles[xNext + yNext * World.WIDTH] instanceof WallTile
						&& World.tiles[xNext + yNext * World.WIDTH].solid == false) {
					World.tiles[xNext + yNext * World.WIDTH] = new FloorTile(xNext * 16, yNext * 16, Tile.TILE_AR);
				}
				dir = 1;
				right = true;
				left = false;
			}
		}
		if (vida == 0) { // Morte do inimigo
			Game.entities.remove(this);
			return;
		}
	}

	public void render(Graphics g) {
		if (right) {
			sprite = sprite1;
		} else if (left) {
			sprite = sprite2;
		}
		super.render(g);

		// Barra de vida
		int currentLife = (int) ((vida / maxVida) * 30);
		g.setColor(Color.red);
		g.fillRect(this.getX() - Camera.x - 3, this.getY() - 8 - Camera.y, 30, 7);
		g.setColor(Color.green);
		g.fillRect(this.getX() - Camera.x - 3, this.getY() - 8 - Camera.y, currentLife, 7);

	}

}
