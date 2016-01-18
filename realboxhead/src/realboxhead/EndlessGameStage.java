package realboxhead;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class EndlessGameStage extends JPanel implements ActionListener {

	Screen screen;
	Player player;
	Timer timer;
	

	public EndlessGameStage(Screen screen) {
		this.screen = screen;
		setBounds(0, 0, screen.getWidth(), screen.getHeight());
		setVisible(true);
		this.timer = new Timer(1000 / 120, this);
		this.player = new Player(this, "eian",150);
		this.timer.start();
		player.weapon = new Weapon(100,200,999,999,0,999,"Minigun");
	}

	@Override
	/**
	 * Draws the player onto the screen and
	 * clears its previous image 
	 */
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		if (screen.spawn != null){
			screen.spawn.draw(g);
		}
		player.movement();

		/**
		 * Loops through every bullet,
		 * moving it if it's visible, and 
		 * removing it if it's not
		 */
		for (int i = 0; i < player.bullets.size(); i++) {
			Bullet p = player.bullets.get(i);
			if (p.isVisible() == true) {
				g.setColor(Color.YELLOW);
				g.fillRect(p.getX(), p.getY(), 5, 5);
				p.update();
			} else {
				player.bullets.remove(i);
			}
		}

		player.getIcon().paintIcon(this, g, player.x, player.y);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("COMBO: " + player.eCombo, getWidth() - 100, 20);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("HEALTH: " + player.health, 10, 20);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("WEAPON: " + player.weapon.id, 320, 20);
	}

	@Override
	/**
	 *Checks for collisions and 
	 *updates the screen at a rate
	 *set by the timer
	 */
	public void actionPerformed(ActionEvent e) {

		if (screen.spawn != null) {
			screen.spawn.player = player;
		}

		if (screen.spawn != null && System.currentTimeMillis() - player.lastKill > screen.spawn.interval + 1000) {
			player.lastKill = System.currentTimeMillis();
			player.eCombo--;
			if (player.eCombo < 1) {
				player.eCombo = 0;
			}
		}

		update();
		collisions();
		if (screen.spawn != null && player.health < 1) {
			screen.spawn.getEnemies().clear();
			screen.spawn.spawnRate.stop();
			timer.stop();
			screen.goStage.stage = this;
			screen.cl.show(screen.getContentPane(), "gameover");
			HighScores.saveScore("classic", player.eScore);
		}
		repaint();
	}

	/**
	 * moves the enemy
	 */
	private void update() {
		if (screen.spawn != null) {
			screen.spawn.monMove();
			//System.out.println("moved");
		}	
	}

	/**
	 * Checks for collisions between gameobjects
	 */
	private void collisions() {
		if (screen.spawn != null) {
			ArrayList<Enemy> enemy = screen.spawn.getEnemies();
			ArrayList<Bullet> bullet = player.getBullets();
			
			for (int a = 0; a < bullet.size(); a++) {
				Bullet b = bullet.get(a);
				for (int i = 0; i < enemy.size(); i++) {
					Enemy e = enemy.get(i);
					if (b.collidesWith(e)) {
						e.health -= b.getDmg();
						if (e.health < 1) {
							player.eScore++;
							player.health += 10;
							if (System.currentTimeMillis() - player.lastKill < screen.spawn.interval + 1000) {
								player.eCombo++;
								player.lastKill = System.currentTimeMillis();
							}
							enemy.remove(i);
						}
						bullet.remove(a);
						break;
					}
				}
			}
			for (Enemy e : enemy) {
				if (e.collidesWith(player)) {
					player.hit(25);
				}
			}
			
		}
	}

}
