package game;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	private int userAngle;
	private int precision;
	private int progress;
	
	public ControlPanel() {
		progress = 0;
	}
	
	public void draw() {
	}
	
	public int getUserAngle() {
		return userAngle;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getProgress() {
		return progress;
	}

	public void incProgress(int precision) {
		progress++;
		setPrecision(precision);
	}

	public void setUserAngle(int userAngle) {
		this.userAngle = userAngle;
	}
	
	//action listener in this class
}
