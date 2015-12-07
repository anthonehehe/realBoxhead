package realboxhead;

public class Enemy extends GameObject {

	int health;
	int dmg;
	int speed;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
