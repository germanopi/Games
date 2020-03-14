package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.germano.main.Game;

public class Player {
	// Posição do jogador
	public int x;
	public int y;
	// Direções do jogador
	public boolean right;
	public boolean left;
	// Tamanho do jogador
	public int width;
	public int height;

	// Construtor do jogador
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}

	public void tick() { // Atualiza o jogo
		// Mover na horizontal dentro da tela
		if (right) {
			x++;
		} else if (left) {
			x--;
		}
		if (x + width > Game.WIDTH) {
			x = Game.WIDTH - width;

		} else if (x < 0) {
			x = 0;

		}
	}

	public void render(Graphics g) { // Renderização
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

	}
}
