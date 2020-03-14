package com.germano.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.germano.entities.Player;
import com.germano.main.Game;

public class UI {

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(10, 20, 200, 30);
		g.setColor(Color.green);
		g.fillRect(10, 20, (int) ((Player.life / 100) * 200), 30);
		g.setColor(Color.black);
		g.drawRect(10, 20, 200, 30);
		g.setFont(new Font("arial", Font.BOLD, 22));
		g.drawString("Coins :" + Player.currentCoins + "/" + Player.maxCoins, (Game.WIDTH * Game.SCALE) - 130, 35);
	}

}
