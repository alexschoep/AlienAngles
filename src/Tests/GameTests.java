package Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
import game.*;

public class GameTests {
	private static Game game;
	
	@Before
	public void setup() {
		game = new Game();
	}
	
	@Test
	public void missileHitTests() {
		//test if alien dies on hit
		//test if missile detonates on hit
		Level level = new Level();
		level.setAngle(60);
		for (int i = 0; i < 1000; i++) {
			level.moveMissile(60);
		}
		assertFalse(level.getAlien().alive());
		assertTrue(level.getMissile().missileHit());
		
		//test if alien does not die on miss
		//test if missile does not detonate on miss
		level = new Level();
		level.setAngle(60);
		for (int i = 0; i < 1000; i++) {
			level.moveMissile(30);
		}
		assertTrue(level.getAlien().alive());
		assertFalse(level.getMissile().missileHit());
	}
	
	@Test
	public void missileMoveTests() {
		//test missile movement at 90
		Level level = new Level();
		//test one missile move
		level.moveMissile(90);
		assertTrue(Math.abs(level.getMissile().getXPos() - 0) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 1) <= .001);
		//test missile move to end of protractor
		for (int i = 0; i < 299; i++) {
			level.moveMissile(90);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - 0) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300) <= .001);
		
		//test missile movement at 0
		level = new Level();
		level.moveMissile(0);
		assertTrue(Math.abs(level.getMissile().getXPos() - 1) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 0) <= .001);
		for (int i = 0; i < 299; i++) {
			level.moveMissile(0);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - 300) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 0) <= .001);
		
		//test missile movement at 45
		level = new Level();
		level.moveMissile(45);
		assertTrue(Math.abs(level.getMissile().getXPos() - .7072) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - .7072) <= .001);
		for (int i = 0; i < 299; i++) {
			level.moveMissile(90);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - 300*0.7072) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300*0.7072) <= .001);
		
		//test missile movement at 60
		level = new Level();
		level.moveMissile(60);
		assertTrue(Math.abs(level.getMissile().getXPos() - .5) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - .8660) <= .001);
		for (int i = 0; i < 299; i++) {
			level.moveMissile(90);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - 300*.5) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300*.8660) <= .001);

	}
		
	@Test
	public void quizTests() {
		Quiz quiz = game.getQuiz();
		ArrayList<Question> quizQuestions = quiz.getQuestions();
		//test if checkAnswer returns true on correct answer
		Question questionOne = quizQuestions.get(0);
		questionOne.setAnswer("Nonsense");
		boolean checkOne = questionOne.checkAnswer("Nonsense");
		assertTrue(checkOne);
		//test if checkAnswer returns false on wrong answer
		Question questionTwo = quizQuestions.get(1);
		questionTwo.setAnswer("Nonsense");
		boolean checkTwo = questionTwo.checkAnswer("Not Nonsense");
		assertFalse(checkTwo);
		//test if checkAnswers determines correct score
		int counter = 0;
		for(int i = 0; i < quizQuestions.size(); i++) {
			quizQuestions.get(i).setAnswer("Answer");
			if(quizQuestions.get(i).checkAnswer("Answer")) {
				counter++;
			}
		}
		assertEquals(counter, quizQuestions.size());
	}
	
	@Test
	public void controlPanelTest() {
		//Progress Panel Tests
		//tests that we progress through the game
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(0).moveMissile(game.getLevels().get(0).getLevelAngle());
		}
		assertTrue(game.getControlPanel().getProgress() == 1);
		assertTrue(game.getLevels().get(0).isPassFail());
		
		//tests that we progress when we miss and level is a fail
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(1).moveMissile(game.getLevels().get(1).getLevelAngle() + 20);
		}
		assertTrue(game.getControlPanel().getProgress() == 1);
		assertFalse(game.getLevels().get(1).isPassFail());
		
		
		//Precision Panel Tests
		//tests precision on hit
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(2).moveMissile(game.getLevels().get(2).getLevelAngle());
		}
		assertTrue(game.getLevels().get(2).getPrecision() == game.getControlPanel().getPrecision());
		assertTrue(game.getLevels().get(2).getPrecision() <= game.tolerance);
		
		//tests precision on miss
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(2).moveMissile(game.getLevels().get(2).getLevelAngle() + 20);
		}
		assertTrue(game.getLevels().get(2).getPrecision() == game.getControlPanel().getPrecision());
		assertFalse(game.getLevels().get(2).getPrecision() <= game.tolerance);
	}
}
