package Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

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
		Level level = new Level(60, game);
		for (int i = 0; i < 300; i++) {
			level.moveMissile(60);
		}
		
		assertFalse(level.getAlien().alive());
		assertTrue(level.getMissile().missileHit());
		
		//test if alien does not die on miss
		//test if missile does not detonate on miss
		level = new Level(60, game);
		for (int i = 0; i < 300; i++) {
			level.moveMissile(30);
		}
		assertTrue(level.getAlien().alive());
		assertFalse(level.getMissile().missileHit());
	}
	
	@Test
	public void missileMoveTests() {
		//test missile movement at 90
		Level level = new Level(game);
		//test one missile move
		level.moveMissile(90);
		assertTrue(Math.abs(level.getMissile().getXPos() - Game.gameRadius) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 1) <= .001);
		//test missile move to end of protractor
		for (int i = 0; i < 299; i++) {
			level.moveMissile(90);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - Game.gameRadius) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300) <= .001);
		
		//test missile movement at 0
		level = new Level(game);
		level.moveMissile(0);
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + 1)) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 0) <= .001);
		for (int i = 0; i < 299; i++) {
			level.moveMissile(0);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + 300)) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 0) <= .001);
		
		//test missile movement at 45
		level = new Level(game);
		level.moveMissile(45);
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + Math.cos(Math.toRadians(45)))) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - Math.sin(Math.toRadians(45))) <= .001);
		
		for (int i = 0; i < 299; i++) {
			level.moveMissile(45);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + 300*Math.cos(Math.toRadians(45)))) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300*Math.sin(Math.toRadians(45))) <= .001);
		
		//test missile movement at 60
		level = new Level(game);
		level.moveMissile(60);
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + Math.cos(Math.toRadians(60)))) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - Math.sin(Math.toRadians(60))) <= .001);
		for (int i = 0; i < 299; i++) {
			level.moveMissile(60);
		}
		assertTrue(Math.abs(level.getMissile().getXPos() - (Game.gameRadius + 300*Math.cos(Math.toRadians(60)))) <= .001);
		assertTrue(Math.abs(level.getMissile().getYPos() - 300*Math.sin(Math.toRadians(60))) <= .001);

	}
		
	@Test
	public void quizTests() {
		Quiz quiz = game.getQuiz();
		ArrayList<Question> quizQuestions = new ArrayList<Question>();
		quizQuestions.add(new Question(0, 1));
		quizQuestions.add(new Question(0, 2));
		quizQuestions.add(new Question(0, 3));
		quizQuestions.add(new Question(0, 3));
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
		game.getControlPanel().setUserAngle(game.getLevels().get(0).getLevelAngle());
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(0).moveMissile(game.getLevels().get(0).getLevelAngle());
		}
		assertTrue(game.getControlPanel().getProgress() == 2);
		assertTrue(game.getLevels().get(0).passed());
		
		//tests that we progress when we miss and level is a fail
		game.getControlPanel().setUserAngle(game.getLevels().get(1).getLevelAngle() + 20);
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(1).moveMissile(game.getLevels().get(1).getLevelAngle() + 20);
		}
		assertTrue(game.getControlPanel().getProgress() == 1);
		assertFalse(game.getLevels().get(1).passed());
		
		
		//Precision Panel Tests
		//tests precision on hit
		game.getControlPanel().setUserAngle(game.getLevels().get(2).getLevelAngle());
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(2).moveMissile(game.getLevels().get(2).getLevelAngle());
		}
		assertTrue(game.getLevels().get(2).getPrecision() == game.getControlPanel().getPrecision());
		assertTrue(game.getLevels().get(2).getPrecision() <= Game.tolerance);
		
		//tests precision on miss
		game.getControlPanel().setUserAngle(game.getLevels().get(3).getLevelAngle() + 20);
		for (int i = 0; i < 300; i++) {
			game.getLevels().get(3).moveMissile(game.getLevels().get(3).getLevelAngle() + 20);
		}
		assertTrue(game.getLevels().get(3).getPrecision() == game.getControlPanel().getPrecision());
		assertFalse(game.getLevels().get(3).getPrecision() <= Game.tolerance);
	}
}
