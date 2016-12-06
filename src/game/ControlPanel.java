package game;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel{
	private int userAngle;
	private int precision;
	private int progress = 0;
	
	private JTextField angleGuess;
	private JTextField precisionField;
	private JTextField progressField;
	
	public ControlPanel() {
		setLayout(new GridLayout(1, 4));
		
		Dimension d = new Dimension(225,100);
		JButton launchButton = new JButton("LAUNCH");
		launchButton.setPreferredSize(d);
		launchButton.addActionListener(null);
		
		
		add(createAngleField());
		add(createPrecisionField());
		add(createLevelField());
		add(launchButton);
		
		
		setVisible(true);
	}
	
	private JPanel createAngleField() {
		JLabel label = new JLabel("Angle Guess");
		this.angleGuess = new JTextField(30);
		this.angleGuess.setEditable(true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(label);
		panel.add(this.angleGuess);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Angle"));
		return panel;
	}

	private JPanel createPrecisionField() {
		JLabel label = new JLabel("Precision");
		this.precisionField = new JTextField(30);
		this.precisionField.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(label);
		panel.add(this.precisionField);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Precision"));
		return panel;
	}
	
	private JPanel createLevelField() {
		JLabel label = new JLabel("Progress");
		this.progressField = new JTextField(progress + " / " + Game.numLevels);
		this.progressField.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(label);
		panel.add(this.progressField);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Progress"));
		return panel;
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
