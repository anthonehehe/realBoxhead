package realboxhead;

import java.awt.Color;

import javax.swing.JPanel;

public class LevelStage extends JPanel{
	
	Screen screen;
	
	public LevelStage(Screen screen) {
		this.screen = screen;
		setVisible(true);
		setBackground(Color.RED);
		setBounds(500,500,500,500);
	}

}
