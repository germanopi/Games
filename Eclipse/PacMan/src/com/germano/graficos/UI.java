package com.germano.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.germano.main.Game;

public class UI {

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.drawString("Apples: " + Game.appleCurrent + "/" + Game.appleCount, 30, 30);
	}

}
