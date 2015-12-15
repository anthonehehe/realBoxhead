package realboxhead;

public class Bullet extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private int x, y, speedX;
		private boolean visible;
		
		public Bullet(int startX, int startY){
			x = startX;
			y = startY;
			speedX = 7;
			visible = true;
		}
		
		public void update(){
			if (left) {
				x -= speedX;
			} 
			
			if (right) {
				
			}
			x += speedX;
			if (x > 800){
				visible = false;
			}
			
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getSpeedX() {
			return speedX;
		}

		public boolean isVisible() {
			return visible;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
		}
		
	}
	

