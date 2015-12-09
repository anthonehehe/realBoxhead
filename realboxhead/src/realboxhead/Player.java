package realboxhead;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameStage gs;
	int health;
	double speed = 27.75;
	public boolean playerUp;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	String name;
	
	int h1;
	int h2;
	int diff;
	
	int w1;
	int w2;
	int wdiff;
	

	public Player(GameStage gs, String name) {
		this.gs = gs;
		this.setLocation(50, 50);
		this.setSize(15, 30);
		this.name = name;
			//setIcon(new ImageIcon(getClass().getResource("banana.jpg")));
		
		h1 = gs.getHeight();
		h2 = gs.screen.getHeight();
		diff = h2 - h1;
		
		w1 = gs.getWidth();
		w2 = gs.screen.getWidth();
		wdiff = w2 - w1;
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
		if (x + getWidth() > Screen.WIDTH - wdiff) {
			x = (Screen.WIDTH - getWidth()) - wdiff;
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
		
		if (y + getHeight() > Screen.HEIGHT - diff) {
			y = (Screen.HEIGHT - diff) - getHeight();
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