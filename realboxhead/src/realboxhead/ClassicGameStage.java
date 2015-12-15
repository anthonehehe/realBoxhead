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
	Player player;
	Timer timer;

	/**
	 * Constructor for classic mode game stage,
	 * setting its properties and initializing a timer
	 * so the player can move
	 * @param screen
	 */
	 
	public ClassicGameStage(Screen screen) {
		this.screen = screen;
		setBounds(0,0,screen.getWidth(),screen.getHeight());
		setVisible(true);
//		this.setLayout(null);
		System.out.println(this.getLayout().toString());
		this.timer = new Timer(1000/120, this);
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
		//player.draw(g);
		//g.setColor(Color.GRAY);
		player.movement();
		
		ArrayList bullets = player.getBullets();
		for (int i = 0; i < bullets.size(); i++) {
			Bullet p = (Bullet) bullets.get(i);
			if (p.isVisible() == true) {
				p.update();
			} else {
				bullets.remove(i);
			}
		}
		
		ArrayList bullets1 = player.getBullets();
		for (int i = 0; i < bullets1.size(); i++) {
			Bullet p = (Bullet) bullets1.get(i);
			g.setColor(Color.YELLOW);
			g.fillRect(p.getX(), p.getY(), 10, 5);
		}
		
		player.getIcon().paintIcon(this, g, player.getLocation().x, player.getLocation().y);
	//	System.out.println(player.getX() + ":" + player.getY());
		
	}
	
	@Override
	/**
	 * Calls the paintComponent method at 
	 * a rate based on the timer
	 */
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
