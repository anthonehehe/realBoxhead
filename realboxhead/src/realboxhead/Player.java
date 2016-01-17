package realboxhead;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Player extends GameObject {

	public enum Face {
		LEFT, RIGHT, UP, DOWN
	}

	private static final long serialVersionUID = 1L;
	JPanel gs;
	int health = 250;
	public int speed = 3;
	public int width = 45;
	public int height = 60;
	public boolean playerUp;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	public Face face = Player.Face.RIGHT;
	String name;

	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	/**
	 * Constructor for the player with preset location and size
	 * @param gs
	 * @param name
	 */
	public Player(JPanel gs, String name) {
		this.gs = gs;
		this.setLocation(350, 350);
		this.name = name;
		setIcon(new ImageIcon(getClass().getResource("banana1.jpg")));
		
		//this.setSize(getWidth(), getHeight());
		
		//h1 = gs.getHeight();
		//h2 = gs.screen.getHeight();
		//diff = h2 - h1;
		
		//w1 = gs.getWidth();
		//w2 = gs.screen.getWidth();
		//wdiff = w2 - w1;
	}
	
		/**
		 * Draws the player onto the game stage
		 * @param g
		 */
	
	/*
	public void draw(Graphics g) {
		//g.drawRect(50, 50, 15, 30);
		g.fillRect(getLocation().x, getLocation().y, getWidth(), getHeight());
	}
	*/
	
	public int getHP() {
		return health;
	}

	/*
	public double setSpd() {
		// equal to 100 (default speed) - weight of the gun
		return 1d;
	}
	 */
	public int getSpd() {
		return speed;
	}
	
	public void shoot() {
		Bullet p = new Bullet(this, getX(), getY());
		bullets.add(p);
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	/*
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	 */
	// public boolean checkCollide() {
	// }

	public void moveLeft() {
		face = Player.Face.LEFT;
		int x = getX() - speed;
		if (x < 0) {
			x = 0;
		}
		setLocation(x, getY());
	}

	public void moveRight() {
		face = Player.Face.RIGHT;
		int x = getX() + speed;
		if (x + getWidth() > gs.getWidth()) {
			x = (gs.getWidth() - getWidth());
		}
		setLocation(x, getY());
	}

	public void moveUp() {
		face = Player.Face.UP;
		int y = getY() - speed;
		if (y < 0) {
			y = 0;

		}
		setLocation(getX(), y);
	}

	public void moveDown() {
		face = Player.Face.DOWN;
		int y = getY() + speed;
		
		if (y + getHeight() > gs.getHeight()) {
			y = (gs.getHeight()) - getHeight();
		}
		setLocation(getX(), y);
	}

	/**
	 * Moves the player based on which 
	 * directional key is pressed
	 */
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

//		System.out.println(getX() + ":" + getY());

	}
}
