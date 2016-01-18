package realboxhead;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class Spawn implements ActionListener {


	public Player player;
	// Monster controller
	public Timer spawnRate;
	public int interval = 4000;
	// dynamic data structure
	public ArrayList<Enemy> enemies; // no set amount of mobs


	// to refer to the screen
	Screen screen;

	// spawner Constructor
	public Spawn(Screen screen) {
		spawnRate = new Timer(interval, this);
		spawnRate.start();
		enemies = new ArrayList<Enemy>();
		this.screen = screen;
//		System.out.println("spawned");
	}

	public void draw(Graphics g) {
//		System.out.println("drawn");
		for (int i = 0; i < enemies.size(); i++) { // loop
			enemies.get(i).draw(g); // for every monster
			
		}

	}

	public void monMove() {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).move();
		}
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (screen.screen.equals("classic")) {
			interval -= 200;
			if (interval < 1500) {
				interval = 1500;
			}
			spawnRate.setDelay(interval);
			Enemy.baseHealth += 0.50 * player.cScore;
			
		} else if (screen.screen.equals("endless")) {
			interval -= 400;
			if (interval < 1000) {
				interval = 1000;
			}
			spawnRate.setDelay(interval);
			Enemy.baseHealth += 5 * player.eScore;
		}
	
		Random rand = new Random();
		if (rand.nextBoolean()) {
			enemies.add(new Enemy(rand.nextInt(screen.getWidth()), 0, 25, 25, screen));
		} else {
			enemies.add(new Enemy(rand.nextBoolean() ? 0 : 800, 100, 25, 25, screen));
		}
	}

	
}
