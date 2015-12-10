package realboxhead;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
     Screen screen;
     
	public Input(Screen screen) {
		 this.screen = screen;
	}

	
	@Override
	/**
	 * Checks if any of the arrow
	 * keys have been pressed, and changes the
	 * player's respective direction boolean to true
	 * when they are pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.gStage.player.playerUp = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.gStage.player.playerDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.gStage.player.playerLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.gStage.player.playerRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			Player player = screen.gStage.player;
			System.out.println(player.getY());
		}
	}

	@Override
	/**
	 * When a key is released, the player is no longer moving 
	 * in the respective direction, this changes direction boolean 
	 * to false to stop player movement
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.gStage.player.playerUp = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.gStage.player.playerDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.gStage.player.playerLeft = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.gStage.player.playerRight = false;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
