package com.germano.world;

import com.germano.entities.Entity;
import com.germano.entities.Tubo;
import com.germano.main.Game;

public class TuboGenerator {

	public int time = 0;
	public int targetTime = 60;

	public void tick() {
		time++;
		if (time == targetTime) {// Cria um tubo novo e reseta o contador
			time = 0;
			int altura1 = Entity.rand.nextInt(65 - 40) + 40;
			Tubo tubo1 = new Tubo(Game.WIDTH, 0, 20, altura1, 1, Game.spritesheet.getSprite(16, 0, 16, 16));
			Game.entities.add(tubo1);

			int altura2 = Entity.rand.nextInt(65 - 40) + 40;
			Tubo tubo2 = new Tubo(Game.WIDTH, Game.HEIGHT - altura2, 20, altura2, 1,
					Game.spritesheet.getSprite(32, 0, 16, 16));
			Game.entities.add(tubo2);

		}
	}

}
