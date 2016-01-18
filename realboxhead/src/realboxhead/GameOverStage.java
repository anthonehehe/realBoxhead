package realboxhead;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOverStage extends JPanel {

	Screen screen;
	JPanel stage;

	public GameOverStage(Screen screen) {
		this.screen = screen;
		setBackground(Color.BLUE);
		setVisible(true);

		JButton playAgainButton = new JButton("Play Again");
		playAgainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (stage instanceof ClassicGameStage) {
					ClassicGameStage gStage = (ClassicGameStage) stage;
					gStage.player = new Player(gStage, "ean", 100);
					gStage.timer.start();
					gStage.screen.spawn = new Spawn(screen);
					gStage.screen.spawn.spawnRate.start();
					screen.cl.show(screen.getContentPane(), "classic");
					screen.screen = "classic";
				} else if (stage instanceof EndlessGameStage) {
					EndlessGameStage eStage = (EndlessGameStage) stage;
					eStage.player = new Player(eStage, "ean", 150);
					eStage.timer.start();
					eStage.screen.spawn = new Spawn(screen);
					eStage.screen.spawn.spawnRate.start();
					screen.cl.show(screen.getContentPane(), "endless");
					screen.screen = "endless";
				}
			}
		});
		this.add(playAgainButton);
	}
}
