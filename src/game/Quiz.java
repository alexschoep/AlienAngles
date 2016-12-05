package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Quiz extends JDialog{
	private ArrayList<Question> quizQuestions;
	private int score;
	private Game game;
	
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
		JButton submitButton = new JButton("Submit");
		add(submitButton);
	}
	
	public void checkAnswers() {
		//calls checkAnswer for each Question in quizQuestions
		//increments score for each correct answer
	}
	
	public int getScore() {
		return score;
	}

	public ArrayList<Question> getQuestions() {
		return quizQuestions;
	}
	
	//there will be an action listener in this class, questions can just be radio buttons
}