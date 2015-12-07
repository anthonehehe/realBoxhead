package realboxhead;

public class Weapon extends GameObject {

	int minDmg;
	int maxDmg;
	int maxAmmo;
	int ammoLeft;
	int ammoInClip;
	int clipSize;
	int weight;
	int spread;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getMinDmg() {

		return minDmg;
	}

	public int getMaxDmg() {

		return maxDmg;
	}

	
	public void reload() {
		int ammoCanLoad = (int) Math.min(ammoLeft, clipSize); //checks to see how much we need to fill
		int ammoToLoad = (int) Math.min(ammoCanLoad,(clipSize - ammoInClip)); //sets the amount that we need to fill
		ammoInClip += ammoToLoad; //adds bullets to clip
		ammoLeft -= ammoToLoad; //subtracts bullets from total
	}

	/*public int getAmmoTotal() {
		if (ammoLeft < 1) {
			return 0;
		} else {
			return ammoLeft;
		}
	}*/

	Weapon(int minDmg, int maxDmg, int clipSize, int ammoLeft, int weight,
			int spread) {
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.clipSize = clipSize;
		this.ammoLeft = ammoLeft;
		this.weight = weight;
		this.spread = spread;
	}

	// Default weapon, pistol
	Weapon() {
		this(5, 10, 20, 9999, 0, 3);
	}
}
