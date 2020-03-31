package escape_Level_Block;

import entities.*;
import escape_Level.Level;

public class LockedDoorBlock extends DoorBlock {
	public LockedDoorBlock() {
		tex = 5;
	}

	public boolean use(Level level, Item item) {
		return false;
	}

	public void trigger(boolean pressed) {
		open = pressed;
	}

}
