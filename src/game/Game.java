package game;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame{
	public static final int tolerance = 5;
	public static final int gameRadius = 300;
	public static Game instance;
	public final int numLevels = 5;
	private ArrayList<Level> levels;
	private Quiz quiz;
	private ControlPanel controlPanel;
	
	public Game getGame() {
		return instance;
	}
	
	public Game() {
		controlPanel = new ControlPanel();
		quiz = new Quiz();
		levels = new ArrayList<Level>();
		levels.add(new Level());
		levels.add(new Level());
		levels.add(new Level());
		levels.add(new Level());
		//game constructor
	}
	
	public void drawBoard() {
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
}
