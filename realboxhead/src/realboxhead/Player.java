package realboxhead;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int health;
	double speed = 27.75;
	public boolean playerUp;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	String name;

	public Player(String name) {
		this.setLocation(50, 50);
		this.setSize(15, 30);
		this.name = name;
		//setIcon(new ImageIcon(getClass().getResource("banana.jpg")));
	}

	public void draw(Graphics g) {
		//g.drawRect(50, 50, 15, 30);
		g.fillRect(getLocation().x, getLocation().y, 15, 30);
	}

	public int getHP() {
		return health;
	}

	public double setSpd() {
		// equal to 100 (default speed) - weight of the gun
		return 1d;
	}

	public double getSpd() {
		return speed;
	}

	// public boolean checkCollide() {
	// }

	public void moveLeft() {
		int x = getX() - ((int) getSpd());
		if (x < 0) {
			x = 0;
		}
		setLocation(x, getY());
	}

	public void moveRight() {
		int x = getX() + ((int) getSpd());
		if (x > Screen.WIDTH - getWidth()) {
			x = (Screen.WIDTH - getWidth());
		}
		setLocation(x, getY());
	}

	public void moveUp() {
		int y = getY() - ((int) getSpd());
		if (y < 0) {
			y = 0;
		}
		setLocation(getX(), y);
	}

	public void moveDown() {
		int y = getY() + ((int) getSpd());
		if (y > Screen.HEIGHT - getHeight()) {
			y = Screen.HEIGHT - getHeight();
		}
		setLocation(getX(), y);
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