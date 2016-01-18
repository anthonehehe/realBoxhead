package realboxhead;

import java.awt.Graphics;
import java.util.ArrayList;

import com.sun.javafx.geom.Rectangle;

public class Enemy extends GameObject {

	public static int baseHealth = 100;
	int health;
	int dmg;
	int speed = 1;
	Screen screen;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enemy(int x, int y, int height, int width, Screen screen) {
		this.health = baseHealth;
		this.screen = screen;
		setBounds(x, y, width, height);
	}

	public void move() {
		Player player = (screen.screen.equals("classic") ? screen.gStage.player
				: screen.eStage.player);
		int xTemp = this.x - player.x;
		int yTemp = this.y - player.y;
		if (xTemp < 0) { 
			x += speed;
		}
		if (xTemp > 0) { 
			x -= speed;
		}
		if (yTemp < 0) { 
			y += speed;
		}
		if (yTemp > 0) {
			y -= speed;
		}
	}
	
	public void draw(Graphics g) {
		int w = (width / 10) * health;
		w /= 4;
		g.fillRect(x - (w / 2) + (width / 2), y - 12, w, 10);
		g.fillRect(x, y, 25, 25);
	}

	public int getHP() {

		return health;
	}

	public int getDmg() {

		return dmg;
	}

	public int setDmg() {
		return 1;
	}

	public int getSpd() {

		return speed;
	}

}
