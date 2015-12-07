package realboxhead;

public class Barrel extends GameObject {

	int dmg;
	int radius;
	int health;
	boolean exploded;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public int getDmg() {
		
		return dmg;
	}
	
	public int getHP() {
		
		return health;
	}
	
	public int getRadius() {
		
		return radius;
	}
	
	public void isExploded() {
		if (health < 1) {
			exploded = true;
		}
		//remove prop from screen
	}
}
