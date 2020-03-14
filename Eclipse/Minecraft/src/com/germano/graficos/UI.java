package com.germano.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.germano.entities.Player;
import com.germano.main.Game;
import com.germano.world.World;

public class UI {
	public static int seconds = 0, minutes = 0, frames = 0;

	public void tick() {
		frames++;
		if (frames == 60) { // Contador de tempo
			frames = 0;
			seconds++;
			if (seconds == 60) {
				seconds = 0;
				minutes++;
				if (minutes % 1 == 0) { // Troca Dia e Noite
					World.CICLO++;
					if (World.CICLO > World.noite) {
						World.CICLO = 0;
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		// Barra de vida
		int currentLife = ((int) ((Game.player.life / Game.player.maxLife) * 200));
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 220, 10, 200, 30);
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH * Game.SCALE - 220, 10, currentLife, 30);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 24));
		g.drawString((int) (Game.player.life) + "/" + (int) (Game.player.maxLife), Game.WIDTH * Game.SCALE - 160, 35);

		// Tempo de jogo
		String formatTime = "";
		if (minutes < 10) {
			formatTime += "0" + minutes + ":";
		} else {
			formatTime += minutes + ":";
		}
		if (seconds < 10) {
			formatTime += "0" + seconds;
		} else {
			formatTime += seconds;
		}
		g.setFont(new Font("arial", Font.BOLD, 24));
		g.drawString(formatTime, 14, 30);

	}

}
