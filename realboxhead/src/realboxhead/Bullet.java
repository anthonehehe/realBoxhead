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
	
		//public int x, y;
	    public int speed;
		private boolean visible;
		private final Face face;
		public int dmg = 10;
		
		/**
		 * Constructor for bullet, checking where player
		 * is facing and where player currently is
		 * @param player
		 * @param startX
		 * @param startY
		 */
		public Bullet(Player player, int startX, int startY, int height, int width, int dmg){
			this.player = player;
			this.face = player.face;
			this.setBounds(startX ,startY , width, height);
			speed = 7;
			visible = true;
			this.dmg = dmg;
		}
		/**
		 * Updates bullet location based on speed variable, 
		 * then checks for its location to determine whether
		 * it needs to be removed or not
		 */
		public void update(){
			
			if (face == Player.Face.LEFT) {
				this.x -= speed;
			}
			
			if (face == Player.Face.RIGHT) {
				this.x += speed;
			}
			
			if (face == Player.Face.UP) {
				this.y -= speed;
			}
			
			if (face == Player.Face.DOWN) {
				this.y += speed;
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

		public int getSpeed() {
			return speed;
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

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
		}
		
		/**
		 * 
		 * @param id
		 * @return value using if statements
		 * ex. if(shotgun) {
		 * return 10;
		 */
		
		public int getDmg() {
			return dmg;
		}
		
	}
	

