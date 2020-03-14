import java.awt.Graphics;

public class Player {

	public boolean right, left, changeShape = false;

	public int x, y;

	public Bloco bloco;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		bloco = new Bloco(x, y);
	}

	public boolean canGo(int nextx, int nexty) { // Não permite sair da tela na horizontal
		if (x < 0) { // Na esquerda
			x = 0;
			return false;
		}
		int ww = Shapes.shapes.get(bloco.shape).width;
		if (x + ww > 480) { // Na direita
			x = 480 - ww; // Estabiliza para troca de formato
			return false;
		}
		return true;
	}

	public void tick() {
		
		if (right && canGo(x + 4, y)) { // Movimenta o bloco
			x += 4;
		} else if (left && canGo(x - 4, y)) {
			x -= 4;
		}

		if (changeShape) { // Muda a forma do bloco
			changeShape = false;
			bloco.shape++;
			if (bloco.shape == Shapes.shapes.size()) {
				bloco.shape = 0;
			}
		}

		bloco.x = x;
		bloco.tick();

	}

	public void render(Graphics g) {
		bloco.render(g);
	}

}
