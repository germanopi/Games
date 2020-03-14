package com.germano.main;

import com.germano.entities.Enemy;
import com.germano.entities.Entity;
import com.germano.world.World;

public class Spawner {

	public int maxTime = 60 * 10;
	public int currentTime = 0;

	public void tick() {
		currentTime++;
		if (currentTime == maxTime) {
			currentTime = 0;
			int xInitial = Entity.rand.nextInt(World.WIDTH * 16 - 16 - 16) + 16;
			Enemy enemy = new Enemy(xInitial, 16, 16, 16, 1, Entity.ENEMY_SPRITE_RIGHT[0], Entity.ENEMY_SPRITE_LEFT[0]);
			Game.entities.add(enemy);
		}
	}

}
