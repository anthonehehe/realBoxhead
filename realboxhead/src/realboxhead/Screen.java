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

	public Player player = new Player("TonEY");
	public MainMenu menu;
	public Container pane;
	public LevelStage levels;
	public CardLayout cl = new CardLayout();
	
	public Screen() {
		menu = new MainMenu(this);
		levels = new LevelStage(this);
		setTitle("Boxhead: Apocalypse");
		setSize(HEIGHT, WIDTH);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = getContentPane();
		pane.setLayout(cl);
		pane.add(menu, "menu");
		pane.add(levels, "levels");
		pane.setVisible(true);
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		time.start();
		addKeyListener(new Input(this));
	}

	public static void main(String[] args) {
		Screen screen = new Screen();
	}

	// public void paint(Graphics g) {
	// g.clearRect(0, 0, WIDTH, HEIGHT);
	// player.draw(g);
	// }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();

	}

	private void update() {
		player.movement();

	}

}
