package game;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Quiz extends JPanel{
	private ArrayList<Question> quizQuestions;
	private int score;
	private Game game;
	
	public Quiz(Game game) {
		quizQuestions = new ArrayList<Question>();
		for (int i = 0; i < Game.numLevels; i++) {
			quizQuestions.add(game.getLevels().get(i).getQuestion());
		}
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