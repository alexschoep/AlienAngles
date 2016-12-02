package game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame{
	public static final int tolerance = 5;
	public static final int gameRadius = 300;
	public static final int numLevels = 5;
	public static Game instance;
	private ArrayList<Level> levels;
	private Quiz quiz;
	private ControlPanel controlPanel;
	
	public static Game getInstance() {
		return instance;
	}
	
	public Game() {
		setSize(1000, 1000);
		setTitle("Alien Angles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlPanel = new ControlPanel();
		levels = new ArrayList<Level>();
		for (int i = 0; i < numLevels; i++) {
		levels.add(new Level(this));
		}
		
		quiz = new Quiz(this);
		//game constructor
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		repaint();
		//calls draw for each level
		//calls draw for control panel
		//draws background
		
	}
	
	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	public ControlPanel getControlPanel() {
		return controlPanel;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setVisible(true);
	}
}
