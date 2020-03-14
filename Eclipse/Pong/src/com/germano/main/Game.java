package com.germano.main;

import com.germano.entities.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.germano.entities.Ball;
import com.germano.entities.Enemy;
import com.germano.entities.Player;

public class Game extends Canvas implements Runnable, KeyListener {
	// Tamanho da tela
	public static int WIDTH = 160;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	// Imagem da tela
	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	// Entidades da tela
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;

	public Game() {
		// Seleciona o tamanho da janela
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		// Recebe entradas do teclado
		this.addKeyListener(this);
		// Posições iniciais das entidades
		player = new Player(100, HEIGHT - 5);
		enemy = new Enemy(100, 0);
		ball = new Ball(100, HEIGHT / 2 - 1);
	}

	public static void main(String[] args) {
		// Criação da tela
		Game game = new Game();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		new Thread(game).start();
	}

	public void tick() { // Atualiza o jogo
		player.tick();
		enemy.tick();
		ball.tick();
	}

	public void render() { // Renderização
		// Sequencia de buffers para otimizar a renderização
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		// Desenha o background e entidades na imagem
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		// Desenha a imagem na tela
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		// Exibe toda renderização
		bs.show();
	}

	@Override
	public void run() { // Thread do Game Looping Não Profissional com 60 fps
		while (true) {
			tick();
			render();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) { // Ação de presionar tecla
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) { // Ação de soltar tecla
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
