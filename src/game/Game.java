package game;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame{
	public static final int tolerance = 10;
	public static Game instance;
	public final int numLevels = 5;
	private ArrayList<Level> levels;
	private Quiz quiz;
	private ControlPanel controlPanel;
	
	public Game getGame() {
		return instance;
	}
	
	public Game() {
		//game constructor
	}
	
	public void drawBoard() {
		//calls draw for each level
		//calls draw for control panel
		//draws background
	}
	
	public ArrayList<Level> getLevels() {
		return null;
	}
	
	public ControlPanel getControlPanel() {
		return null;
	}
}
