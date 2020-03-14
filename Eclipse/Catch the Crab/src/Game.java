import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, MouseListener {

	public static int WIDTH = 480, HEIGHT = 480;
	public static List<Crab> crabs;
	public Spawner spawner;
	public static Spritesheet spritesheet;
	public static Rectangle maskHole;
	public static int mouse_x, mouse_y;
	public static boolean isPressed = false;
	public static int score = 0;
	public static List<Smoke> smokes;

	public Game() {
		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		crabs = new ArrayList<>();
		spawner = new Spawner();
		spritesheet = new Spritesheet("/spritesheet.png");
		maskHole = new Rectangle(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40);
		smokes = new ArrayList<>();
	}

	public void tick() {
		spawner.tick();
		for (int i = 0; i < crabs.size(); i++) {
			crabs.get(i).tick();
		}
		for (int i = 0; i < smokes.size(); i++) {
			smokes.get(i).tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(255, 229, 102));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.fillOval(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40);
		for (int i = 0; i < crabs.size(); i++) {
			crabs.get(i).render(g);

		}
		for (int i = 0; i < smokes.size(); i++) {
			smokes.get(i).render(g);
		}
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.drawString("Score:" + score, 10, 20);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle("Catch the Crab");
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Thread(game).start();
	}

	@Override
	public void run() {
		double fps = 60.0;
		while (true) {
			tick();
			render();
			try {
				Thread.sleep((int) (1000 / fps));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		isPressed = true;
		mouse_x = e.getX();
		mouse_y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
