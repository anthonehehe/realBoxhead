package realboxhead;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;


public class Screen extends JFrame  {

	static final int HEIGHT = 800;
	static final int WIDTH = 800;

	public MainMenu menu;
	public Container pane;
	public LevelSelectionStage levels;
	public ClassicGameStage gStage;
	public CardLayout cl = new CardLayout();
	
	
	/**
	 * Constructor for screen, sets its properties 
	 * and adds JPanels so they can be used 
	 */
	public Screen() {
		setTitle("Boxhead: Apocalypse");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new MainMenu(this);
		levels = new LevelSelectionStage(this);
		gStage = new ClassicGameStage(this);
		
		pane = getContentPane();
		pane.setLayout(cl);
		pane.add(menu, "menu");
		pane.add(levels, "levels");
		pane.add(gStage, "play");
		pane.setVisible(true);
		init();

	}
	
	/**
	 * Starts the timer and 
	 * implements a key listener for the screen
	 * 
	 */
	private void init() {
		setFocusable(true);
		addKeyListener(new Input(this));
	}

	public static void main(String[] args) {
		Screen screen = new Screen();
	}


}
