import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crab {

	public double x, y, dir_x, dir_y, speed = 4;
	public static BufferedImage[] crabSprite;
	public int currentFrames = 0, maxFrames = 30, maxAnimation = 2, currentAnimation = 0;

	public Crab(int x, int y) {
		this.x = x;
		this.y = y;
		double radius = Math.atan2((Game.HEIGHT / 2 - 20) - y, (Game.WIDTH / 2 - 20) - x);
		this.dir_x = Math.cos(radius);
		this.dir_y = Math.sin(radius);
		crabSprite = new BufferedImage[2];
		crabSprite[0] = Game.spritesheet.getSprite(0, 0);
		crabSprite[1] = Game.spritesheet.getSprite(16, 0);
	}

	public void tick() {
		x += (dir_x * speed);
		y += (dir_y * speed);
		if (new Rectangle((int) x, (int) y, 40, 40).intersects(Game.maskHole)) {
			Game.crabs.remove(this);
			return;
		}
		currentFrames++;
		if (currentFrames == maxFrames) {
			currentFrames = 0;
			currentAnimation++;
			if (currentAnimation == maxAnimation) {
				currentAnimation = 0;
			}
		}

		checkCollision();
	}

	public void checkCollision() {
		if (Game.isPressed) {
			Game.isPressed = false;
			if (Game.mouse_x >= x && Game.mouse_x <= x + 40) {
				if (Game.mouse_y >= y && Game.mouse_y <= y + 40) {
					Game.score++;
					Game.crabs.remove(this);
					Game.smokes.add(new Smoke((int) x, (int) y));
					return;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(crabSprite[currentAnimation], (int) x, (int) y, 40, 40, null);

	}
}
