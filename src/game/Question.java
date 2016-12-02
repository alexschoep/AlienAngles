package game;
import javax.swing.JPanel;

public class Question extends JPanel{
	private String question;
	private String rightAnswer;
	private String wrongAnswer;
	
	public Question(int angle) {
		//takes angle from level and makes a question, a right answer, and a wrong answer
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
		return rightAnswer.equals(answer);
	}

	public void setAnswer(String string) {
		rightAnswer = string;
		
	}
}
