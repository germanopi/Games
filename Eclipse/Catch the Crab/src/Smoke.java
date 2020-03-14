import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Smoke {

	public int x, y;
	public static BufferedImage[] smokeSprite;
	public int currentFrames = 0, maxFrames = 30, maxAnimation = 2, currentAnimation = 0;

	public Smoke(int x, int y) {
		this.x = x;
		this.y = y;
		smokeSprite = new BufferedImage[2];
		smokeSprite[0] = Game.spritesheet.getSprite(32, 0);
		smokeSprite[1] = Game.spritesheet.getSprite(48, 0);
	}

	public void tick() {
		currentFrames++;
		if (currentFrames == maxFrames) {
			currentFrames = 0;
			currentAnimation++;
			if (currentAnimation == maxAnimation) {
				currentAnimation = 0;
				Game.smokes.remove(this);
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(smokeSprite[currentAnimation], (int) x, (int) y, 40, 40, null);
	}
}
