package com.germano.main;

import com.germano.entities.Enemy;
import com.germano.entities.Entity;

public class Spawner {

	public int targetTime = 60, currentTime = 0;

	public void tick() {
		currentTime++;
		if (currentTime == targetTime) {
			targetTime = Entity.rand.nextInt(120 - 60) + 30;
			currentTime = 0;
			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);
			Enemy enemy = new Enemy(xx, yy, 16, 16, Entity.rand.nextInt(2 - 1) + 1,
					Game.spritesheet.getSprite(16, 0, 16, 16));
			Game.entities.add(enemy);
		}
	}
}
