package realboxhead;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameObject extends JLabel {

	
//	int x;
//	int y;
//	int height;
//	int width;

	public boolean collidesWith(Object object) {
		return this.getBounds().intersects(object.getBounds());
	}

}
