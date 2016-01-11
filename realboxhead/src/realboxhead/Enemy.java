package realboxhead;

import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy extends GameObject {

	int health = 100;
	int dmg;
	int speed = 2;
	int x;
	int y;
	Screen screen;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enemy(int health, int x, int y, int height, int width, Screen screen) {
		this.health = health;
		this.screen = screen;
		setBounds(x, y, height, width);
		this.x = x;
		this.y = y;
	}

	public void move() {
		int xTemp = this.x - screen.gStage.player.getX();
		int yTemp = this.y - screen.gStage.player.getY();
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
		// g.draw(img,x,y,height,width);
		g.fillRect(x, y, 25, 25);
		System.out.println("spawn");
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
