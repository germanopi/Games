package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.germano.main.Game;

public class Enemy {
    // Posição do inimigo, double deixa mais suave.
	public double x;
	public double y;
	// Tamanho do inimigo
	public int width;
	public int height;
	
	//Construtor do Inimigo
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}

	public void tick() { // Lógica do Inimigo,Seguir a bola com atraso
		x += (Game.ball.x - x - 6) * 0.07;

	}

	public void render(Graphics g) { // Renderização do Inimigo
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, width, height);
	}
}
