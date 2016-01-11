package realboxhead;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameObject extends JLabel {

	
//	int x;
//	int y;
//	int height;
//	int width;

	public boolean collidesWith(GameObject gameObject) {
		return this.getBounds().intersects(gameObject.getBounds());
	}

}
