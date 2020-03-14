package com.germano.main;

import java.awt.Color;
import java.awt.Graphics;

import com.germano.world.Camera;
import com.germano.world.FloorTile;
import com.germano.world.Tile;
import com.germano.world.WallTile;
import com.germano.world.World;

public class Inventory {

	public int selected = 0;
	public boolean isPressed = false;
	public boolean isPlaceItem = false;
	public int mouse_x, mouse_y;
	public int inventoryBoxSize = 45;
	public String[] items = { "grama", "terra", "neve", "areia", "ar", "" };
	public int initialPosition = (Game.WIDTH * Game.SCALE / 2) - ((items.length * inventoryBoxSize) / 2);

	public void tick() {
		if (isPressed) {
			isPressed = false;
			// Seleção de items
			if (mouse_x >= initialPosition && mouse_x < initialPosition + (inventoryBoxSize * items.length)) {
				if (mouse_y >= Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1
						&& mouse_y < Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1 + inventoryBoxSize) {
					selected = (int) ((mouse_x - initialPosition) / inventoryBoxSize);
				}
			}
		}
		if (isPlaceItem) {
			isPlaceItem = false;
			mouse_x = (int) (mouse_x / Game.SCALE + Camera.x);
			mouse_y = (int) (mouse_y / Game.SCALE + Camera.y);
			int tileX = mouse_x / 16;
			int tileY = mouse_y / 16;
			if (World.tiles[tileX + tileY * World.WIDTH].solid == false) { // Lugar vago no mapa
				if (items[selected].equals("grama")) { // Adiciona grama no mapa
					World.tiles[tileX + tileY * World.WIDTH] = new WallTile(tileX * 16, tileY * 16, Tile.TILE_GRAMA);
				} else if (items[selected].equals("terra")) { // Adiciona terra no mapa
					World.tiles[tileX + tileY * World.WIDTH] = new WallTile(tileX * 16, tileY * 16, Tile.TILE_TERRA);
				} else if (items[selected].equals("ar")) { // Adiciona terra no mapa
					World.tiles[tileX + tileY * World.WIDTH] = new FloorTile(tileX * 16, tileY * 16, Tile.TILE_AR);
				} else if (items[selected].equals("areia")) { // Adiciona areia no mapa
					World.tiles[tileX + tileY * World.WIDTH] = new WallTile(tileX * 16, tileY * 16, Tile.TILE_AREIA);
				} else if (items[selected].equals("neve")) { // Adiciona neve no mapa
					World.tiles[tileX + tileY * World.WIDTH] = new WallTile(tileX * 16, tileY * 16, Tile.TILE_NEVE);
				}
				// Não permite adicionar item no lugar do personagem
				if (World.isFree(Game.player.getX(), Game.player.getY()) == false) {
					World.tiles[tileX + tileY * World.WIDTH] = new FloorTile(tileX * 16, tileY * 16, Tile.TILE_AR);
				}
			}
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < items.length; i++) {// Cria o inventario e a imagem dentro do inventario
			g.setColor(Color.gray);
			g.fillRect(initialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1,
					inventoryBoxSize, inventoryBoxSize);
			g.setColor(Color.black);
			g.drawRect(initialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1,
					inventoryBoxSize, inventoryBoxSize);
			if (items[i].equals("grama")) {
				g.drawImage(Tile.TILE_GRAMA, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			} else if (items[i].equals("terra")) {
				g.drawImage(Tile.TILE_TERRA, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			} else if (items[i].equals("ar")) {
				g.drawImage(Tile.TILE_AR, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			} else if (items[i].equals("areia")) {
				g.drawImage(Tile.TILE_AREIA, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			} else if (items[i].equals("neve")) {
				g.drawImage(Tile.TILE_NEVE, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}
			if (selected == i) {
				g.setColor(Color.red);
				g.drawRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1,
						inventoryBoxSize, inventoryBoxSize);
			}

		}
	}

}
