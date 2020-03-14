import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {

	public List<Carta> cartas = new ArrayList<Carta>();

	public int lastPosX = 0;
	public int lastPosY = 120;

	public Deck() {
		// Cria as cartas do deck
		for (int i = 0; i < 10; i++) {
			Carta carta = new Carta(0, 10);
			carta.sprite = Spritesheet.getSprite(i * 71, 0, 71, 95);
			carta.score = i + 1;
			cartas.add(carta);
		}
		// Embaralha e ordena
		Collections.shuffle(cartas);
		for (int i = 0; i < 10; i++) {
			Carta carta = cartas.get(i);
			carta.x = carta.x + (i * 30);
		}

	}

	public void checkCardPressed() {
		if (Main.pressed) {
			Main.pressed = false;
			for (int i = cartas.size() - 1; i >= 0; i--) {
				Carta tempCarta = cartas.get(i);
				if (Main.mouse_x > tempCarta.x && Main.mouse_x < tempCarta.x + 72) {
					if (Main.mouse_y > tempCarta.y && Main.mouse_y < tempCarta.x + 95) {
						if (tempCarta.flip == false) {
							tempCarta.flip = true;
							tempCarta.x = lastPosX;
							lastPosX += 70;
							tempCarta.y = lastPosY;
							Main.score += (tempCarta.score);
							return;
						}
					}
				}
			}
		}
	}

	public void tick() {
		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).tick();
		}
		checkCardPressed();
	}

	public void render(Graphics g) {
		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).render(g);
		}
	}

}
