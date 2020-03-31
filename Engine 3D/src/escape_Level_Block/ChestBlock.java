package escape_Level_Block;

import entities.Item;
import escape.*;
import escape_Level.Level;
import gui.Sprite;

public class ChestBlock extends Block {
	private boolean open = false;
	private Sprite chestSprite;

	public ChestBlock() {
		tex = 1;
		blocksMotion = true;

		chestSprite = new Sprite(0, 0, 0, 8 * 2 + 0, Art.getCol(0xffff00));
		addSprite(chestSprite);
	}

	public boolean use(Level level, Item item) {
		if (open) return false;

		chestSprite.tex++;
		open = true;

		level.getLoot(id);
		Sound.treasure.play();

		return true;
	}
}
