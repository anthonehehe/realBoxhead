package realboxhead;

import java.awt.Graphics;

public class Player extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int health;
	int speed = 4;
	public boolean playerUp = false;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	String name;

	public Player(String name) {
		x = 50;
		y = 50;
		height = 30;
		width = 15;
		this.name = name;
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, height, width);
		// g.fillRect(x,y,height,width);
	}

	public int getHP() {
		return health;
	}

	public int setSpd() {
		// equal to 100 (default speed) - weight of the gun
	}

	public int getSpd() {
		return speed;
	}

	// public boolean checkCollide() {
	// }

	public void moveLeft() {

		x -= getSpd();
		System.out.println("left");

	}

	public void moveRight() {

		x += getSpd();

	}

	public void moveUp() {

		y -= getSpd();

	}

	public void moveDown() {

		y += getSpd();

	}

	public void movement() {
		if (playerUp) {
			moveUp();
		}
		if (playerDown) {
			moveDown();
		}
		if (playerLeft) {
			moveLeft();
		}
		if (playerRight) {
			moveRight();
		}

	}

}