package com.germano.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.germano.main.Game;

public class Ball {

	// posições da bola
	public double x;
	public double y;
	// tamanho da bola
	public int width;
	public int height;
	// direções da bola
	public double dx;
	public double dy;
	// velocidade da bola
	public double speed = 1.7;
	// angulo da bola
	public int angle;

	public Ball(int x, int y) { // Construtor da Bola
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		// Gera o angulo da bola entre 40 e 160
		angle = new Random().nextInt(120) + 40;
		// Direciona a bola para o cosseno e seno do angulo
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));

	}

	public void tick() { // Atualiza

		// Muda a direção da bola ao colidir nas laterais
		if (x + (dx * speed) + width >= Game.WIDTH) {
			dx *= -1;
		} else if (x + (dx * speed) < 0) {
			dx *= -1;
		}

		// Contabiliza os pontos
		if (y >= Game.HEIGHT) {
			// ponto do inimigo
			System.out.println("Ponto do Inimigo!");
			// Reseta o jogo
			new Game();
			return;
		} else if (y < 0) {
			// ponto do jogador
			System.out.println("Ponto do Jogador!");
			// Reseta o jogo
			new Game();
			return;
		}

		// Retangulos de colisão das entidades
		Rectangle boundsBall = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), width, height);
		Rectangle boundPlayers = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, (int) Game.enemy.width,
				(int) Game.enemy.height);

		// Muda a direção da bola ao colidir no jogador
		if (boundsBall.intersects(boundPlayers)) {
			// Aleatoriza a direção da bola ao colidir com o player
			angle = new Random().nextInt(120) + 40;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (dy > 0) {
				dy *= -1;
			}

			// Muda a direção da bola ao colidir no inimigo
		} else if (boundsBall.intersects(boundEnemy)) {
			// Aleatoriza a direção da bola ao colidir com o inimigo
			angle = new Random().nextInt(120) + 40;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (dy < 0) {
				dy *= -1;
			}
		}

		// Atualiza as posições da bola
		x += dx * speed;
		y += dy * speed;

	}

	public void render(Graphics g) { // Renderização
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, width, height);
	}
}
