package game;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel{
	private int userAngle;
	private int precision;
	private int progress = 0;
	
	public ControlPanel() {
		setLayout(new GridLayout(4, 1));
		JTextField angleField = new JTextField();
		JTextField precisionField = new JTextField(precision);
		precisionField.setEditable(false);
		JTextField progressField = new JTextField(progress + " / " + Game.numLevels);
		progressField.setEditable(false);
		JButton launchButton = new JButton("LAUNCH");
		add(angleField);
		add(precisionField);
		add(progressField);
		add(launchButton);
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
