package game;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel{
	//sets our vars
	private int userAngle;
	private int precision;
	private int progress = 1;
	private boolean launched = false;
	
	private JTextField angleGuess;
	private JTextField precisionField;
	private JTextField progressField;
	public JButton launchButton;
	Game game;
	
	public ControlPanel(Game game) {
		this.game = game;
		//set the layout
		setLayout(new GridLayout(1, 4));
		//manually give more height
		Dimension d = new Dimension(225,100);
		//launch button
		JButton launchButton = new JButton("LAUNCH");
		launchButton.setPreferredSize(d);
		ButtonListener launchButtonListener = new ButtonListener();
		launchButton.addActionListener(launchButtonListener);
		//add to the panel with functions
		add(createAngleField());
		add(createPrecisionField());
		add(createLevelField());
		add(launchButton);
		
		setVisible(true);
	}
	
	//buton listener to check when launch is hit what happens
	private class ButtonListener implements ActionListener {
		private ButtonListener() {}
		public void actionPerformed(ActionEvent e) {
			try {
				userAngle = (int) Integer.parseInt(angleGuess.getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(launchButton, "You must enter a launch angle!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//add launch sequence 
			if(launched) {
				//open dialog
				JOptionPane.showMessageDialog(launchButton, "Launch sequence already commenced. Please wait!", "Alert", JOptionPane.INFORMATION_MESSAGE);
			} else {
				angleGuess.setEditable(false);
				launched = true;
				game.getDisplay().protractorVisible(true);
				for (int i = 0; i < Game.gameRadius; i++) {
					try
					{
					     Thread.sleep(1);
					}
					catch (Exception ev)
					{
					     ev.printStackTrace();
					}
					//this repaints to give a trail to the rocket
					game.getLevels().get(progress - 1).moveMissile(userAngle);
					game.getDisplay().paintImmediately(0, 0, 900, 900);
				}
			}
		}
	}
	
	
	public JButton getLaunchButton() {
		return launchButton;
	}
	
	private JPanel createAngleField() {
		//creates the angle field with classic layout
		JLabel label = new JLabel("Angle Guess");
		this.angleGuess = new JTextField();
		this.angleGuess.setEditable(true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(label);
		panel.add(this.angleGuess);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Angle"));
		return panel;
	}

	private JPanel createPrecisionField() {
		//creates the precision field with classic layout
		JLabel label = new JLabel("Precision");
		this.precisionField = new JTextField(precision);
		this.precisionField.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(label);
		panel.add(this.precisionField);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Precision"));
		return panel;
	}
	
	private JPanel createLevelField() {
		//creates the level field with classic layout
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
		setPrecision(precision);
		precisionField.setText(Integer.toString(precision));
		progressField.setText(progress + " / " + Game.numLevels);
		if (game.getLevels().get(progress - 1).passed()) {
			JOptionPane.showMessageDialog(launchButton, "Hit!", "Alert", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(launchButton, "Miss!", "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
		progress++;
		launched = false;
		angleGuess.setEditable(true);
		game.getDisplay().protractorVisible(false);
		if (progress == Game.numLevels + 1) {
			game.quizSetVisible(true);
		}
		game.repaint();
		
	}

	public void setUserAngle(int userAngle) {
		this.userAngle = userAngle;
	}


	
}
