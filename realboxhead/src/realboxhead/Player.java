package realboxhead;

import java.awt.Graphics;


public class Player extends GameObject {


	private static final long serialVersionUID = 1L;
	ClassicGameStage gs;
	int health;
	double speed = 27.75;
	public int width = 15;
	public int height = 30;
	public boolean playerUp;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	String name;

	
	/**
	 * Constructor for the player with preset location and size
	 * @param gs
	 * @param name
	 */
	public Player(ClassicGameStage gs, String name) {
		this.gs = gs;
		this.setLocation(50, 50);
		this.setSize(getWidth(), getHeight());
		this.name = name;
		//setIcon(new ImageIcon(getClass().getResource("banana.jpg")));
		
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
	public void draw(Graphics g) {
		//g.drawRect(50, 50, 15, 30);
		g.fillRect(getLocation().x, getLocation().y, getWidth(), getHeight());
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
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
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
		if (x + getWidth() > gs.getWidth()) {
			x = (gs.getWidth() - getWidth());
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
		
		if (y + getHeight() > gs.getHeight()) {
			y = (gs.getHeight()) - getHeight();
		}
		setLocation(getX(), y);
	}

	/**
	 * checks if the player wants to move
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

	}
}