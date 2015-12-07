package realboxhead;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	
	Screen screen;
	
	public MainMenu(Screen screen) {
		this.screen = screen;
		setVisible(true);
		setBounds(500, 500, 500, 500);
		setBackground(Color.BLACK);
		
		// add a button
		JButton mainButton = new JButton("Start");
		//set the button to switch to the start stage
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen, "level");
			}
		});
		this.add(mainButton);
		
	
	}
	
	




}
