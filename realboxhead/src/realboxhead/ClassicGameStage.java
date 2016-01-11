package realboxhead;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ClassicGameStage extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Screen screen;
	Spawn spawn;
	Player player;
	Timer timer;

	/**
	 * Constructor for classic mode game stage, setting its properties and
	 * initializing a timer so the screen can update
	 * 
	 * @param screen
	 */

	public ClassicGameStage(Screen screen) {
		this.screen = screen;
		// setBackground(Color.GREEN);
		setBounds(0, 0, screen.getWidth(), screen.getHeight());
		setVisible(true);
		// this.setLayout(null);
		System.out.println(this.getLayout().toString());
		this.timer = new Timer(1000 / 120, this);
		this.player = new Player(this, "ean");
		this.timer.start();
	}

	@Override
	/**
	 * Draws the player onto the screen and
	 * clears its previous image 
	 */
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		// player.draw(g);
		g.setColor(Color.GREEN);
		if (screen.spawn != null){
			screen.spawn.draw(g);
			System.out.println("draw");
		}
		player.movement();

		/**
		 * Loops through every bullet,
		 * moving it if it's visible, and 
		 * removing it if it's not
		 */
		ArrayList bullets = player.getBullets();
		for (int i = 0; i < bullets.size(); i++) {
			Bullet p = (Bullet) bullets.get(i);
			if (p.isVisible() == true) {
				g.setColor(Color.YELLOW);
				g.fillRect(p.getX(), p.getY(), 5, 5);
				p.update();
			} else {
				bullets.remove(i);
			}
		}

		// ArrayList bullets1 = player.getBullets();
		// for (int i = 0; i < bullets1.size(); i++) {
		// Bullet p = (Bullet) bullets1.get(i);
		//
		// }

		player.getIcon().paintIcon(this, g, player.getLocation().x,
				player.getLocation().y);
		// System.out.println(player.getX() + ":" + player.getY());

	}

	@Override
	/**
	 *Checks for collisions and 
	 *updates the screen at a rate
	 *set by the timer
	 */
	public void actionPerformed(ActionEvent e) {
		collisions();
		update();
		repaint();
	}

	private void update() {
		// TODO Auto-generated method stub
		if (screen.spawn != null) {
			screen.spawn.monMove();
			System.out.println("moved");
		}	
	}

	private void collisions() {
		// TODO Auto-generated method stub
		if (screen.spawn != null) {
			ArrayList<Enemy> enemy = screen.spawn.getEnemies();
			ArrayList<Bullet> bullet = player.getBullets();
			for (int a = 0; a < bullet.size(); a++) {
				for (int b = 0; b < enemy.size(); b++) {
					if (bullet.get(a).collidesWith(enemy.get(b))) {
						enemy.get(b).health -= bullet.get(a).getDmg();
						if (enemy.get(b).health < 1) {
							enemy.remove(b);
						}
					}
				}
			}
		}
	}

}
