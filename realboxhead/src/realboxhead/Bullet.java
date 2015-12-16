package realboxhead;

public class Bullet extends GameObject {
	
	/**
	 * 
	 */
	Player player;
	Screen screen;
	
	private static final long serialVersionUID = 1L;
	
		private int x, y, speedX, speedY;
		private boolean visible;
		boolean bulletLeft, bulletRight, bulletUp, bulletDown = false;
		
		public Bullet(Player player, int startX, int startY){
			x = startX;
			y = startY;
			this.player = player;
			if (player.playerLeft) {
				bulletLeft = true;
			} 
			
			if (player.playerRight) {
				bulletRight = true;
			}
			// while bullet.x + bullet.y does not equal mouse.x + mouse.y
			//	while bullet.x does not equal mouse.x 
			// 		add speedX to bullet.x
			//	while bullet.y does not equal mouse.y
			// 		add speedY to bullet.y
			if (player.playerUp){
				bulletUp = true;
			}
			
			if (player.playerDown) {
				bulletDown = true;
			}
			speedX = 7;
			speedY = 7;
			visible = true;
		}
		
		public void update(){
			if (bulletLeft) {
				x -= speedX;
			}
			
			if (bulletRight) {
				x += speedX;
			}
			
			if (bulletUp) {
				y -= speedY;
			}
			
			if (bulletDown) {
				y += speedY;
			}
			
			if (x > player.gs.getWidth()){
				visible = false;
			}
			
			if (y > player.gs.getHeight()) {
				visible = false;
			}
			
			if (x < 0) {
				visible = false;
			}
			
			if (y < 0) {
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
	

