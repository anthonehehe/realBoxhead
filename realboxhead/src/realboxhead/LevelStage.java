package realboxhead;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelStage extends JPanel{
	
	Screen screen;
	
	public LevelStage(Screen screen) {
		this.screen = screen;
		setVisible(true);
		setBackground(Color.RED);
		setBounds(500,500,500,500);
		
		JButton mainButton = new JButton("Back To Main Menu");
		//set the button to switch to the start stage
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				screen.cl.show(screen.getContentPane(), "menu");
			}
		});
		this.add(mainButton);
		
		JButton butt = new JButton("Yes");
		this.add(butt);
		
	}

}
