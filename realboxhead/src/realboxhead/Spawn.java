package realboxhead;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Spawn implements ActionListener {


	// Monster controller
	public Timer spawnRate;
	// dynamic data structure
	public ArrayList<Enemy> enemies; // no set amount of mobs


	// to refer to the screen
	Screen screen;

	// spawner Constructor
	public Spawn(Screen screen) {
		spawnRate = new Timer(1000, this);
		spawnRate.start();
		enemies = new ArrayList<Enemy>();
		this.screen = screen;
		System.out.println("spawned");
	}

	public void draw(Graphics g) {
		System.out.println("drawn");
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
		System.out.println("newthing");
		enemies.add(new Enemy(100, 400, 0, 25, 25, screen));

	}

}
