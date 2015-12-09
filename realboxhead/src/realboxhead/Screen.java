package realboxhead;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Screen extends JFrame implements ActionListener {

	Timer time = new Timer(1000 / 60, this);
	static final int HEIGHT = 800;
	static final int WIDTH = 800;

	public MainMenu menu;
	public Container pane;
	public LevelStage levels;
	public GameStage gStage;
	public CardLayout cl = new CardLayout();
	
	public Screen() {
		setTitle("Boxhead: Apocalypse");
		setSize(HEIGHT, WIDTH);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new MainMenu(this);
		levels = new LevelStage(this);
		gStage = new GameStage(this);
		
		pane = getContentPane();
		pane.setLayout(cl);
		pane.add(menu, "menu");
		pane.add(levels, "levels");
		pane.add(gStage, "play");
		pane.setVisible(true);
		init();

	}

	private void init() {
		time.start();
		setFocusable(true);
		addKeyListener(new Input(this));
	}

	public static void main(String[] args) {
		Screen screen = new Screen();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();

	}
}
