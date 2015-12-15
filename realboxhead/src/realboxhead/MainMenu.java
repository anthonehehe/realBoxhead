package realboxhead;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	
	Screen screen;
	
	
	/**
	 * Constructor for the main menu stage, 
	 * sets properties and places a button onto the screen
	 * @param screen
	 */
	public MainMenu(Screen screen) {
		this.screen = screen;
		setVisible(true);
		//setBounds(500, 500, 500, 500);
		setBackground(Color.BLACK);
		
		// add a button
		JButton levelButton = new JButton("Start");
		//set the button to switch to the start stage
		levelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen.getContentPane(), "levels");
			}
		});
		this.add(levelButton);
		
		JButton optionsButton = new JButton("Options");
		//set the button to switch to the start stage
		optionsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen.getContentPane(), "options");
			}
		});
		this.add(optionsButton);
	}
	
	




}
