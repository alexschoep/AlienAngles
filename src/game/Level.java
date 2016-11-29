package game;

import java.util.Random;

public class Level {
	private int levelAngle;
	private Alien alien;
	private Missile missile;
	private boolean passFail;
	private int precision;
	
	public void setAngle(int angle) {
		//sets levelAngle for testing purposes
	}
	
	public Level() {
		Random random = new Random();
		levelAngle = random.nextInt(181);
		alien = new Alien(Game.gameRadius*Math.cos((double) levelAngle), Game.gameRadius*Math.sin((double) levelAngle));
		missile = new Missile();
	}
	
	public int getLevelAngle() {
		return levelAngle;
	}
	
	public int getPrecision() {
		return precision;
	}
	
	public Missile getMissile() {
		return missile;
	}
	
	public Alien getAlien() {
		return alien;
	}
	
	public void draw() {
		//draws the level
		//calls missile.draw and alien.draw
	}
	
	public void moveMissile(int angle) {
		missile.changePosition(angle);
		if (alien.checkHit(missile.getXPos(), missile.getYPos())) {
			alien.killAlien();
			missile.detonate();
		}
	}

	public boolean isPassFail() {
		return passFail;
	}

	public void setPassFail(boolean passFail) {
		this.passFail = passFail;
	}
}
