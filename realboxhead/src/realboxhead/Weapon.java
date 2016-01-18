package realboxhead;

public class Weapon extends GameObject {

	int minDmg;
	int maxDmg;
	int maxAmmo;
	int totalAmmo; // bullets to reload with
	int clipSize; // max ammo in a clip
	int ammoInClip; // ammo left in the clip
	int weight;
	String id;
	//int spread;
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

	
	public int getDamage() {
		return (int) (Math.floor(Math.random() * (maxDmg - minDmg + 1) + minDmg));
	}
	
	public void reload() {
		int ammoCanLoad = (int) Math.min(totalAmmo, clipSize); //checks to see how much we need to fill
		int ammoToLoad = (int) Math.min(ammoCanLoad,(clipSize - ammoInClip)); //sets the amount that we need to fill
		ammoInClip += ammoToLoad; //adds bullets to clip
		totalAmmo -= ammoToLoad; //subtracts bullets from total
	}

	/*public int getAmmoTotal() {
		if (ammoLeft < 1) {
			return 0;
		} else {
			return ammoLeft;
		}
	}*/

	Weapon(int minDmg, int maxDmg, int clipSize, int ammoLeft, int weight, int ammoInClip, String id) {
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.ammoInClip = ammoInClip;
		this.clipSize = clipSize;
		this.totalAmmo = ammoLeft;
		this.weight = weight;
		this.id = id;
		//this.spread = spread;
	}

	// Default weapon, pistol
	Weapon() {
		this(20, 20, 20, 9999, 0, 20, "Pistol");
	}
	
}
