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
	int health;
	public int speed = 4;
	public int width = 45;
	public int height = 60;
	public int cScore = 0;
	public int eScore = 0;
	public int cCombo = 0;
	public int cMaxCombo = 0;
	public int eCombo = 0;
	public long lastKill = 0;
	public long lastShot = 0;
	public long lastHit = 0;
	public boolean playerUp;
	public boolean playerDown;
	public boolean playerLeft;
	public boolean playerRight;
	public Weapon weapon = new Weapon();
	public Face face = Player.Face.RIGHT;
	String name;

	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	/**
	 * Constructor for the player with preset location and size
	 * @param gs
	 * @param name
	 */
	public Player(JPanel gs, String name, int health) {
		this.gs = gs;
		this.name = name;
		this.health = health;
		this.setBounds(0, 0, width, height);
		setIcon(new ImageIcon(getClass().getResource("banana1.jpg")));
	}
	
	
//	public int getHP() {
//		return health;
//	}
//
//	public double setSpd() {
//		// equal to 100 (default speed) - weight of the gun
//		return 1d;
//	}
//	public int getSpd() {
//		return speed;
//	}

	/**
	 * Sets fire rate of gun to 1 bullet per second
	 * if bullet has not been fired within the second,
	 * fire the bullet
	 */
	public void shoot() {
		if (System.currentTimeMillis() - lastShot > 100) {
			lastShot = System.currentTimeMillis();
			Bullet p = new Bullet(this, this.x, this.y,5,5, weapon.getDamage());
			bullets.add(p);
			weapon.ammoInClip--;
		}
		if (weapon.ammoInClip < 1) {
			weapon.reload();
		}
	}
	
	
	/**
	 * Sets delay that player can take damage 
	 * @param damage
	 */
	public void hit(int damage) {
		if (System.currentTimeMillis() - lastHit > 2000) {
			lastHit = System.currentTimeMillis();
			health -= damage;
		}
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public void moveLeft() {
		this.x -= speed;
		if (x < 0) {
			x = 0;
		}
	}

	public void moveRight() {
		this.x += speed;
		if (x + this.width > gs.getWidth()) {
			x = (gs.getWidth() - this.width);
		}
	}

	public void moveUp() {
		this.y -= speed;
		if (y < 0) {
			y = 0;

		}
	}

	public void moveDown() {
		this.y += speed;		
		if (y + this.height > gs.getHeight()) {
			y = (gs.getHeight()) - this.height;
		}
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
