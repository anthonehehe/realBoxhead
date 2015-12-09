package realboxhead;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameStage extends JPanel implements ActionListener {
	
	Screen screen;
	Player player;
	Timer timer;

	public GameStage(Screen screen) {
		this.screen = screen;
		setBounds(500,500,500,500);
		setVisible(true);
		this.timer = new Timer(1000/120, this);
		this.player = new Player(this, "ean");
		
		this.timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		player.movement();
		g.setColor(Color.BLACK);
		player.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
