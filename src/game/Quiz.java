package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Quiz extends JDialog {
	private ArrayList<Question> quizQuestions;
	private int score;
	private Game game;
	JButton submitButton;
	
	public Quiz(Game game) {
		quizQuestions = new ArrayList<Question>();
		for (int i = 0; i < Game.numLevels; i++) {
			quizQuestions.add(game.getLevels().get(i).getQuestion());
		}
		
		setTitle("Quiz");
		setSize(800, 600);
		setLayout(new GridLayout(quizQuestions.size() + 1, 1));
		
		for (Question question : quizQuestions) {
			add(question);
		}
		submitButton = new JButton("Submit");
		add(submitButton);
		
		ButtonListener submitButtonListener = new ButtonListener();
		submitButton.addActionListener(submitButtonListener);
	}
	
	public void checkAnswers() {
		//calls checkAnswer for each Question in quizQuestions
		//increments score for each correct answer
		for (Question question : quizQuestions) {
			if (question.checkAnswer()) {
				score++;
			}
		}
	}
	
	public int getScore() {
		return score;
	}

	public ArrayList<Question> getQuestions() {
		return quizQuestions;
	}
	
	private class ButtonListener implements ActionListener {
		private ButtonListener() {}
		public void actionPerformed(ActionEvent e) {
			checkAnswers();
			System.out.println("your score is " + getScore());
		}
	}
}