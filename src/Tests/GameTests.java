package tests;
import static org.junit.Assert.*;
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
		boolean missileHitTest = false;
		Level level = new Level();
		level.setAngle(60);
		for (int i = 0; i < 100; i++) {
			level.moveMissile();
			
			if (level.getMissile().missileHit()) {
				missileHitTest = true;
			}
		}
		assertTrue(missileHitTest);
		
		//test if alien does not die on miss
		//test if missile does not detonate on miss
	}
	
	@Test
	public void missileMoveTests() {
		//test if missile moves along correct path
		//test if missile reaches alien when levelAngle and userAngle are equal
		//test tolerance of missile hit
	}
	
	@Test
	public void quizTests() {
		//test if checkAnswer returns true on correct answer
		//test if checkAnswer returns false on wrong answer
		//test if checkAnswers determines correct score
		
	}
}
