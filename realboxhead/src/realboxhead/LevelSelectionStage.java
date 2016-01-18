package realboxhead;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectionStage extends JPanel{
	
	Screen screen;
	Spawn spawn;
	
	/**
	 * Constructor for the level selection stage, 
	 * sets its properties and places buttons on the
	 * stage that switch between screens when pressed
	 * @param screen
	 */
	public LevelSelectionStage(Screen screen) {
		this.screen = screen;
		setVisible(true);
		setBackground(Color.RED);
		
		
		JButton mainButton = new JButton("Back To Main Menu");
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen.getContentPane(), "menu");
				screen.screen = "menu";
			}
		});
		this.add(mainButton);
		
		
		JButton classicModeButton = new JButton("Classic Mode");
		classicModeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				screen.cl.show(screen.getContentPane(), "classic" );
				screen.screen = "classic";
				screen.spawn = new Spawn(screen);
			}
		});
		this.add(classicModeButton);
		
		

		JButton endlessModeButton = new JButton("Endless Mode");
		endlessModeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				screen.cl.show(screen.getContentPane(), "endless" );
				screen.screen = "endless";
				screen.spawn = new Spawn(screen);
			}
		});
		this.add(endlessModeButton);
		
	}

}
