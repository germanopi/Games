package escape_Level;

import java.awt.image.BufferedImage;
import java.util.*;

import javax.imageio.ImageIO;

import entities.*;
import escape.*;
import escape_Level_Block.*;

public abstract class Level {
	public Block[] blocks;
	public int width, height;
	private Block solidWall = new SolidBlock();

	public int xSpawn;
	public int ySpawn;

	protected int wallCol = 0xB3CEE2;
	protected int floorCol = 0x9CA09B;
	protected int ceilCol = 0x9CA09B;

	protected int wallTex = 0;
	protected int floorTex = 0;
	protected int ceilTex = 0;

	public List<Entity> entities = new ArrayList<Entity>();
	protected Game game;
	public String name = "";

	public Player player;

	public void init(Game game, String name, int w, int h, int[] pixels) {
		this.game = game;

		player = game.player;

		solidWall.col = Art.getCol(wallCol);
		solidWall.tex = Art.getCol(wallTex);
		this.width = w;
		this.height = h;
		blocks = new Block[width * height];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int col = pixels[x + y * w] & 0xffffff;
				int id = 255 - ((pixels[x + y * w] >> 24) & 0xff);

				Block block = getBlock(x, y, col);
				block.id = id;

				if (block.tex == -1) block.tex = wallTex;
				if (block.floorTex == -1) block.floorTex = floorTex;
				if (block.ceilTex == -1) block.ceilTex = ceilTex;
				if (block.col == -1) block.col = Art.getCol(wallCol);
				if (block.floorCol == -1) block.floorCol = Art.getCol(floorCol);
				if (block.ceilCol == -1) block.ceilCol = Art.getCol(ceilCol);

				blocks[x + y * w] = block;
				block.level = this;
				block.x = x;
				block.y = y;
			}
		}

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int col = pixels[x + y * w] & 0xffffff;
				decorateBlock(x, y, blocks[x + y * w], col);
			}
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
		e.level = this;
		e.updatePos();
	}

	public void removeEntityImmediately(Player player) {
		entities.remove(player);
		getBlock(player.xTileO, player.zTileO).removeEntity(player);
	}

	protected void decorateBlock(int x, int y, Block block, int col) {
		block.decorate(this, x, y);
		if (col == 0xFFFF00) {
			xSpawn = x;
			ySpawn = y;
		}

		if (col == 0xff0000) addEntity(new BatEntity(x, y));

	}

	protected Block getBlock(int x, int y, int col) {
		if (col == 0xFFFFFF) return new SolidBlock();

		return new Block();
	}

	public Block getBlock(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return solidWall;
		}
		return blocks[x + y * width];
	}

	private static Map<String, Level> loaded = new HashMap<String, Level>();

	public static void clear() {
		loaded.clear();
	}

	public static Level loadLevel(Game game, String name) {
		if (loaded.containsKey(name)) return loaded.get(name);

		try {
			BufferedImage img = ImageIO.read(Level.class.getResource("/level/" + name + ".png"));

			int w = img.getWidth();
			int h = img.getHeight();
			int[] pixels = new int[w * h];
			img.getRGB(0, 0, w, h, pixels, 0, w);

			Level level = Level.byName(name);
			level.init(game, name, w, h, pixels);
			loaded.put(name, level);

			return level;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Level byName(String name) {
		try {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			return (Level) Class.forName("escape_Level." + name + "Level").newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean containsBlockingEntity(double x0, double y0, double x1, double y1) {
		int xc = (int) (Math.floor((x1 + x0) / 2));
		int zc = (int) (Math.floor((y1 + y0) / 2));
		int rr = 2;
		for (int z = zc - rr; z <= zc + rr; z++) {
			for (int x = xc - rr; x <= xc + rr; x++) {
				List<Entity> es = getBlock(x, z).entities;
				for (int i = 0; i < es.size(); i++) {
					Entity e = es.get(i);
					if (e.isInside(x0, y0, x1, y1)) return true;
				}
			}
		}
		return false;
	}

	public boolean containsBlockingNonFlyingEntity(double x0, double y0, double x1, double y1) {
		int xc = (int) (Math.floor((x1 + x0) / 2));
		int zc = (int) (Math.floor((y1 + y0) / 2));
		int rr = 2;
		for (int z = zc - rr; z <= zc + rr; z++) {
			for (int x = xc - rr; x <= xc + rr; x++) {
				List<Entity> es = getBlock(x, z).entities;
				for (int i = 0; i < es.size(); i++) {
					Entity e = es.get(i);
					if (!e.flying && e.isInside(x0, y0, x1, y1)) return true;
				}
			}
		}
		return false;
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
			e.updatePos();
			if (e.isRemoved()) {
				entities.remove(i--);
			}
		}

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				blocks[x + y * width].tick();
			}
		}
	}

	public void trigger(int id, boolean pressed) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Block b = blocks[x + y * width];
				if (b.id == id) {
					b.trigger(pressed);
				}
			}
		}
	}

	public void switchLevel(int id) {
	}

	public void findSpawn(int id) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Block b = blocks[x + y * width];
				if (b.id == id && b instanceof LadderBlock) {
					xSpawn = x;
					ySpawn = y;
				}
			}
		}
	}

	public void getLoot(int id) {
		if (id == 20) game.getLoot(Item.pistol);
		if (id == 21) game.getLoot(Item.potion);
	}

	public void win() {
		game.win(player);
	}

	public void lose() {
		game.lose(player);
	}

	public void showLootScreen(Item item) {
		
	}
}