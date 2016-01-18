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
		Player player = (screen.screen.equals("classic") ? screen.gStage.player
				: screen.eStage.player);
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.playerUp = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.playerDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.playerLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.playerRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.face = Player.Face.UP;
			player.shoot();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.face = Player.Face.DOWN;
			player.shoot();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.face = Player.Face.LEFT;
			player.shoot();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.face = Player.Face.RIGHT;
			player.shoot();
		}
		if (e.getKeyCode() == KeyEvent.VK_1) {
			player.weapon = new Weapon();
		}
		if (player.cCombo >= 5) {
			if (e.getKeyCode() == KeyEvent.VK_2) {
				player.weapon = new Weapon(30, 30, 30, 200, 1, 30);
			}
		}
		if (player.cCombo >= 20) {
			if (e.getKeyCode() == KeyEvent.VK_3) {
				player.weapon = new Weapon(35, 100, 8, 64, 2, 8);
			}
		}
		if (player.cCombo >= 75) {
			if (e.getKeyCode() == KeyEvent.VK_4) {
				player.weapon = new Weapon(90,120,5,25,2,5);
			}
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
		Player player = (screen.screen.equals("classic") ? screen.gStage.player
				: screen.eStage.player);

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.playerUp = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.playerDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.playerLeft = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.playerRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
