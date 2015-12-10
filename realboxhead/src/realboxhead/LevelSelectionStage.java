package realboxhead;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectionStage extends JPanel{
	
	Screen screen;
	
	/**
	 * Constructor for the level selection stage, 
	 * sets its properties and places buttons on the
	 * stage that listen for mouse events
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
			}
		});
		this.add(mainButton);
		
		
		JButton butt = new JButton("Play");
		butt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				screen.cl.show(screen.getContentPane(), "play" );
			}
		});
		this.add(butt);
		
	}

}
