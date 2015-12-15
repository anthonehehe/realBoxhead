package realboxhead;

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
		this.player = new Player(this, "eian");
		this.timer.start();
	}

	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		// player.draw(g);
		// g.setColor(Color.GRAY);
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
		player.getIcon().paintIcon(this, g, player.getLocation().x,
				player.getLocation().y);
		// System.out.println(player.getX() + ":" + player.getY());

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
