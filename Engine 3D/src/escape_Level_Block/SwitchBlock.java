package escape_Level_Block;

import entities.Item;
import escape.Sound;
import escape_Level.Level;

public class SwitchBlock extends SolidBlock {
	private boolean pressed = false;

	public SwitchBlock() {
		tex = 2;
	}

	public boolean use(Level level, Item item) {
		pressed = !pressed;
		if (pressed) tex = 3;
		else tex = 2;
		
		level.trigger(id, pressed);
		if (pressed)
			Sound.click1.play();
		else
			Sound.click2.play();

		return true;
	}
}
