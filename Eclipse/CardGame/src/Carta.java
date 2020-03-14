import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Carta {

	public BufferedImage sprite;
	public static BufferedImage cartaVirada = Spritesheet.getSprite(852, 384, 70, 97);
	public int x, y, type = 0, score = 0;
	public boolean flip = false;

	public Carta(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (flip == false) {
			g.drawImage(cartaVirada, x, y,72,95, null);
		} else {
			g.drawImage(sprite, x, y,72,95, null);
		}
	}
}
