package realboxhead;

import java.awt.Rectangle;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameObject extends JLabel {

	
	int x;
	int y;
	int height;
	int width;

	/**
	 * Returns bounds based on class variables
	 */
	@Override
	public java.awt.Rectangle getBounds() {
		return new java.awt.Rectangle(this.x, this.y, this.width, this.height);
	}
	
	/**
	 * Sets bounds of GameObject based on class variables
	 */
	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Checks whether two GameObjects are touching each other
	 * @param gameObject
	 * @return
	 */
	public boolean collidesWith(GameObject gameObject) {
		boolean collides = false;
		if (gameObject.getBounds().intersects(this.getBounds())) {
			collides = true;
		}
		return collides;
//		Rectangle r = new Rectangle(this.x, this.y, this.height, this.width);
//		Rectangle r2 = new Rectangle(gameObject.x, gameObject.y, gameObject.height,
//	    gameObject.width);
//		return r.intersects(r2);
		
	}

}
