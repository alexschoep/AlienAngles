package game;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Question extends JPanel {
	private String question;
	private String rightAnswer;
	private String wrongAnswer;
	private int questionNumber;
	private JRadioButton rightAnswerButton;
	private JRadioButton wrongAnswerButton;
	ButtonGroup bg;
	private boolean answerCorrect = false;
	
	//randomly generates a question from 3 possible question types
	//creates a question panel
	public Question(int angle, int questionNumber){
		//takes angle from level and makes a question, a right answer, and a wrong answer
		this.questionNumber = questionNumber;
		Random random = new Random();
		int rand = random.nextInt(3);
		switch(rand) {
			case 0:
				question = "Classify the angle of " + angle + " degrees.";
				if (angle < 90) {
					rightAnswer = "acute";
					wrongAnswer = "obtuse";
				} else if (angle == 90) {
					rightAnswer = "right";
					wrongAnswer = "straight";
				} else if (angle < 180){
					rightAnswer = "obtuse";
					wrongAnswer = "acute";
				} else
					rightAnswer = "straight";
					wrongAnswer = "right";
				break;
				
			case 1:
				question = "What is the supplement of a " + angle + " degree angle?";
				rightAnswer = new Integer(180 - angle).toString();
				wrongAnswer = new Integer(random.nextInt(180)).toString();
				break;
				
			case 2:
				question = "If a triangle has one angle of 10 degrees and another angle of " + angle + ", what is the third angle?";
				if (angle > 169) {
					rightAnswer = "impossible";
					wrongAnswer = new Integer(random.nextInt(91)).toString();
				} else {
					rightAnswer = new Integer(170 - angle).toString();
					wrongAnswer = new Integer(random.nextInt(91)).toString();
				}
		}
		
		setLayout(new GridLayout(3, 1));
	 	JTextField questionField = new JTextField(question, SwingConstants.LEFT);
	 	questionField.setEditable(false);
		rightAnswerButton = new JRadioButton(rightAnswer);
		wrongAnswerButton = new JRadioButton(wrongAnswer);
		bg = new ButtonGroup();
		bg.add(rightAnswerButton);
		bg.add(wrongAnswerButton);
		add(questionField);
		add(rightAnswerButton);
		add(wrongAnswerButton);
		setBorder(new TitledBorder (new EtchedBorder(), "Question " + questionNumber));
		RadioButtonListener answerButtonListener = new RadioButtonListener();
		rightAnswerButton.addActionListener(answerButtonListener);
		wrongAnswerButton.addActionListener(answerButtonListener);
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return rightAnswer;
	}
	
	public String getWrongAnswer() {
		return wrongAnswer;
	}
	
	public boolean checkAnswer(String answer) {
		return answer.equals(rightAnswer);
	}
	
	public boolean checkAnswer() {
		return answerCorrect;
	}

	public void setAnswer(String string) {
		rightAnswer = string;
		
	}
	
	private class RadioButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (rightAnswerButton.isSelected()) {
				answerCorrect = true;
			} else {
				answerCorrect = false;
			}
		}
		
	}
}
