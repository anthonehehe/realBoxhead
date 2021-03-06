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

	/**
	 * Moves the enemy towards the player's location
	 */
	public void move() {
		Player player = (screen.screen.equals("classic") ? screen.gStage.player
				: screen.eStage.player);
		int xTemp = this.x - player.x; // distance between the x of player and enemy
		int yTemp = this.y - player.y; // distance between the y of player and enemy
		if (xTemp < 0) { // if player is to the enemy's right
			x += speed;
		}
		if (xTemp > 0) { // if player is to the enemy's left
			x -= speed;
		}
		if (yTemp < 0) { // if player is below enemy
			y += speed;
		}
		if (yTemp > 0) { // if player is above enemy 
			y -= speed;
		}
	}
	
	/**
	 *  Draws the enemy and a health bar for it
	 * @param g
	 */
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
