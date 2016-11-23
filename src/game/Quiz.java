package game;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Quiz extends JPanel{
	private ArrayList<Question> quizQuestions;
	private int score;
	
	public Quiz() {
		quizQuestions = new ArrayList<Question>();
		quizQuestions.add(new Question(0));
		quizQuestions.add(new Question(1));
		
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

	public ArrayList<Question> getQuestions() {
		return quizQuestions;
	}
	
	//there will be an action listener in this class, questions can just be radio buttons
}