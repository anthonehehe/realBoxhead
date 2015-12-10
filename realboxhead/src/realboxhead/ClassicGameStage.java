package realboxhead;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ClassicGameStage extends JPanel implements ActionListener {
	
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
		player.movement();
		player.draw(g);
		g.setColor(Color.GRAY);
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
