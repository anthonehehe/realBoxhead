package realboxhead;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
     Screen screen;
     
	public Input(Screen screen) {
		// TODO Auto-generated constructor stub
		 this.screen = screen;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.player.playerUp = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.player.playerDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.player.playerLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.player.playerRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.player.playerUp = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.player.playerDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.player.playerLeft = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.player.playerRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
