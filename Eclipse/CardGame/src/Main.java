import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener, MouseListener {

	public Deck deck;
	public static int score = 0;
	public static boolean pressed = false;
	public static int mouse_x = 0, mouse_y = 0;

	public Main() {
		this.setPreferredSize(new Dimension(480, 480));
		this.addKeyListener(this);
		this.addMouseListener(this);
		new Spritesheet("/spritesheet_cards.png");
		deck = new Deck();

	}

	public void tick() {
		deck.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 480, 480);
		deck.render(g);
		g.setColor(Color.white);
		g.drawString("Pontos:" + score, 375, 50);
		bs.show();

	}

	public static void main(String[] args) {
		Main main = new Main();
		JFrame frame = new JFrame("CardGame");
		frame.add(main);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Thread(main).start();
	}

	@Override
	public void run() {
		requestFocus();
		while (true) {
			tick();
			render();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
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
