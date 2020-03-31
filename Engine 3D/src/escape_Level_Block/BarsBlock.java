package escape_Level_Block;

import entities.*;
import escape.Sound;
import escape_Level.Level;
import escape_Level_Block.Block;
import gui.Sprite;

public class BarsBlock extends Block {
	private Sprite sprite;
	private boolean open = false;

	public BarsBlock() {
		sprite = new Sprite(0, 0, 0, 0, 0x202020);
		addSprite(sprite);
		blocksMotion = true;
	}

	public boolean use(Level level, Item item) {
		if (open) return false;

		if (item == Item.cutters) {
			Sound.cut.play();
			sprite.tex = 1;
			open = true;
		}

		return true;
	}

	public boolean blocks(Entity entity) {
		if (open && entity instanceof Player) return false;
		if (open && entity instanceof Bullet) return false;
		return blocksMotion;
	}
}
