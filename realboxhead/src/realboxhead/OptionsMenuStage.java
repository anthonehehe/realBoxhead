package realboxhead;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsMenuStage extends JPanel {
	
	Screen screen;
	
	public OptionsMenuStage(Screen screen) {
		this.screen = screen;
		setBounds(0,0,screen.getWidth(), screen.getHeight());
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		
		
		JButton mainButton = new JButton("Back To Main Menu");
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen.getContentPane(), "menu");
			}
		});
		this.add(mainButton);
		
	}

}
