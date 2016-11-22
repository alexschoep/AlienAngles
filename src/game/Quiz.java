package game;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Quiz extends JPanel{
	private ArrayList<Question> quizQuestions;
	private int score;
	
	public Quiz() {
		//populates quizQuestions with Question for each level
	}
	
	public void draw() {
	}
	
	public void checkAnswers() {
		//calls checkAnswer for each Question in quizQuestions
		//increments score for each correct answer
	}
	
	public int getScore() {
		return score;
	}
	
	//there will be an action listener in this class, questions can just be radio buttons
}