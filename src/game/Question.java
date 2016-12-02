package game;
import java.util.Random;
import javax.swing.JPanel;

public class Question{
	private String question;
	private String rightAnswer;
	private String wrongAnswer;
	
	public Question(int angle) {
		//takes angle from level and makes a question, a right answer, and a wrong answer
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
