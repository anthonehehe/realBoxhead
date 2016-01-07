package realboxhead;

import realboxhead.Player.Face;
import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject {
	
	/**
	 * 
	 */
	Player player;
	Screen screen;
	
	private static final long serialVersionUID = 1L;
	
		private int x, y, speedX, speedY;
		private boolean visible;
		private final Face face;
		
		/**
		 * Constructor for bullet, checking where player
		 * is facing and where player currently is
		 * @param player
		 * @param startX
		 * @param startY
		 */
		public Bullet(Player player, int startX, int startY){
			x = startX;
			y = startY;
			this.player = player;
			this.face = player.face;
		
			// while bullet.x + bullet.y does not equal mouse.x + mouse.y
			//	while bullet.x does not equal mouse.x 
			// 		add speedX to bullet.x
			//	while bullet.y does not equal mouse.y
			// 		add speedY to bullet.y
			speedX = 7;
			speedY = 7;
			visible = true;
		}
		/**
		 * Updates bullet location based on speed variable, 
		 * then checks for its location to determine whether
		 * it needs to be removed or not
		 */
		public void update(){
			if (face == Player.Face.LEFT) {
				x -= speedX;
			}
			
			if (face == Player.Face.RIGHT) {
				x += speedX;
			}
			
			if (face == Player.Face.UP) {
				y -= speedY;
			}
			
			if (face == Player.Face.DOWN) {
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
	

