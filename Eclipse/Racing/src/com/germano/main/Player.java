package com.germano.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	public int width = 98, height = 47, lastPoint;
	public double x, y, dir_x, dir_y, speed = 0, aceleration = 0.2, rotation = 0;
	public BufferedImage sprite;
	public boolean right = false, left = false, up = false;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		try {
			sprite = ImageIO.read(getClass().getResource("/carPlayer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		if (right) {
			rotation += 4;
		} else if (left) {
			rotation -= 4;
		}
		// Retira velocidade ao andar na grama
		for (int i = 0; i < Main.blocos.size(); i++) {
			Rectangle boxCar = new Rectangle((int) x, (int) y, 98 / 2, 47 / 2);
			Rectangle bloco = new Rectangle(Main.blocos.get(i).x, Main.blocos.get(i).y, 48, 48);
			if (boxCar.intersects(bloco)) {
				if (Main.blocos.get(i).type > 1) {
					if (speed >= 3) {
						speed = 3;
					}
				}
			}
		}
		if (up) {
			speed += aceleration;
			if (speed >= 6) {
				speed = 6;
			}
		} else {
			speed -= aceleration;
			if (speed <= 0) {
				speed = 0;
			}
		}
		dir_x = Math.cos(Math.toRadians(rotation));
		dir_y = Math.sin(Math.toRadians(rotation));
		x += dir_x * speed;
		y += dir_y * speed;
		// Impede sair do mapa
		if (x >= 600) {
			x = 599;
		}
		if (x <= 0) {
			x = 1;
		}
		if (y >= 441) {
			y = 440;
		}
		if (y <= 1) {
			y = 1;
		}
		// Verifica completou uma volta corretamente
		Rectangle boxCar = new Rectangle((int) x, (int) y, 98 / 2, 47 / 2);
		if (boxCar.intersects(Main.point1)) {
			lastPoint = 1;
		} else if (boxCar.intersects(Main.point2)) {
			if (lastPoint == 1) {
				Main.voltas++;
			}
			lastPoint = 2;
		}
	}

	public void render(Graphics2D g2) {
		g2.rotate(Math.toRadians(rotation), x + width / 4, y + height / 4);
		g2.drawImage(sprite, (int) x, (int) y, width / 2, height / 2, null);
		g2.rotate(Math.toRadians(-rotation), x + width / 4, y + height / 4);
	}
}
